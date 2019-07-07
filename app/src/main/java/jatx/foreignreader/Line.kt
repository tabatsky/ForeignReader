package jatx.foreignreader

data class Line (
    val text: String,
    val type: LineType
)

enum class LineType {
    TITLE, PARAGRAPH
}