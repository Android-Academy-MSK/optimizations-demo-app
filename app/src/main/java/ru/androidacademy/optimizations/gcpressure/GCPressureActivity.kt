package ru.androidacademy.optimizations.gcpressure

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.androidacademy.optimizations.R

class GCPressureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_gc_pressume)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, GCPressureActivity::class.java))
        }
    }

}