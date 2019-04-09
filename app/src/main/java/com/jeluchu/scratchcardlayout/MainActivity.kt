package com.jeluchu.scratchcardlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cooltechworks.views.ScratchImageView
import kotlinx.android.synthetic.main.activity_main.*
import com.cooltechworks.views.ScratchTextView




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomImage = (0..5).random()

        when (randomImage) {
            1 -> {
                scratch.setImageResource(R.drawable.ic_android)
            }
            3 -> {
                scratch.setImageResource(R.drawable.ic_assignment)
            }
            4 -> {
                scratch.setImageResource(R.drawable.ic_beach)
            }
        }

        scratch.setRevealListener(object : ScratchTextView.IRevealListener, ScratchImageView.IRevealListener {
            override fun onRevealed(iv: ScratchImageView?) {
                Toast.makeText(applicationContext, "Reveled", Toast.LENGTH_LONG).show()
            }

            override fun onRevealPercentChangedListener(siv: ScratchImageView?, percent: Float) {
                if (percent>=0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: $percent")
                }
            }

            override fun onRevealed(tv: ScratchTextView?) {
                Toast.makeText(applicationContext, "Reveled", Toast.LENGTH_LONG).show()
            }

            override fun onRevealPercentChangedListener(stv: ScratchTextView?, percent: Float) {
                if (percent>=0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: $percent")
                }
            }

        })
    }
}

