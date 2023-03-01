package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resulttext = findViewById(R.id.TextForExample)
        infofortext = findViewById(R.id.txtforres)
        imgplajer = findViewById(R.id.imgfromplajer)
        imgbot = findViewById(R.id.imgfrombot)
        startbtn = findViewById(R.id.Start)
    }
    private lateinit var resulttext: TextView
    private lateinit var imgplajer: ImageView
    private lateinit var imgbot: ImageView
    private lateinit var infofortext: TextView
    private lateinit var startbtn: Button
    var bot = 0
    var playerchoise: Int = 0



    @SuppressLint("ResourceType")
    fun startBtn(view: View) {
        when(playerchoise == 0){
            true -> infofortext.text = "Пожалуйста выбирите 1 из 5 вариантов"
            else -> {
                check()
                infofortext.text = "Вы выбрали $playerchoise бот выбрал ${bot}"
                when(playerchoise) {
                    1 -> imgplajer.setImageResource(R.drawable.rock)
                    2 -> imgplajer.setImageResource(R.drawable.paper)
                    3 -> imgplajer.setImageResource(R.drawable.spoke)
                    4 -> imgplajer.setImageResource(R.drawable.scissors)
                    5 -> imgplajer.setImageResource(R.drawable.lizard)
                }
                when(bot){
                    1 -> imgbot.setImageResource(R.drawable.rock)
                    2 -> imgbot.setImageResource(R.drawable.paper)
                    3 -> imgbot.setImageResource(R.drawable.spoke)
                    4 -> imgbot.setImageResource(R.drawable.scissors)
                    5 -> imgbot.setImageResource(R.drawable.lizard)
                }
            }
        }
    }

    fun btnRock(view: View) {
        playerchoise = 1
    }

    fun btnPaper(view: View) {
        playerchoise = 2
    }

    fun btnSpoke(view: View) {
        playerchoise = 3
    }

    fun btnCrock(view: View) {
        playerchoise = 4
    }

    fun btnlizard(view: View) {
        playerchoise = 5
    }

    @SuppressLint("SetTextI18n")
    private fun check(): Any {
        bot = (1..5).random()
        when (playerchoise) {
            1 -> when (bot) {
                2 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                3 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                4 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                5 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
            }
            2 -> when (bot) {
                1 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                3 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                4 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                5 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
            }
            3 -> when (bot) {
                1 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                2 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                4 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                5 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
            }
            4 -> when (bot) {
                1 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                2 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                3 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                5 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
            }
            5 -> when (bot) {
                1 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
                2 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                3 -> {
                    return "Вы Победили".also { resulttext.text = it }
                }
                4 -> {
                    return "Вы Проиграли".also { resulttext.text = it }
                }
            }
        }
        return ("Ничья".also { this.resulttext.text = it })

    }
}
