package jatx.yandexdictionaryclient

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException

class YandexDictionaryClient private constructor() {
    companion object {
        private var INSTANCE: YandexDictionaryClient? = null

        fun getInstance(): YandexDictionaryClient {
            if (INSTANCE==null) {
                INSTANCE = YandexDictionaryClient()
            }
            return INSTANCE!!
        }
    }

    private val apiKey = "dict.1.1.20190705T225237Z.93435935d40a4eaf.ef0ea911b950560b87dfb6f6a1fe884aa715ebea"

    fun lookup(text: String, direction: String = "en-ru"): Pair<String, List<String>> {
        val resultList = arrayListOf<String>()
        val urlBuilder = HttpUrl.parse("https://dictionary.yandex.net/api/v1/dicservice.json/lookup")?.newBuilder()
        urlBuilder?.addQueryParameter("key", apiKey)
        urlBuilder?.addQueryParameter("lang", direction)
        urlBuilder?.addQueryParameter("text", text)
        urlBuilder?.addQueryParameter("flags", "4")
        val url = urlBuilder?.build().toString()
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient.Builder().build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw IOException("Unexpected code: $response")
        } else {
            response.body()?.string()?.apply {
                val jsonResult = JSONObject(this)
                val defJsonArray = jsonResult.getJSONArray("def")
                for (i in 0 until defJsonArray.length() - 1) {
                    val defJsonObject = defJsonArray.getJSONObject(i)
                    val trJsonArray = defJsonObject.getJSONArray("tr")
                    for (j in 0 until trJsonArray.length() - 1) {
                        val trJsonObject = trJsonArray.getJSONObject(j)
                        val trText = trJsonObject.getString("text")
                        resultList.add(trText)
                    }
                }
            }
            return text to resultList
        }
    }
}