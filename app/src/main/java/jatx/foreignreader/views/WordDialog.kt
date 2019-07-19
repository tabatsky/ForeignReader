package jatx.foreignreader.views

import android.content.Context
import android.support.v7.app.AlertDialog

fun showWordDialog(context: Context, text: String, translation: String) {
    val builder = AlertDialog.Builder(context)
    builder.setPositiveButton("Ok") {dialog, which ->
        dialog.dismiss()
    }
    builder.setTitle(text)
    builder.setMessage(translation)
    val dialog = builder.create()
    dialog.show()
}