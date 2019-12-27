package jatx.filereader

interface FileReader {
    fun readTxtFile(path: String): List<Paragraph>
    fun readFb2File(path: String): Pair<List<Paragraph>, List<Chapter>>
}