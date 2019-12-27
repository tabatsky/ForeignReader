package jatx.foreignreader.prefs

interface Prefs {
    var language: Int
    var currentPath: String?
    fun savePositionForFile(path: String, line: Int)
    fun getPositionForFile(path: String): Int
}