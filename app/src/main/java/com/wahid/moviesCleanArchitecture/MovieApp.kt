package com.wahid.moviesCleanArchitecture

import android.app.Application

class MovieApp: Application() {

    companion object {
        lateinit var instance: MovieApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}