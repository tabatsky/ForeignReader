package jatx.yandexdictionaryclient;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Ljatx/yandexdictionaryclient/YandexDictionaryClient;", "", "lookup", "Lkotlin/Pair;", "", "", "text", "direction", "Ljatx/yandexdictionaryclient/TranslateDirection;", "yandexdictionaryclient_debug"})
public abstract interface YandexDictionaryClient {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.Pair<java.lang.String, java.util.List<java.lang.String>> lookup(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    jatx.yandexdictionaryclient.TranslateDirection direction);
}