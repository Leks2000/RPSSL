package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startbtn = findViewById(R.id.Start)
        imgbot = findViewById(R.id.imgfrombot)
        infofortext = findViewById(R.id.txtforres)
        imgplajer = findViewById(R.id.imgfromplajer)
        resulttext = findViewById(R.id.TextForExample)
    }
    private lateinit var startbtn: Button
    private lateinit var imgbot: ImageView
    private lateinit var imgplajer: ImageView
    private lateinit var resulttext: TextView
    private lateinit var infofortext: TextView
    var win = 0
    var lose = 0
    var draw = 0
    var count = 0
    private var bot = 0
    var playerchoise: Int = 0


    @SuppressLint("ResourceType")
    fun startBtn(view: View) {
        if(count == 0){
            timerStart()
        }
        when(playerchoise == 0){
            true -> infofortext.text = "Сделайте свой выбор"
            else -> {
                check()
                val list = arrayOf("Камень","Бумагу","Спок","Ножницы","Ящерицу")
                infofortext.text = "Вы выбрали ${list[playerchoise - 1]} бот выбрал ${list[bot - 1]}"
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
            1 -> when (bot)
            {
                2,3 -> return lose()
                4,5 -> return win()
            }
            2 -> when (bot)
            {
                1,3 -> return win()
                4,5 -> return lose()
            }
            3 -> when (bot)
            {
                1,4 -> return win()
                2,5 -> return lose()
            }
            4 -> when (bot)
            {
                1,3 -> return lose()
                2,5 -> return win()
            }
            5 -> when (bot)
            {
                1,4 -> return lose()
                2,3 -> return win()
            }
        }
        return ("Ничья".also {
            draw++
            this.resulttext.text = it
        })
    }
    private fun win(){
        win++
        "Вы Проиграли".also { resulttext.text = it }
    }
    private fun lose(){
        lose++
        "Вы Победили".also { resulttext.text = it }
    }
    private val timer = object: CountDownTimer(50000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
        count++
        }
        override fun onFinish() {
        }
    }
    private fun timerStart(){
        timer.start()
    }
    fun timerStop(view: View){
        timer.cancel()
        infofortext.text = "Ничья:${draw} Победы:${win} Поражения:${lose}"
        resulttext.text = "Время игры:${count}"
        count = 0
        lose = 0
        win = 0
        draw = 0
    }
}
