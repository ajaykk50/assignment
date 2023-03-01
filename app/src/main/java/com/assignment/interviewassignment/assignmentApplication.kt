package com.assignment.interviewassignment

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class assignmentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}