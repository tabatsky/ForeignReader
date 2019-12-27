package jatx.foreignreader.prefs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\fH\u0016R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Ljatx/foreignreader/prefs/PrefsImpl;", "Ljatx/foreignreader/prefs/Prefs;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "currentPath", "getCurrentPath", "()Ljava/lang/String;", "setCurrentPath", "(Ljava/lang/String;)V", "", "language", "getLanguage", "()I", "setLanguage", "(I)V", "sp", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getSp", "()Landroid/content/SharedPreferences;", "getPositionForFile", "path", "savePositionForFile", "", "line", "app_debug"})
public final class PrefsImpl implements jatx.foreignreader.prefs.Prefs {
    private final android.content.SharedPreferences sp = null;
    
    public final android.content.SharedPreferences getSp() {
        return null;
    }
    
    @java.lang.Override()
    public int getLanguage() {
        return 0;
    }
    
    @java.lang.Override()
    public void setLanguage(int value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getCurrentPath() {
        return null;
    }
    
    @java.lang.Override()
    public void setCurrentPath(@org.jetbrains.annotations.Nullable()
    java.lang.String value) {
    }
    
    @java.lang.Override()
    public void savePositionForFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path, int line) {
    }
    
    @java.lang.Override()
    public int getPositionForFile(@org.jetbrains.annotations.NotNull()
    java.lang.String path) {
        return 0;
    }
    
    @javax.inject.Inject()
    public PrefsImpl(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}