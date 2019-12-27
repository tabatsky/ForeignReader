package jatx.foreignreader.ui

import android.os.Bundle
import android.widget.*
import com.obsez.android.lib.filechooser.ChooserDialog
import android.os.Environment
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.Lazy
import jatx.clickablewordstextview.onWordClickListener
import jatx.filereader.*
import jatx.foreignreader.App
import jatx.foreignreader.R
import jatx.foreignreader.adapters.ContentsAdapter
import jatx.foreignreader.adapters.ParagraphsAdapter
import jatx.foreignreader.adapters.onChapterClickListener
import jatx.foreignreader.extensions.setOnItemSelectedListener
import jatx.foreignreader.presentation.MainPresenter
import jatx.foreignreader.presentation.MainView
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {
    @Inject
    lateinit var rvParagraphsAdapter: ParagraphsAdapter
    @Inject
    lateinit var rvContentsAdapter: ContentsAdapter

    @Inject lateinit var presenterProvider: Lazy<MainPresenter>
    private val presenter by moxyPresenter { presenterProvider.get() }

    private lateinit var drawerToggle: ActionBarDrawerToggle

    private val rvParagraphsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private val rvContentsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        initRVParagraphs()
        initRVContents()
        spinnerLanguage.setOnItemSelectedListener { presenter.onChangeLanguage(it) }
        btnOpenFile.setOnClickListener { presenter.onBtnOpenFileClick() }
    }

    override fun showTranslation(word: String, translation: String) {
        showTranslationDialog(this, word, translation)
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun setParagraphs(paragraphs: List<Paragraph>) {
        rvParagraphsAdapter.paragraphs = paragraphs
    }

    override fun setChapters(chapters: List<Chapter>) {
        rvContentsAdapter.chapters = chapters
    }

    override fun scrollToActualPosition(paragraphPosition: Int) {
        rvParagraphsLayoutManager.scrollToPositionWithOffset(paragraphPosition, 0)
    }

    override fun showSpinnerLanguageActualState(position: Int) {
        spinnerLanguage.setSelection(position)
    }

    override fun showFileSelectDialog() {
        ChooserDialog(this)
            .withFilter(false, false, "txt", "fb2")
            .withStartFile(Environment.getExternalStorageDirectory().absolutePath)
            .withChosenListener { path, _ ->
                presenter.loadFile(path)
            }
            .withOnCancelListener { dialog ->
                dialog.cancel()
            }
            .build()
            .show()
    }

    override fun updateActiveChapter(paragraphPosition: Int) {
        rvContentsAdapter.activeParagraphPosition = paragraphPosition
        rvContentsLayoutManager.scrollToPositionWithOffset(rvContentsAdapter.activeChapterPosition, 0)
    }

    private fun initDrawer() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.open,
            R.string.close
        )
        drawerToggle.syncState()
        drawerLayout.addDrawerListener(drawerToggle)
    }

    private fun initRVParagraphs() {
        rvParagraphs.apply {
            this.layoutManager = rvParagraphsLayoutManager
            this.adapter = rvParagraphsAdapter
            this.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val paragraphPosition = rvParagraphsLayoutManager.findFirstVisibleItemPosition()
                    presenter.onActiveParagraphChanged(paragraphPosition)
                }
            })
        }

        rvParagraphsAdapter.onWordClickListener = onWordClickListener { presenter.onWordClick(it) }
    }

    private fun initRVContents() {
        rvContents.apply {
            this.layoutManager = rvContentsLayoutManager
            this.adapter = rvContentsAdapter
        }

        rvContentsAdapter.onChapterClickListener = onChapterClickListener {
            rvContentsAdapter.activeChapterPosition = it.number
            rvParagraphsLayoutManager.scrollToPositionWithOffset(it.position, 0)
            drawerLayout.closeDrawer(GravityCompat.START)
        }
    }
}
