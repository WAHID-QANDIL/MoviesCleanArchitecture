package com.wahid.moviesCleanArchitecture

import android.app.Application

class MovieApp: Application() {
    companion object{
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }
}