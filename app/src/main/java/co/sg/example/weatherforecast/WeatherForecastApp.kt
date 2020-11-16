package co.sg.example.weatherforecast

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import co.sg.example.weatherforecast.repositories.forecastListRepositoryModule
import co.sg.example.weatherforecast.viewmodels.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber
import zerobranch.androidremotedebugger.AndroidRemoteDebugger
import zerobranch.androidremotedebugger.BuildConfig

class WeatherForecastApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        initLogging()

        startKoin {
            androidLogger()
            androidContext(this@WeatherForecastApp)
            modules(
                viewModelModule,
                forecastListRepositoryModule
            )
        }
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            AndroidRemoteDebugger.init(
                AndroidRemoteDebugger.Builder(applicationContext)
                    .enabled(true)
                    .disableInternalLogging()
                    .enableDuplicateLogging() // all logs from `Logging` section will also be printed in logcat
                    .build()
            )
            Timber.plant(Timber.DebugTree())
        }
    }
}