package jatx.foreignreader.presentation

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import jatx.clickablewordstextview.Word
import jatx.bookreader.BookReader
import jatx.bookreader.Paragraph
import jatx.bookreader.ParagraphType
import jatx.foreignreader.R
import jatx.foreignreader.prefs.Prefs
import jatx.yandexdictionaryclient.YandexDictionaryClient
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val context: Context,
    private val yandexDictionaryClient: YandexDictionaryClient,
    private val bookReader: BookReader,
    private val prefs: Prefs
) : MvpPresenter<MainView>() {
    private var publishSubject = PublishSubject.create<Word>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        subscribeToPublishSubject()
        loadFileOrDefaultText()
        viewState.showSpinnerLanguageActualState(prefs.language)
    }

    fun onWordClick(word: Word) {
        publishSubject.onNext(word)
    }

    fun onChangeLanguage(position: Int) {
        prefs.language = position
    }

    fun onBtnOpenFileClick() {
        viewState.showFileSelectDialog()
    }

    fun loadFile(path: String) {
        try {
            prefs.currentPath = path
            val book = if (path.endsWith(".txt")) {
                bookReader.readTxtFile(path)
            } else if (path.endsWith(".fb2")) {
                bookReader.readFb2File(path)
            } else if (path.endsWith(".fb2.zip")) {
                bookReader.readFb2ZipFile(path)
            } else {
                viewState.showToast(context.getString(R.string.unsupported_file_format))
                null
            }
            book?.apply {
                viewState.setParagraphs(paragraphs)
                viewState.setChapters(chapters)
            }
            viewState.scrollToActualPosition(prefs.getPositionForFile(path))
            viewState.updateActiveChapter(prefs.getPositionForFile(path))
        } catch (t: Throwable) {
            t.printStackTrace()
            viewState.showToast(context.getString(R.string.file_reading_error))
            loadDefaultText()
        }
    }

    fun onActiveParagraphChanged(paragraphPosition: Int) {
        savePositionForFile(paragraphPosition)
        viewState.updateActiveChapter(paragraphPosition)
    }

    private fun loadFileOrDefaultText() {
        prefs.currentPath?.apply { loadFile(this) } ?: loadDefaultText()
    }

    private fun loadDefaultText() {
        val paragraphs = arrayListOf<Paragraph>()
        val sc = Scanner(context.resources.openRawResource(R.raw.sample))
        while (sc.hasNextLine()) {
            val paragraph = Paragraph(sc.nextLine(), ParagraphType.TEXT)
            paragraphs.add(paragraph)
        }
        sc.close()
        viewState.setParagraphs(paragraphs)
        viewState.setChapters(listOf())
    }

    private fun subscribeToPublishSubject() {
        if (!publishSubject.hasComplete()) {
            publishSubject.onComplete()
        }
        publishSubject = PublishSubject.create<Word>()
        publishSubject
            .debounce(1000, TimeUnit.MILLISECONDS)
            .subscribeOn(Schedulers.io())
            .flatMap { word -> Observable
                .fromCallable{ yandexDictionaryClient.lookup(word.text, prefs.translateDirection) }
                .subscribeOn(Schedulers.io())}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                println(result)
                viewState.showTranslation(result.original, "${result.translations}")
            }, { error ->
                error.printStackTrace()
                viewState.showToast(context.getString(R.string.api_access_error))
                subscribeToPublishSubject()
            })
    }

    private fun savePositionForFile(paragraphPosition: Int) {
        prefs.currentPath?.apply {
            prefs.savePositionForFile(this, paragraphPosition)
        }
    }
}