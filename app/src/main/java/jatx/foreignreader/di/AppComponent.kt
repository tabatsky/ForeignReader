package jatx.foreignreader.di

import android.content.Context
import dagger.*
import jatx.bookreader.BookReader
import jatx.bookreader.BookReaderImpl
import jatx.foreignreader.adapters.ContentsAdapter
import jatx.foreignreader.adapters.ParagraphsAdapter
import jatx.foreignreader.prefs.Prefs
import jatx.foreignreader.prefs.PrefsImpl
import jatx.foreignreader.presentation.MainPresenter
import jatx.foreignreader.ui.MainActivity
import jatx.yandexdictionaryclient.YandexDictionaryClient
import jatx.yandexdictionaryclient.YandexDictionaryClientImpl

@Component(
    modules = [
        AppModule::class,
        AdaptersModule::class,
        PresenterModule::class
    ]
 )
interface AppComponent: Injector<MainActivity>, AppDeps {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}

@Module
interface AppModule {
    @Binds
    fun providePrefs(prefsImpl: PrefsImpl): Prefs

    @Binds
    fun provideFileReader(fileReaderImpl: BookReaderImpl): BookReader

    @Binds
    fun provideYandexDictionaryClient(yandexDictionaryClientImpl: YandexDictionaryClientImpl): YandexDictionaryClient
}

@Module
class AdaptersModule {
    @Provides
    fun provideContentsAdapter() = ContentsAdapter()

    @Provides
    fun provideParagraphsAdapter() = ParagraphsAdapter()
}

@Module
class PresenterModule {
    @Provides
    fun provideMainPresenter(
        context: Context,
        yandexDictionaryClient: YandexDictionaryClient,
        bookReader: BookReader,
        prefs: Prefs
    ) = MainPresenter(context, yandexDictionaryClient, bookReader, prefs)
}

interface AppDeps {
    fun context(): Context
}