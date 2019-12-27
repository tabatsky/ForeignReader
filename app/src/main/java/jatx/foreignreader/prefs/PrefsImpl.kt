package jatx.foreignreader.prefs

import android.content.Context
import javax.inject.Inject

const val PREFS_NAME = "foreign_reader_prefs"

const val KEY_LANGUAGE = "language"
const val KEY_CURRENT_PATH = "currentPath"

class PrefsImpl @Inject constructor(context: Context) : Prefs {
    val sp = context.getSharedPreferences(PREFS_NAME, 0)

    override var language: Int
        get() = sp.getInt(KEY_LANGUAGE, 0)
        set(value) {
            val editor = sp.edit()
            editor.putInt(KEY_LANGUAGE, value)
            editor.commit()
        }

    override var currentPath: String?
        get() = sp.getString(KEY_CURRENT_PATH, null)
        set(value) {
            val editor = sp.edit()
            editor.putString(KEY_CURRENT_PATH, value)
            editor.commit()
        }

    override fun savePositionForFile(path: String, line: Int) {
        val editor = sp.edit()
        editor.putInt("position_$path", line)
        editor.apply()
    }

    override fun getPositionForFile(path: String) = sp.getInt("position_$path", 0)
}