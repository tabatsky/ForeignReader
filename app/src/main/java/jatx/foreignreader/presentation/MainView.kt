package jatx.foreignreader.presentation

import jatx.bookreader.Chapter
import jatx.bookreader.Paragraph
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainView: MvpView {
    @StateStrategyType(SkipStrategy::class) fun showTranslation(word: String, translation: String)
    @StateStrategyType(SkipStrategy::class) fun showToast(text: String)
    @StateStrategyType(SkipStrategy::class) fun showFileSelectDialog()
    @StateStrategyType(AddToEndSingleStrategy::class) fun setParagraphs(paragraphs: List<Paragraph>)
    @StateStrategyType(AddToEndSingleStrategy::class) fun setChapters(chapters: List<Chapter>)
    @StateStrategyType(AddToEndSingleStrategy::class) fun scrollToActualPosition(paragraphPosition: Int)
    @StateStrategyType(AddToEndSingleStrategy::class) fun showSpinnerLanguageActualState(position: Int)
    @StateStrategyType(AddToEndSingleStrategy::class) fun updateActiveChapter(paragraphPosition: Int)
}