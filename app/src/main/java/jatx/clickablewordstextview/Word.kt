package jatx.clickablewordstextview

data class Word(
    val text: String,
    val startIndex: Int,
    val endIndex: Int) {

    override fun toString(): String {
        return "$text | $startIndex | $endIndex"
    }
}