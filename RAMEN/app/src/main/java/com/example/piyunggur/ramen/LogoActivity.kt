package com.example.piyunggur.ramen

import android.content.Intent
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class LogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logo_layout)

//        object : CountDownTimer(1500, 1) {
//            override fun onTick(millisUntilFinished: Long) {
//
//            }
//
//            override fun onFinish() {
//                //sstartActivity(Intent(this@LogoActivity, LearnActivi ty::class.java))
//                finish()
//            }
//        }.start()
    }
}
