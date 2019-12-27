package jatx.foreignreader.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0016R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006%"}, d2 = {"Ljatx/foreignreader/adapters/ContentsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljatx/foreignreader/adapters/ContentsAdapter$VH;", "()V", "value", "", "activeChapterPosition", "getActiveChapterPosition", "()I", "setActiveChapterPosition", "(I)V", "activeParagraphPosition", "getActiveParagraphPosition", "setActiveParagraphPosition", "", "Ljatx/filereader/Chapter;", "chapters", "getChapters", "()Ljava/util/List;", "setChapters", "(Ljava/util/List;)V", "onChapterClickListener", "Ljatx/foreignreader/adapters/OnChapterClickListener;", "getOnChapterClickListener", "()Ljatx/foreignreader/adapters/OnChapterClickListener;", "setOnChapterClickListener", "(Ljatx/foreignreader/adapters/OnChapterClickListener;)V", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
public final class ContentsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<jatx.foreignreader.adapters.ContentsAdapter.VH> {
    @org.jetbrains.annotations.Nullable()
    private jatx.foreignreader.adapters.OnChapterClickListener onChapterClickListener;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<jatx.filereader.Chapter> chapters;
    private int activeChapterPosition;
    private int activeParagraphPosition;
    
    @org.jetbrains.annotations.Nullable()
    public final jatx.foreignreader.adapters.OnChapterClickListener getOnChapterClickListener() {
        return null;
    }
    
    public final void setOnChapterClickListener(@org.jetbrains.annotations.Nullable()
    jatx.foreignreader.adapters.OnChapterClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<jatx.filereader.Chapter> getChapters() {
        return null;
    }
    
    public final void setChapters(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Chapter> value) {
    }
    
    public final int getActiveChapterPosition() {
        return 0;
    }
    
    public final void setActiveChapterPosition(int value) {
    }
    
    public final int getActiveParagraphPosition() {
        return 0;
    }
    
    public final void setActiveParagraphPosition(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public jatx.foreignreader.adapters.ContentsAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    jatx.foreignreader.adapters.ContentsAdapter.VH holder, int position) {
    }
    
    @javax.inject.Inject()
    public ContentsAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Ljatx/foreignreader/adapters/ContentsAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "tvChapter", "Landroid/widget/TextView;", "getTvChapter", "()Landroid/widget/TextView;", "app_debug"})
    public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView tvChapter = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTvChapter() {
            return null;
        }
        
        public VH(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
    }
}