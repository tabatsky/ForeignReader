package jatx.foreignreader.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jatx.clickablewordstextview.OnWordClickListener
import jatx.foreignreader.R
import jatx.filereader.Paragraph
import jatx.filereader.ParagraphType
import javax.inject.Inject

class ParagraphsAdapter @Inject constructor(): RecyclerView.Adapter<ParagraphsAdapter.VH>() {
    var paragraphs = listOf<Paragraph>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onWordClickListener: OnWordClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent,false)
        return VH(view)
    }

    override fun getItemCount() = paragraphs.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.cwtvForeign.text = paragraphs[position].text
        holder.cwtvForeign.onWordClickListener = onWordClickListener
        when (paragraphs[position].type) {
            ParagraphType.TITLE -> holder.cwtvForeign.typeface = Typeface.DEFAULT_BOLD
            ParagraphType.TEXT -> holder.cwtvForeign.typeface = Typeface.DEFAULT
        }
    }

    class VH(v: View): RecyclerView.ViewHolder(v) {
        val cwtvForeign: jatx.clickablewordstextview.ClickableWordsTextView = v.findViewById(R.id.cwtvForeign)
    }
}
