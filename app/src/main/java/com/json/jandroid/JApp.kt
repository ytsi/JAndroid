package com.json.jandroid

import android.app.Application
import com.json.http.RetrofitClient

class JApp: Application() {
    override fun onCreate() {
        super.onCreate()
        RetrofitClient.getInstance().setContext(applicationContext)
    }
}