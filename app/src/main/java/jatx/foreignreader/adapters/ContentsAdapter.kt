package jatx.foreignreader.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import jatx.foreignreader.R
import jatx.foreignreader.models.Chapter

class ContentsAdapter: RecyclerView.Adapter<ContentsAdapter.VH>() {
    interface OnChapterClickListener {
        fun onChapterClick(chapter: Chapter)
    }

    var onChapterClickListener: OnChapterClickListener? = null

    private val chapterList = arrayListOf<Chapter>()

    fun setChapterList(chList: List<Chapter>?) {
        this.chapterList.clear()
        chList?.apply {
            chapterList.addAll(this)
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.contents_item, parent,false)
        return VH(view)
    }

    override fun getItemCount() = chapterList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvChapter.text = chapterList[position].title
        holder.itemView.setOnClickListener {
            onChapterClickListener?.onChapterClick(chapterList[position])
        }
    }

    class VH(v: View): RecyclerView.ViewHolder(v) {
        val tvChapter: TextView

        init {
            tvChapter = v as TextView
        }
    }
}