package app.tsampa

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TsampaApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}