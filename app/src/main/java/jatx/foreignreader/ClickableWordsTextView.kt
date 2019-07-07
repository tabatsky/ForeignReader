package jatx.foreignreader

import android.content.Context
import android.graphics.Color
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import android.widget.Toast

class ClickableWordsTextView(context: Context, attrs: AttributeSet?, defStyleAttr: Int):
    TextView(context, attrs, defStyleAttr) {
    private var txt: CharSequence? = null
    var onWordClickListener: OnWordClickListener? = null

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    override fun setText(text: CharSequence, type: BufferType) {
        txt = text
        movementMethod = LinkMovementMethod.getInstance()
        highlightColor = Color.TRANSPARENT
        val spannableString = SpannableString(text)
        val wordList = WordScanner(txt.toString()).getWordList()
        wordList.forEach { word: Word ->
            val clickableSpan = object : ClickableSpan() {
                override fun onClick(widget: View) {
                    //Toast.makeText(widget.context, word.toString(), Toast.LENGTH_LONG).show()
                    onWordClickListener?.onWordClick(word)
                }

                override fun updateDrawState(ds: TextPaint) {
                    super.updateDrawState(ds)
                    ds.isUnderlineText = false
                    ds.color = context.resources.getColor(android.R.color.black)
                }
            }
            spannableString.setSpan(clickableSpan, word.startIndex, word.endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        super.setText(spannableString, type)
    }

    interface OnWordClickListener {
        fun onWordClick(word: Word)
    }
}