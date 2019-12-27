package jatx.bookreader

import android.content.Context
import android.util.Log
import com.kursx.parser.fb2.FictionBook
import com.kursx.parser.fb2.Section
import java.io.BufferedInputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*
import java.util.zip.ZipInputStream
import javax.inject.Inject

class BookReaderImpl @Inject constructor(
    private val context: Context
): BookReader {
    override fun readTxtFile(path: String): Book {
        val paragraphs = arrayListOf<Paragraph>()
        val fileInputStream = FileInputStream(path)
        val sc = Scanner(fileInputStream)
        while (sc.hasNextLine()) {
            val line = Paragraph(
                sc.nextLine(),
                ParagraphType.TEXT
            )
            paragraphs.add(line)
        }
        sc.close()
        return Book(paragraphs, listOf())
    }

    override fun readFb2File(path: String): Book {
        val lastLine = arrayOf(0)
        val paragraphs = arrayListOf<Paragraph>()
        val chapters = arrayListOf<Chapter>()
        val fb2 = FictionBook(File(path))
        fb2.body.sections.forEach { section ->
            val result = readSection(section, lastLine)
            paragraphs.addAll(result.paragraphs)
            chapters.addAll(result.chapters)
        }
        for (i in 0 until  chapters.size) {
            chapters[i].number = i
        }
        return Book(paragraphs, chapters)
    }

    override fun readFb2ZipFile(path: String): Book {
        val zis = ZipInputStream(BufferedInputStream(FileInputStream(path)))
        val entry = zis.nextEntry
        Log.e("zip entry", entry.name)

        val tmpFile = File.createTempFile("book", ".fb2")
        val fout = FileOutputStream(tmpFile)

        val buffer = ByteArray(1024)
        var count = 0

        while (true) {
            count = zis.read(buffer)
            if (count == -1) break
            fout.write(buffer, 0, count)
        }

        fout.flush()
        fout.close()
        zis.closeEntry()
        zis.close()

        return readFb2File(tmpFile.absolutePath)
    }

    private fun readSection(section: Section, lastLine: Array<Int>): Book {
        val paragraphs = arrayListOf<Paragraph>()
        val chapters = arrayListOf<Chapter>()
        val title = section.getTitleString(": ", ".")
        if (title.trim().isNotEmpty()) {
            paragraphs.add(Paragraph(title, ParagraphType.TITLE))
            chapters.add(Chapter(position = lastLine[0], title = title))
            lastLine[0]++
        }
        section.elements.forEach {
            val line = Paragraph(
                it.text,
                ParagraphType.TEXT
            )
            paragraphs.add(line)
            lastLine[0]++
        }
        section.sections.forEach {
            val result = readSection(it, lastLine)
            paragraphs.addAll(result.paragraphs)
            chapters.addAll(result.chapters)
        }
        return Book(paragraphs, chapters)
    }
}