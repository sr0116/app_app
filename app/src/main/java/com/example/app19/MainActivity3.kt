package com.example.app19

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    private lateinit var mPlay: SoundPool
    private var sd01: Int = 0
    private var sd02: Int = 0
    private var sd03: Int = 0
    private var sd04: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //  SoundPool 초기화
        mPlay = SoundPool.Builder()
            .setMaxStreams(4)
            .build()

        sd01 = mPlay.load(this, R.raw.sound11, 1)
        sd02 = mPlay.load(this, R.raw.sound22, 1)
        sd03 = mPlay.load(this, R.raw.sound33, 1)
        sd04 = mPlay.load(this, R.raw.sound44, 1)

        val bassBtn = findViewById<Button>(R.id.button1)
        val snareBtn = findViewById<Button>(R.id.button2)
        val tomBtn   = findViewById<Button>(R.id.button3)
        val cymBtn   = findViewById<Button>(R.id.button4)

        bassBtn.setOnClickListener {
            mPlay.play(sd01, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        snareBtn.setOnClickListener {
            mPlay.play(sd02, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        tomBtn.setOnClickListener {
            mPlay.play(sd03, 1.0f, 1.0f, 0, 0, 1.0f)
        }
        cymBtn.setOnClickListener {
            mPlay.play(sd04, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }
}
