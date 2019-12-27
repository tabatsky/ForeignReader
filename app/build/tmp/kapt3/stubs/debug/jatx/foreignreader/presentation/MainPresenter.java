package jatx.foreignreader.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0013J\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0019J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000eJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Ljatx/foreignreader/presentation/MainPresenter;", "Lmoxy/MvpPresenter;", "Ljatx/foreignreader/presentation/MainView;", "context", "Landroid/content/Context;", "yandexDictionaryClient", "Ljatx/yandexdictionaryclient/YandexDictionaryClient;", "fileReader", "Ljatx/filereader/FileReader;", "prefs", "Ljatx/foreignreader/prefs/Prefs;", "(Landroid/content/Context;Ljatx/yandexdictionaryclient/YandexDictionaryClient;Ljatx/filereader/FileReader;Ljatx/foreignreader/prefs/Prefs;)V", "publishSubject", "Lio/reactivex/subjects/PublishSubject;", "Ljatx/clickablewordstextview/Word;", "kotlin.jvm.PlatformType", "translateDirection", "Ljatx/yandexdictionaryclient/TranslateDirection;", "loadFile", "", "path", "", "loadFileOrDefaultText", "onActiveParagraphChanged", "paragraphPosition", "", "onBtnOpenFileClick", "onChangeLanguage", "position", "onFirstViewAttach", "onWordClick", "word", "savePositionForFile", "subscribeToPublishSubject", "app_debug"})
@moxy.InjectViewState()
public final class MainPresenter extends moxy.MvpPresenter<jatx.foreignreader.presentation.MainView> {
    private io.reactivex.subjects.PublishSubject<jatx.clickablewordstextview.Word> publishSubject;
    private jatx.yandexdictionaryclient.TranslateDirection translateDirection;
    private final android.content.Context context = null;
    private final jatx.yandexdictionaryclient.YandexDictionaryClient yandexDictionaryClient = null;
    private final jatx.filereader.FileReader fileReader = null;
    private final jatx.foreignreader.prefs.Prefs prefs = null;
    
    @java.lang.Override()
    protected void onFirstViewAttach() {
    }
    
    public final void onWordClick(@org.jetbrains.annotations.NotNull()
    jatx.clickablewordstextview.Word word) {
    }
    
    public final void onChangeLanguage(int position) {
    }
    
    public final void onBtnOpenFileClick() {
    }
    
    public final void loadFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
    }
    
    public final void onActiveParagraphChanged(int paragraphPosition) {
    }
    
    private final void loadFileOrDefaultText() {
    }
    
    private final void subscribeToPublishSubject() {
    }
    
    private final void savePositionForFile(int paragraphPosition) {
    }
    
    @javax.inject.Inject()
    public MainPresenter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    jatx.yandexdictionaryclient.YandexDictionaryClient yandexDictionaryClient, @org.jetbrains.annotations.NotNull()
    jatx.filereader.FileReader fileReader, @org.jetbrains.annotations.NotNull()
    jatx.foreignreader.prefs.Prefs prefs) {
        super();
    }
}