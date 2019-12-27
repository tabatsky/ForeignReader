package jatx.yandexdictionaryclient

data class DictionaryItem(
    val original: String,
    val translations: List<String>
)