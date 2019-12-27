package jatx.foreignreader.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020#H\u0002J\b\u0010%\u001a\u00020#H\u0002J\u0012\u0010&\u001a\u00020#2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0014J\u0010\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0016J\u0016\u0010,\u001a\u00020#2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016J\u0016\u00100\u001a\u00020#2\f\u00101\u001a\b\u0012\u0004\u0012\u0002020.H\u0016J\b\u00103\u001a\u00020#H\u0016J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020+H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u00107\u001a\u000208H\u0016J\u0018\u00109\u001a\u00020#2\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u000208H\u0016J\u0010\u0010<\u001a\u00020#2\u0006\u0010*\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006="}, d2 = {"Ljatx/foreignreader/ui/MainActivity;", "Lmoxy/MvpAppCompatActivity;", "Ljatx/foreignreader/presentation/MainView;", "()V", "drawerToggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "presenter", "Ljatx/foreignreader/presentation/MainPresenter;", "kotlin.jvm.PlatformType", "getPresenter", "()Ljatx/foreignreader/presentation/MainPresenter;", "presenter$delegate", "Lmoxy/ktx/MoxyKtxDelegate;", "presenterProvider", "Ldagger/Lazy;", "getPresenterProvider", "()Ldagger/Lazy;", "setPresenterProvider", "(Ldagger/Lazy;)V", "rvContentsAdapter", "Ljatx/foreignreader/adapters/ContentsAdapter;", "getRvContentsAdapter", "()Ljatx/foreignreader/adapters/ContentsAdapter;", "setRvContentsAdapter", "(Ljatx/foreignreader/adapters/ContentsAdapter;)V", "rvContentsLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "rvParagraphsAdapter", "Ljatx/foreignreader/adapters/ParagraphsAdapter;", "getRvParagraphsAdapter", "()Ljatx/foreignreader/adapters/ParagraphsAdapter;", "setRvParagraphsAdapter", "(Ljatx/foreignreader/adapters/ParagraphsAdapter;)V", "rvParagraphsLayoutManager", "initDrawer", "", "initRVContents", "initRVParagraphs", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "scrollToActualPosition", "paragraphPosition", "", "setChapters", "chapters", "", "Ljatx/filereader/Chapter;", "setParagraphs", "paragraphs", "Ljatx/filereader/Paragraph;", "showFileSelectDialog", "showSpinnerLanguageActualState", "position", "showToast", "text", "", "showTranslation", "word", "translation", "updateActiveChapter", "app_debug"})
public final class MainActivity extends moxy.MvpAppCompatActivity implements jatx.foreignreader.presentation.MainView {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public jatx.foreignreader.adapters.ParagraphsAdapter rvParagraphsAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public jatx.foreignreader.adapters.ContentsAdapter rvContentsAdapter;
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public dagger.Lazy<jatx.foreignreader.presentation.MainPresenter> presenterProvider;
    private final moxy.ktx.MoxyKtxDelegate presenter$delegate = null;
    private androidx.appcompat.app.ActionBarDrawerToggle drawerToggle;
    private final androidx.recyclerview.widget.LinearLayoutManager rvParagraphsLayoutManager = null;
    private final androidx.recyclerview.widget.LinearLayoutManager rvContentsLayoutManager = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final jatx.foreignreader.adapters.ParagraphsAdapter getRvParagraphsAdapter() {
        return null;
    }
    
    public final void setRvParagraphsAdapter(@org.jetbrains.annotations.NotNull()
    jatx.foreignreader.adapters.ParagraphsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final jatx.foreignreader.adapters.ContentsAdapter getRvContentsAdapter() {
        return null;
    }
    
    public final void setRvContentsAdapter(@org.jetbrains.annotations.NotNull()
    jatx.foreignreader.adapters.ContentsAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final dagger.Lazy<jatx.foreignreader.presentation.MainPresenter> getPresenterProvider() {
        return null;
    }
    
    public final void setPresenterProvider(@org.jetbrains.annotations.NotNull()
    dagger.Lazy<jatx.foreignreader.presentation.MainPresenter> p0) {
    }
    
    private final jatx.foreignreader.presentation.MainPresenter getPresenter() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void showTranslation(@org.jetbrains.annotations.NotNull()
    java.lang.String word, @org.jetbrains.annotations.NotNull()
    java.lang.String translation) {
    }
    
    @java.lang.Override()
    public void showToast(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    @java.lang.Override()
    public void setParagraphs(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Paragraph> paragraphs) {
    }
    
    @java.lang.Override()
    public void setChapters(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Chapter> chapters) {
    }
    
    @java.lang.Override()
    public void scrollToActualPosition(int paragraphPosition) {
    }
    
    @java.lang.Override()
    public void showSpinnerLanguageActualState(int position) {
    }
    
    @java.lang.Override()
    public void showFileSelectDialog() {
    }
    
    @java.lang.Override()
    public void updateActiveChapter(int paragraphPosition) {
    }
    
    private final void initDrawer() {
    }
    
    private final void initRVParagraphs() {
    }
    
    private final void initRVContents() {
    }
    
    public MainActivity() {
        super();
    }
}