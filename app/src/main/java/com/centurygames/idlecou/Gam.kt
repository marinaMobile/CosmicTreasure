package com.centurygames.idlecou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.centurygames.idlecou.databinding.ActivityGamBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.*

class Gam : AppCompatActivity() {
    lateinit var bindGame: ActivityGamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindGame = ActivityGamBinding.inflate(layoutInflater)
        setContentView(bindGame.root)
        var counter: Int = 0
        var counter1: Int = 0
        var counter2: Int = 0

        bindGame.tr1.setOnClickListener{
            counter++
            bindGame.trTitle.text = counter.toString()
        }

        bindGame.tr2.setOnClickListener{
            counter1++
            bindGame.tr1Title.text = counter1.toString()
        }

        bindGame.tr3.setOnClickListener{
            counter2++
            bindGame.tr2Title.text = counter2.toString()
        }

        val running : TextView = findViewById(R.id.running)


        val s : Long = "30".toLong() * 1000

        object : CountDownTimer( s , 1000) {

            override fun onTick(millisUntilFinished: Long) {
                running.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                MaterialAlertDialogBuilder(this@Gam, com.google.android.material.R.style.MaterialAlertDialog_Material3_Body_Text)
                    .setTitle("Time's over!")
                    .setCancelable(false)
                    .setPositiveButton("Play again"){dialog, _ ->
                        startActivity(Intent(applicationContext, Gam::class.java))
                        finish()
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }.start()




        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr1.height)
                    bindGame.tr1.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(200)
                        .start()
                }
            }
        }, 0, 300)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr1.height)
                    bindGame.tr2.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(300)
                        .start()
                }
            }
        }, 0, 400)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.background.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.background.height-bindGame.tr1.height)
                    bindGame.tr3.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(100)
                        .start()
                }
            }
        }, 0, 600)


    }
}