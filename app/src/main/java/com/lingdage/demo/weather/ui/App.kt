package com.lingdage.demo.weather.ui

import android.app.Application
import com.lingdage.demo.weather.extensions.DelegatesExt

/**
 * author: lingdage
 * date  : 2017-11-08 3:58 PM.
 * github : https://github.com/lingdage
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }
    
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}