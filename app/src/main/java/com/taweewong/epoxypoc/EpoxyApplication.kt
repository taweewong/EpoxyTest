package com.taweewong.epoxypoc

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class EpoxyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}