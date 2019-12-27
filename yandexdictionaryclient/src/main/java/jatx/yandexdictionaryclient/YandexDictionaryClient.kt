package jatx.yandexdictionaryclient

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

interface YandexDictionaryClient {
    fun lookup(text: String, direction: TranslateDirection): Pair<String, List<String>>
}