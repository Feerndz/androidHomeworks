package com.example.myprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOk.setOnClickListener {

            ProgressBar.visibility = View.VISIBLE
            Handler().postDelayed({
                ProgressBar.visibility = View.GONE
            }, 5000)

        }

    }
}
