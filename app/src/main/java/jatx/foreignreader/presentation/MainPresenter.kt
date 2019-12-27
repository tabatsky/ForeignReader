package jatx.foreignreader.presentation

import android.content.Context
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import jatx.clickablewordstextview.Word
import jatx.filereader.FileReader
import jatx.filereader.Paragraph
import jatx.filereader.ParagraphType
import jatx.foreignreader.R
import jatx.foreignreader.prefs.Prefs
import jatx.yandexdictionaryclient.TranslateDirection
import jatx.yandexdictionaryclient.YandexDictionaryClient
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.*
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(
    private val context: Context,
    private val yandexDictionaryClient: YandexDictionaryClient,
    private val fileReader: FileReader,
    private val prefs: Prefs
) : MvpPresenter<MainView>() {
    private var publishSubject = PublishSubject.create<Word>()
    private var translateDirection = TranslateDirection.EN_RU

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        subscribeToPublishSubject()
        loadFileOrDefaultText()
        onChangeLanguage(prefs.language)
        viewState.showSpinnerLanguageActualState(prefs.language)
    }

    fun onWordClick(word: Word) {
        publishSubject.onNext(word)
    }

    fun onChangeLanguage(position: Int) {
        when (position) {
            0 -> translateDirection = TranslateDirection.EN_RU
            1 -> translateDirection = TranslateDirection.DE_RU
        }
        prefs.language = position
    }

    fun onBtnOpenFileClick() {
        viewState.showFileSelectDialog()
    }

    fun loadFile(path: String) {
        prefs.currentPath = path
        if (path.endsWith(".txt")) {
            viewState.setParagraphs(fileReader.readTxtFile(path))
            viewState.setChapters(listOf())
        } else if (path.endsWith(".fb2")) {
            val result = fileReader.readFb2File(path)
            viewState.setParagraphs(result.first)
            viewState.setChapters(result.second)
        }
        viewState.scrollToActualPosition(prefs.getPositionForFile(path))
        viewState.updateActiveChapter(prefs.getPositionForFile(path))
    }

    fun onActiveParagraphChanged(paragraphPosition: Int) {
        savePositionForFile(paragraphPosition)
        viewState.updateActiveChapter(paragraphPosition)
    }

    private fun loadFileOrDefaultText() {
        try {
            loadFile(prefs.currentPath!!)
        } catch (t: Throwable) {
            t.printStackTrace()
            val paragraphArrayList = arrayListOf<Paragraph>()
            val sc = Scanner(context.resources.openRawResource(R.raw.sample))
            while (sc.hasNextLine()) {
                val line = Paragraph(sc.nextLine(), ParagraphType.TEXT)
                paragraphArrayList.add(line)
            }
            sc.close()
            viewState.setParagraphs(paragraphArrayList)
            viewState.setChapters(listOf())
        }
    }

    private fun subscribeToPublishSubject() {
        if (!publishSubject.hasComplete()) {
            publishSubject.onComplete()
        }
        publishSubject = PublishSubject.create<Word>()
        publishSubject
            .subscribeOn(Schedulers.io())
            .flatMap { word -> Observable
                .fromCallable{ yandexDictionaryClient.lookup(word.text, translateDirection) }
                .subscribeOn(Schedulers.io())}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result ->
                println(result)
                viewState.showTranslation(result.first, "${result.second}")
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