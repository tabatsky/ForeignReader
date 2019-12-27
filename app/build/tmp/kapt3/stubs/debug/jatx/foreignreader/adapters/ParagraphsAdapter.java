package jatx.foreignreader.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0013H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Ljatx/foreignreader/adapters/ParagraphsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ljatx/foreignreader/adapters/ParagraphsAdapter$VH;", "()V", "onWordClickListener", "Ljatx/clickablewordstextview/OnWordClickListener;", "getOnWordClickListener", "()Ljatx/clickablewordstextview/OnWordClickListener;", "setOnWordClickListener", "(Ljatx/clickablewordstextview/OnWordClickListener;)V", "value", "", "Ljatx/filereader/Paragraph;", "paragraphs", "getParagraphs", "()Ljava/util/List;", "setParagraphs", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "VH", "app_debug"})
public final class ParagraphsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<jatx.foreignreader.adapters.ParagraphsAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<jatx.filereader.Paragraph> paragraphs;
    @org.jetbrains.annotations.Nullable()
    private jatx.clickablewordstextview.OnWordClickListener onWordClickListener;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<jatx.filereader.Paragraph> getParagraphs() {
        return null;
    }
    
    public final void setParagraphs(@org.jetbrains.annotations.NotNull()
    java.util.List<jatx.filereader.Paragraph> value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final jatx.clickablewordstextview.OnWordClickListener getOnWordClickListener() {
        return null;
    }
    
    public final void setOnWordClickListener(@org.jetbrains.annotations.Nullable()
    jatx.clickablewordstextview.OnWordClickListener p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public jatx.foreignreader.adapters.ParagraphsAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    jatx.foreignreader.adapters.ParagraphsAdapter.VH holder, int position) {
    }
    
    @javax.inject.Inject()
    public ParagraphsAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Ljatx/foreignreader/adapters/ParagraphsAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "v", "Landroid/view/View;", "(Landroid/view/View;)V", "cwtvForeign", "Ljatx/clickablewordstextview/ClickableWordsTextView;", "getCwtvForeign", "()Ljatx/clickablewordstextview/ClickableWordsTextView;", "app_debug"})
    public static final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final jatx.clickablewordstextview.ClickableWordsTextView cwtvForeign = null;
        
        @org.jetbrains.annotations.NotNull()
        public final jatx.clickablewordstextview.ClickableWordsTextView getCwtvForeign() {
            return null;
        }
        
        public VH(@org.jetbrains.annotations.NotNull()
        android.view.View v) {
            super(null);
        }
    }
}