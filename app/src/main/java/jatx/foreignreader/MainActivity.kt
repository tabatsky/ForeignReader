package jatx.foreignreader

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.util.*
import android.widget.Toast
import com.obsez.android.lib.filechooser.ChooserDialog
import android.os.Environment
import android.os.PersistableBundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {
    val english = 0
    val deutsch = 1

    val txtList = arrayListOf<Line>()
    val chapterList = arrayListOf<Chapter>()
    var currentLine = 0
    var currentPath: String? = null

    private lateinit var rvAdapter: RVAdapter
    private lateinit var contentsAdapter: ContentsAdapter
    private lateinit var drawerToggle: ActionBarDrawerToggle

    val rvLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    val contentsLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        initRV()
        initContents()
        loadCurrentPath()
        loadLanguage()
        tryReadFile()

        spinner_language.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                setLanguage(position)
                saveLanguage()
            }

        }

        button_open.setOnClickListener {
            ChooserDialog(this@MainActivity)
                .withFilter(false, false, "txt", "fb2")
                .withStartFile(Environment.getExternalStorageDirectory().absolutePath)
                .withChosenListener(object : ChooserDialog.Result {
                    override fun onChoosePath(path: String, pathFile: File) {
                        //Toast.makeText(this@MainActivity, "FILE: $path", Toast.LENGTH_SHORT).show()
                        readFile(path)
                    }
                })
                // to handle the back key pressed or clicked outside the dialog:
                .withOnCancelListener { dialog ->
                    Log.e("CANCEL", "CANCEL")
                    dialog.cancel() // MUST have
                }
                .build()
                .show()
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        drawerToggle.syncState()
    }

    fun tryReadFile() {
        try {
            readFile(currentPath!!)
        } catch (t: Throwable) {
            t.printStackTrace()
            val sc = Scanner(resources.openRawResource(R.raw.sample))
            while (sc.hasNextLine()) {
                val line = Line(sc.nextLine(), LineType.PARAGRAPH)
                txtList.add(line)
            }
            sc.close()
            rvAdapter.setTxtList(txtList)
        }
    }

    fun initDrawer() {
        setSupportActionBar(toolbar)
        //supportActionBar?.setDisplayShowTitleEnabled(true)
        //supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open, R.string.close)
        //drawerToggle.setHomeAsUpIndicator(R.drawable.ic_menu)
        drawerToggle.syncState()
        drawer_layout.addDrawerListener(drawerToggle)
    }

    fun initRV() {
        rvAdapter = RVAdapter()
        rv_main.apply {
            this.layoutManager = rvLayoutManager
            this.adapter = rvAdapter
            this.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    val line = rvLayoutManager.findFirstVisibleItemPosition()
                    currentPath?.apply {
                        saveLineForFile(this, line)
                    }
                }
            })
        }
    }

    fun initContents() {
        contentsAdapter = ContentsAdapter()
        contentsAdapter.onChapterClickListener = object : ContentsAdapter.OnChapterClickListener {
            override fun onChapterClick(chapter: Chapter) {
                rvLayoutManager.scrollToPositionWithOffset(chapter.line, 0)
                drawer_layout.closeDrawer(Gravity.START)
            }
        }
        rv_contents.apply {
            this.layoutManager = contentsLayoutManager
            this.adapter = contentsAdapter
        }
    }

    fun readFile(path: String) {
        currentPath = path
        saveCurrentPath()
        if (path.endsWith(".txt")) {
            txtList.clear()
            txtList.addAll(readTxtFile(path))
            contentsAdapter.setChapterList(null)
        } else if (path.endsWith(".fb2")) {
            txtList.clear()
            chapterList.clear()
            val result = readFb2File(path)
            txtList.addAll(result.first)
            chapterList.addAll(result.second)
            contentsAdapter.setChapterList(chapterList)
        }
        rvAdapter.setTxtList(txtList)
        rvLayoutManager.scrollToPositionWithOffset(getLineForFile(path), 0)
    }

    fun getLineForFile(path: String): Int {
        //Log.e("getLineForFile", path)
        val sp = getSharedPreferences("prefs", 0)
        return sp.getInt("line_$path", 0)
    }

    fun saveLineForFile(path: String, line: Int) {
        //Log.e("saveLineForFile", "$path: $line")
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putInt("line_$path", line)
        editor.commit()
    }

    fun loadCurrentPath() {
        val sp = getSharedPreferences("prefs", 0)
        currentPath = sp.getString("currentPath", null)
    }

    fun saveCurrentPath() {
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putString("currentPath", currentPath)
        editor.commit()
    }

    fun saveLanguage() {
        val currentLang = spinner_language.selectedItemPosition
        val sp = getSharedPreferences("prefs", 0)
        val editor = sp.edit()
        editor.putInt("currentLang", currentLang)
        editor.commit()
    }

    fun loadLanguage() {
        val sp = getSharedPreferences("prefs", 0)
        val currentLang = sp.getInt("currentLang", 0)
        spinner_language.setSelection(currentLang)
        setLanguage(currentLang)
    }

    fun setLanguage(position: Int) {
        when (position) {
            english -> RVAdapter.DIRECTION = "en-ru"
            deutsch -> RVAdapter.DIRECTION = "de-ru"
        }
    }
}
