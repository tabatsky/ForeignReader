package jatx.foreignreader.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0016\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bH\'J\b\u0010\r\u001a\u00020\u0003H\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H\'J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\'J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0017"}, d2 = {"Ljatx/foreignreader/presentation/MainView;", "Lmoxy/MvpView;", "scrollToActualPosition", "", "paragraphPosition", "", "setChapters", "chapters", "", "Ljatx/filereader/Chapter;", "setParagraphs", "paragraphs", "Ljatx/filereader/Paragraph;", "showFileSelectDialog", "showSpinnerLanguageActualState", "position", "showToast", "text", "", "showTranslation", "word", "translation", "updateActiveChapter", "app_debug"})
public abstract interface MainView extends moxy.MvpView {
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.SkipStrategy.class)
    public abstract void showTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    java.lang.String translation);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.SkipStrategy.class)
    public abstract void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String text);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.SkipStrategy.class)
    public abstract void showFileSelectDialog();
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.AddToEndSingleStrategy.class)
    public abstract void setParagraphs(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Paragraph> paragraphs);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.AddToEndSingleStrategy.class)
    public abstract void setChapters(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Chapter> chapters);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.AddToEndSingleStrategy.class)
    public abstract void scrollToActualPosition(int paragraphPosition);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.AddToEndSingleStrategy.class)
    public abstract void showSpinnerLanguageActualState(int position);
    
    @moxy.viewstate.strategy.StateStrategyType(value = moxy.viewstate.strategy.AddToEndSingleStrategy.class)
    public abstract void updateActiveChapter(int paragraphPosition);
}