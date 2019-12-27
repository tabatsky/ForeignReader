package jatx.foreignreader.prefs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Ljatx/foreignreader/prefs/Prefs;", "", "currentPath", "", "getCurrentPath", "()Ljava/lang/String;", "setCurrentPath", "(Ljava/lang/String;)V", "language", "", "getLanguage", "()I", "setLanguage", "(I)V", "getPositionForFile", "path", "savePositionForFile", "", "line", "app_debug"})
public abstract interface Prefs {
    
    public abstract int getLanguage();
    
    public abstract void setLanguage(int p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getCurrentPath();
    
    public abstract void setCurrentPath(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    public abstract void savePositionForFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path, int line);
    
    public abstract int getPositionForFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path);
}