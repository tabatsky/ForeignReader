package jatx.foreignreader.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Ljatx/foreignreader/di/PresenterModule;", "", "()V", "provideMainPresenter", "Ljatx/foreignreader/presentation/MainPresenter;", "context", "Landroid/content/Context;", "yandexDictionaryClient", "Ljatx/yandexdictionaryclient/YandexDictionaryClient;", "fileReader", "Ljatx/filereader/FileReader;", "prefs", "Ljatx/foreignreader/prefs/Prefs;", "app_debug"})
@dagger.Module()
public final class PresenterModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final jatx.foreignreader.presentation.MainPresenter provideMainPresenter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    jatx.yandexdictionaryclient.YandexDictionaryClient yandexDictionaryClient, @org.jetbrains.annotations.NotNull()
    jatx.filereader.FileReader fileReader, @org.jetbrains.annotations.NotNull()
    jatx.foreignreader.prefs.Prefs prefs) {
        return null;
    }
    
    public PresenterModule() {
        super();
    }
}