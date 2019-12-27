package jatx.foreignreader.prefs

import jatx.yandexdictionaryclient.TranslateDirection

interface Prefs {
    var language: Int
    var currentPath: String?
    val translateDirection: TranslateDirection
    fun savePositionForFile(path: String, line: Int)
    fun getPositionForFile(path: String): Int
}