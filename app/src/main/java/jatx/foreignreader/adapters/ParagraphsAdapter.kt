package jatx.foreignreader.adapters

import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
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
import jatx.foreignreader.R
import jatx.foreignreader.models.Paragraph
import jatx.foreignreader.models.ParagraphType
import jatx.foreignreader.views.showWordDialog
import jatx.clickablewordstextview.ClickableWordsTextView
import jatx.clickablewordstextview.Word
import jatx.yandexdictionaryclient.YandexDictionaryClient

class ParagraphsAdapter: RecyclerView.Adapter<ParagraphsAdapter.VH>() {
    companion object {
        val DIRECTION_EN_RU = "en-ru"
        val DIRECTION_DE_RU = "de-ru"
        var DIRECTION = DIRECTION_EN_RU
    }

    private val paragraphList = arrayListOf<Paragraph>()

    fun setParagraphList(txtList: List<Paragraph>) {
        this.paragraphList.clear()
        this.paragraphList.addAll(txtList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent,false)
        return VH(view)
    }

    override fun getItemCount() = paragraphList.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tvForeign.text = paragraphList[position].text
        when (paragraphList[position].type) {
            ParagraphType.TITLE -> holder.tvForeign.setTypeface(Typeface.DEFAULT_BOLD)
            ParagraphType.TEXT -> holder.tvForeign.setTypeface(Typeface.DEFAULT)
        }
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetach()
        //Log.e("detached", holder.layoutPosition.toString())
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.onAttach()
        //Log.e("attached", holder.layoutPosition.toString())
    }

    class VH(v: View): RecyclerView.ViewHolder(v) {
        val tvForeign: ClickableWordsTextView
        var clickEventDisposable: Disposable? = null

        init {
            tvForeign = v.findViewById(R.id.tv_foreign)
        }

        fun onAttach() {
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
                    .fromCallable{YandexDictionaryClient.getInstance().lookup(word.text,
                        DIRECTION
                    )}
                    .subscribeOn(Schedulers.io())}
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    println(result.second)
                    showWordDialog(tvForeign.context, result.first, "${result.second}")
                }, { error ->
                    error.printStackTrace()
                    Toast.makeText(tvForeign.context, "Error get translate from api", Toast.LENGTH_LONG).show()
                    onDetach()
                    onAttach()
                })
        }

        fun onDetach() {
            if (!(clickEventDisposable?.isDisposed ?: true)) clickEventDisposable?.dispose()
        }
    }
}

