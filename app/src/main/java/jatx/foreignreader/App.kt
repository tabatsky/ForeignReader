package jatx.foreignreader

import android.app.Application
import jatx.foreignreader.di.AppComponent
import jatx.foreignreader.di.DaggerAppComponent

class App : Application() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .context(this)
            .build()
    }
}