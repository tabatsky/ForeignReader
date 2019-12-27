package jatx.foreignreader.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jatx.foreignreader.R
import jatx.filereader.Chapter
import javax.inject.Inject

class ContentsAdapter @Inject constructor(): RecyclerView.Adapter<ContentsAdapter.VH>() {
    var onChapterClickListener: OnChapterClickListener? = null

    var chapters = listOf<Chapter>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var activeChapterPosition: Int = 0
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var activeParagraphPosition: Int = 0
        set(value) {
            field = value
            chapters.firstOrNull { it.position - value >= 0 }?.apply {
                activeChapterPosition = if (value == this.position) {
                    this.number
                } else {
                    this.number - 1
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contents_item, parent,false)
        return VH(view)
    }

    override fun getItemCount() = chapters.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvChapter.text = chapters[position].title
        holder.tvChapter.setTypeface(
            null,
            if (position == activeChapterPosition) Typeface.BOLD else Typeface.NORMAL
        )
        holder.itemView.setOnClickListener {
            onChapterClickListener?.onChapterClick(chapters[position])
        }
    }

    class VH(v: View): RecyclerView.ViewHolder(v) {
        val tvChapter: TextView = v as TextView
    }
}

interface OnChapterClickListener {
    fun onChapterClick(chapter: Chapter)
}

fun onChapterClickListener(onChapterClickLambda: (Chapter) -> Unit) = object : OnChapterClickListener {
    override fun onChapterClick(chapter: Chapter) {
        onChapterClickLambda(chapter)
    }
}