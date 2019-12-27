package jatx.foreignreader.di

import android.content.Context
import dagger.*
import jatx.filereader.FileReader
import jatx.filereader.FileReaderImpl
import jatx.foreignreader.adapters.ContentsAdapter
import jatx.foreignreader.adapters.ParagraphsAdapter
import jatx.foreignreader.prefs.Prefs
import jatx.foreignreader.prefs.PrefsImpl
import jatx.foreignreader.presentation.MainPresenter
import jatx.foreignreader.ui.MainActivity
import jatx.yandexdictionaryclient.YandexDictionaryClient
import jatx.yandexdictionaryclient.YandexDictionaryClientImpl
import moxy.presenter.ProvidePresenter

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
    fun provideFileReader(fileReaderImpl: FileReaderImpl): FileReader

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
        fileReader: FileReader,
        prefs: Prefs
    ) = MainPresenter(context, yandexDictionaryClient, fileReader, prefs)
}

interface AppDeps {
    fun context(): Context
}