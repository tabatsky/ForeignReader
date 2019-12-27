package jatx.foreignreader.ui

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun showTranslationDialog(context: Context, text: String, translation: String) {
    val builder = AlertDialog.Builder(context)
    builder.setPositiveButton("Ok") {dialog, _ ->
        dialog.dismiss()
    }
    builder.setTitle(text)
    builder.setMessage(translation)
    val dialog = builder.create()
    dialog.show()
}