package jatx.foreignreader.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Ljatx/foreignreader/di/AppModule;", "", "provideFileReader", "Ljatx/filereader/FileReader;", "fileReaderImpl", "Ljatx/filereader/FileReaderImpl;", "providePrefs", "Ljatx/foreignreader/prefs/Prefs;", "prefsImpl", "Ljatx/foreignreader/prefs/PrefsImpl;", "provideYandexDictionaryClient", "Ljatx/yandexdictionaryclient/YandexDictionaryClient;", "yandexDictionaryClientImpl", "Ljatx/yandexdictionaryclient/YandexDictionaryClientImpl;", "app_debug"})
@dagger.Module()
public abstract interface AppModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract jatx.foreignreader.prefs.Prefs providePrefs(@org.jetbrains.annotations.NotNull()
    jatx.foreignreader.prefs.PrefsImpl prefsImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract jatx.filereader.FileReader provideFileReader(@org.jetbrains.annotations.NotNull()
    jatx.filereader.FileReaderImpl fileReaderImpl);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract jatx.yandexdictionaryclient.YandexDictionaryClient provideYandexDictionaryClient(@org.jetbrains.annotations.NotNull()
    jatx.yandexdictionaryclient.YandexDictionaryClientImpl yandexDictionaryClientImpl);
}