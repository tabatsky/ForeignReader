package jatx.foreignreader

import android.util.Log
import com.kursx.parser.fb2.Element
import com.kursx.parser.fb2.FictionBook
import com.kursx.parser.fb2.Section
import java.io.File
import java.io.FileInputStream
import java.util.*

fun readTxtFile(path: String): List<Line> {
    val txtList = arrayListOf<Line>()
    val fileInputStream = FileInputStream(path)
    val sc = Scanner(fileInputStream)
    while (sc.hasNextLine()) {
        val line = Line(sc.nextLine(), LineType.PARAGRAPH)
        txtList.add(line)
    }
    sc.close()
    return txtList
}

fun readFb2File(path: String): Pair<List<Line>, List<Chapter>> {
    var lastLine = arrayOf(0)
    val txtList = arrayListOf<Line>()
    val chapterList = arrayListOf<Chapter>()
    val fb2 = FictionBook(File(path))
    fb2.body.sections.forEach { section ->
        val result = readSection(section, lastLine)
        txtList.addAll(result.first)
        chapterList.addAll(result.second)
    }
    return txtList to chapterList
}

private fun readSection(section: Section, lastLine: Array<Int>): Pair<List<Line>, List<Chapter>> {
    val txtList = arrayListOf<Line>()
    val chapterList = arrayListOf<Chapter>()
    val title = section.getTitleString(": ", ".")
    if (!title.trim().isEmpty()) {
        txtList.add(Line(title, LineType.TITLE))
        Log.e("line ${lastLine[0]}", title)
        chapterList.add(Chapter(lastLine[0], title))
        lastLine[0]++
    }
    section.elements.forEach { elem ->
        val line = Line(elem.text, LineType.PARAGRAPH)
        txtList.add(line)
        lastLine[0]++
    }
    section.sections.forEach { section ->
        val result = readSection(section, lastLine)
        txtList.addAll(result.first)
        chapterList.addAll(result.second)
    }
    return txtList to chapterList
}