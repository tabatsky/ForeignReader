package jatx.bookreader

data class Paragraph (
    val text: String,
    val type: ParagraphType
)

enum class ParagraphType {
    TITLE, TEXT
}