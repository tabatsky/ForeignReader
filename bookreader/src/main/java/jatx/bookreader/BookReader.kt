package jatx.bookreader

interface BookReader {
    fun readTxtFile(path: String): Book
    fun readFb2File(path: String): Book
    fun readFb2ZipFile(path: String): Book
}