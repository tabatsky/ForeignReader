package jatx.foreignreader

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jatx.yandexdictionaryclient.YandexDictionaryClient

class RVAdapter: RecyclerView.Adapter<RVAdapter.VH>() {
    companion object {
        var DIRECTION = "en-ru"
    }

    private val txtList = arrayListOf<Line>()

    fun setTxtList(txtList: List<Line>) {
        this.txtList.clear()
        this.txtList.addAll(txtList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent,false)
        return VH(view)
    }

    override fun getItemCount() = txtList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvForeign.text = txtList[position].text
        when (txtList[position].type) {
            LineType.TITLE -> holder.tvForeign.setTypeface(Typeface.DEFAULT_BOLD)
            LineType.PARAGRAPH -> holder.tvForeign.setTypeface(Typeface.DEFAULT)
        }
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        if (!(holder.clickEventDisposable?.isDisposed ?: true)) holder.clickEventDisposable?.dispose()
        //Log.e("detached", holder.layoutPosition.toString())
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.attach()
        //Log.e("attached", holder.layoutPosition.toString())
    }

    class VH(v: View): RecyclerView.ViewHolder(v) {
        val tvForeign: ClickableWordsTextView
        val context: Context
        var clickEventDisposable: Disposable? = null

        init {
            tvForeign = v.findViewById(R.id.tv_foreign)
            context = v.context
        }

        fun attach() {
            val clickEventObservable = Observable.create(object : ObservableOnSubscribe<Word> {
                override fun subscribe(e: ObservableEmitter<Word>) {
                    tvForeign.onWordClickListener = object : ClickableWordsTextView.OnWordClickListener {
                        override fun onWordClick(word: Word) {
                            if (e.isDisposed) return
                            e.onNext(word)
                        }
                    }
                }
            })

            clickEventDisposable = clickEventObservable
                .subscribeOn(Schedulers.io())
                .flatMap { word -> Observable
                    .fromCallable{YandexDictionaryClient.getInstance().lookup(word.text, RVAdapter.DIRECTION)}
                    .subscribeOn(Schedulers.io())}
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    println(result.second)
                    showWordDialog(context, result.first, "${result.second}")
                }, { error ->
                    error.printStackTrace()
                })
        }
    }
}

