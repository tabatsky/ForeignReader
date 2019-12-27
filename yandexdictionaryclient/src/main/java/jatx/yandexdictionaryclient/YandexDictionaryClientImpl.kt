package jatx.yandexdictionaryclient

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject

const val API_KEY = "dict.1.1.20190705T225237Z.93435935d40a4eaf.ef0ea911b950560b87dfb6f6a1fe884aa715ebea"
const val API_URL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup"

class YandexDictionaryClientImpl @Inject constructor() : YandexDictionaryClient {
    override fun lookup(original: String, direction: TranslateDirection): DictionaryItem {
        val resultList = arrayListOf<String>()
        val urlBuilder = HttpUrl.parse(API_URL)?.newBuilder()
        urlBuilder?.addQueryParameter("key", API_KEY)
        urlBuilder?.addQueryParameter("lang", direction.direction)
        urlBuilder?.addQueryParameter("text", original)
        urlBuilder?.addQueryParameter("flags", "4")
        val url = urlBuilder?.build().toString()
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient.Builder().build()
        val response = client.newCall(request).execute()
        if (!response.isSuccessful) {
            throw IOException("Unexpected code: $response")
        } else {
            response.body()?.string()?.apply {
                println(this)
                val jsonResult = JSONObject(this)
                val defJsonArray = jsonResult.getJSONArray("def")
                for (i in 0 until defJsonArray.length()) {
                    val defJsonObject = defJsonArray.getJSONObject(i)
                    val trJsonArray = defJsonObject.getJSONArray("tr")
                    for (j in 0 until trJsonArray.length()) {
                        val trJsonObject = trJsonArray.getJSONObject(j)
                        val trText = trJsonObject.getString("text")
                        resultList.add(trText)
                    }
                }
            }
            return DictionaryItem(original, resultList)
        }
    }
}