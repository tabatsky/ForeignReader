package jatx.foreignreader

import java.lang.StringBuilder

class WordScanner(text: String) {
    val text: String
    private var currentIndex: Int = 0

    val deutschLetters = listOf('Ä', 'ä', 'Ö', 'ö', 'ẞ', 'ß', 'Ü', 'ü')
    val englishSymbols = listOf('\'')

    init {
        this.text = text
    }

    fun isLetter(ch: Char): Boolean {
        return (ch in 'A'..'Z') || (ch in 'a'..'z') || (ch in deutschLetters) || (ch in englishSymbols)
    }

    fun scanNextWord(): Word? {
        if (!isLetter(text.get(currentIndex))) {
            currentIndex++
            return null
        } else {
            val sb = StringBuilder()
            val start = currentIndex
            while (currentIndex < text.length && isLetter(text.get(currentIndex))) {
                sb.append(text.get(currentIndex))
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