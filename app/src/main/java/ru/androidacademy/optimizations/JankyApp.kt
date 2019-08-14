package ru.androidacademy.optimizations

import android.app.Application
import android.graphics.Color
import jp.wasabeef.takt.Seat
import jp.wasabeef.takt.Takt

class JankyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Takt.stock(this)
            .seat(Seat.TOP_RIGHT)
            .size(20.0f)
            .color(Color.WHITE)
            .useCustomControl()
    }

}
