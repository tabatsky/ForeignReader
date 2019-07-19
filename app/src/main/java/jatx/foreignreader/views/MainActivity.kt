package jatx.foreignreader.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*
import com.obsez.android.lib.filechooser.ChooserDialog
import android.os.Environment
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import jatx.foreignreader.R
import jatx.foreignreader.adapters.ContentsAdapter
import jatx.foreignreader.adapters.ParagraphsAdapter
import jatx.foreignreader.models.Chapter
import jatx.foreignreader.models.Paragraph
import jatx.foreignreader.models.ParagraphType
import jatx.foreignreader.utils.readFb2File
import jatx.foreignreader.utils.readTxtFile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val ENGLISH = 0
        const val DEUTSCH = 1
    }

    private val paragraphList = arrayListOf<Paragraph>()
    private val chapterList = arrayListOf<Chapter>()
    private var currentPath: String? = null

    private lateinit var rvParagraphsAdapter: ParagraphsAdapter
    private lateinit var rvContentsAdapter: ContentsAdapter
    private lateinit var drawerToggle: ActionBarDrawerToggle

    private val rvParagraphsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private val rvContentsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        initRVParagraphs()
        initRVContents()
        initSpinnerLanguage()
        initButtonOpenFile()
        loadCurrentPath()
        loadLanguage()
        loadFileOrDefaultText()
    }

    private fun initDrawer() {
        setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayShowTitleEnabled(true)
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar,
            R.string.open,
            R.string.close
        )
        //drawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu)
        drawerToggle.syncState()
        drawer_layout.addDrawerListener(drawerToggle)
    }

    private fun initRVParagraphs() {
        rvParagraphsAdapter = ParagraphsAdapter()
        rv_paragraphs.apply {
            this.layoutManager = rvParagraphsLayoutManager
            this.adapter = rvParagraphsAdapter
            this.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val line = rvParagraphsLayoutManager.findFirstVisibleItemPosition()
                    currentPath?.apply {
                        savePositionForFile(this, line)
                    }
                }
            })
        }
    }

    private fun initRVContents() {
        rvContentsAdapter = ContentsAdapter()
        rvContentsAdapter.onChapterClickListener = object : ContentsAdapter.OnChapterClickListener {
            override fun onChapterClick(chapter: Chapter) {
                rvParagraphsLayoutManager.scrollToPositionWithOffset(chapter.position, 0)
                drawer_layout.closeDrawer(Gravity.START)
            }
        }
        rv_contents.apply {
            this.layoutManager = rvContentsLayoutManager
            this.adapter = rvContentsAdapter
        }
    }


    private fun initSpinnerLanguage() {
        spinner_language.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                setLanguage(position)
                saveLanguage()
            }
        }
    }

    private fun initButtonOpenFile() {
        button_open_file.setOnClickListener {
            ChooserDialog(this@MainActivity)
                .withFilter(false, false, "txt", "fb2")
                .withStartFile(Environment.getExternalStorageDirectory().absolutePath)
                .withChosenListener { path, pathFile ->
                    loadFile(path)
                }
                // to handle the back key pressed or clicked outside the dialog:
                .withOnCancelListener { dialog ->
                    Log.e("CANCEL", "CANCEL")
                    dialog.cancel() // MUST have
                }
                .build()
                .show()
        }
    }

    private fun loadFileOrDefaultText() {
        try {
            loadFile(currentPath!!)
        } catch (t: Throwable) {
            t.printStackTrace()
            val sc = Scanner(resources.openRawResource(R.raw.sample))
            while (sc.hasNextLine()) {
                val line =
                    Paragraph(sc.nextLine(), ParagraphType.TEXT)
                paragraphList.add(line)
            }
            sc.close()
            rvParagraphsAdapter.setParagraphList(paragraphList)
        }
    }

    private fun loadFile(path: String) {
        currentPath = path
        saveCurrentPath()
        if (path.endsWith(".txt")) {
            paragraphList.clear()
            paragraphList.addAll(readTxtFile(path))
            rvContentsAdapter.setChapterList(null)
        } else if (path.endsWith(".fb2")) {
            paragraphList.clear()
            chapterList.clear()
            val result = readFb2File(path)
            paragraphList.addAll(result.first)
            chapterList.addAll(result.second)
            rvContentsAdapter.setChapterList(chapterList)
        }
        rvParagraphsAdapter.setParagraphList(paragraphList)
        rvParagraphsLayoutManager.scrollToPositionWithOffset(getPositionForFile(path), 0)
    }

    private fun savePositionForFile(path: String, line: Int) {
        //Log.e("savePositionForFile", "$path: $position")
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putInt("position_$path", line)
        editor.apply()
    }

    private fun getPositionForFile(path: String): Int {
        //Log.e("getPositionForFile", path)
        val sp = getSharedPreferences("prefs", 0)
        return sp.getInt("position_$path", 0)
    }

    private fun saveCurrentPath() {
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putString("currentPath", currentPath)
        editor.apply()
    }

    private fun loadCurrentPath() {
        val sp = getSharedPreferences("prefs", 0)
        currentPath = sp.getString("currentPath", null)
    }

    private fun saveLanguage() {
        val currentLang = spinner_language.selectedItemPosition
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putInt("currentLang", currentLang)
        editor.apply()
    }

    private fun loadLanguage() {
        val sp = getSharedPreferences("prefs", 0)
        val currentLang = sp.getInt("currentLang", 0)
        spinner_language.setSelection(currentLang)
        setLanguage(currentLang)
    }

    private fun setLanguage(position: Int) {
        when (position) {
            ENGLISH -> ParagraphsAdapter.direction = ParagraphsAdapter.DIRECTION_EN_RU
            DEUTSCH -> ParagraphsAdapter.direction = ParagraphsAdapter.DIRECTION_DE_RU
        }
    }
}
