package jatx.clickablewordstextview

import java.lang.StringBuilder

class WordScanner(private val text: String) {
    private var currentIndex: Int = 0

    private val extraSymbols = listOf('Ä', 'ä', 'Ö', 'ö', 'ẞ', 'ß', 'Ü', 'ü', '\'')

    private fun isLetter(ch: Char): Boolean {
        return (ch in 'A'..'Z') || (ch in 'a'..'z') || (ch in extraSymbols)
    }

    private fun scanNextWord(): Word? {
        if (!isLetter(text[currentIndex])) {
            currentIndex++
            return null
        } else {
            val sb = StringBuilder()
            val start = currentIndex
            while (currentIndex < text.length && isLetter(text[currentIndex])) {
                sb.append(text[currentIndex])
                currentIndex++
            }
            val end = currentIndex
            return Word(sb.toString(), start, end)
        }
    }

    fun getWordList(): List<Word> {
        val list = ArrayList<Word>()

        while (currentIndex < text.length) {
            val word = scanNextWord()
            if (word != null) {
                list.add(word)
            }
        }

        return list
    }
}