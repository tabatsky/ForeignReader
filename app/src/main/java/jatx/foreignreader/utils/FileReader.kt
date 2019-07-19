package jatx.foreignreader.utils

import android.util.Log
import com.kursx.parser.fb2.FictionBook
import com.kursx.parser.fb2.Section
import jatx.foreignreader.models.Chapter
import jatx.foreignreader.models.Paragraph
import jatx.foreignreader.models.ParagraphType
import java.io.File
import java.io.FileInputStream
import java.util.*

fun readTxtFile(path: String): List<Paragraph> {
    val txtList = arrayListOf<Paragraph>()
    val fileInputStream = FileInputStream(path)
    val sc = Scanner(fileInputStream)
    while (sc.hasNextLine()) {
        val line = Paragraph(sc.nextLine(), ParagraphType.TEXT)
        txtList.add(line)
    }
    sc.close()
    return txtList
}

fun readFb2File(path: String): Pair<List<Paragraph>, List<Chapter>> {
    val lastLine = arrayOf(0)
    val txtList = arrayListOf<Paragraph>()
    val chapterList = arrayListOf<Chapter>()
    val fb2 = FictionBook(File(path))
    fb2.body.sections.forEach { section ->
        val result = readSection(section, lastLine)
        txtList.addAll(result.first)
        chapterList.addAll(result.second)
    }
    return txtList to chapterList
}

private fun readSection(section: Section, lastLine: Array<Int>): Pair<List<Paragraph>, List<Chapter>> {
    val txtList = arrayListOf<Paragraph>()
    val chapterList = arrayListOf<Chapter>()
    val title = section.getTitleString(": ", ".")
    if (title.trim().isNotEmpty()) {
        txtList.add(Paragraph(title, ParagraphType.TITLE))
        Log.e("position ${lastLine[0]}", title)
        chapterList.add(Chapter(lastLine[0], title))
        lastLine[0]++
    }
    section.elements.forEach { elem ->
        val line = Paragraph(elem.text, ParagraphType.TEXT)
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