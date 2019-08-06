package ru.androidacademy.optimizations.computeonmain

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.androidacademy.optimizations.R

class ComputeOnMainThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_compute_on_main_thread)
    }

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, ComputeOnMainThreadActivity::class.java))
        }
    }

}