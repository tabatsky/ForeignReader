package jatx.foreignreader

class Word(text: String, startIndex: Int, endIndex: Int) {
    val text: String
    val startIndex: Int
    val endIndex: Int

    init {
        this.text = text
        this.startIndex = startIndex
        this.endIndex = endIndex
    }

    override fun toString(): String {
        return "$text | $startIndex | $endIndex"
    }
}