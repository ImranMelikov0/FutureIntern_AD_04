package com.imranmelikov.futureintern_ad_04

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.imranmelikov.futureintern_ad_04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var player=1
    private lateinit var selectedBtn:Button
    private var mutableButtonList= mutableListOf<Button>()
    private var mutableWinList= mutableListOf<Button>()
    private var player1Point=0
    private var player2Point=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        click()
        binding.apply {
            mutableWinList= mutableListOf(button,button2,button3,button4,button5,button6,button7,button8,button9)
        }
    }
    private fun win(){
            if (checkWinner()==1){
                Toast.makeText(this,"Player1 Win",Toast.LENGTH_SHORT).show()
                player1Point+=1
                for (button in mutableWinList){
                    button.isEnabled=false
                }
                binding.textView.text="Player1 : $player1Point"
            }else if (checkWinner()==2){
                Toast.makeText(this,"Player2 Win",Toast.LENGTH_SHORT).show()
                player2Point+=1
                for (button in mutableWinList){
                    button.isEnabled=false
                }
                binding.textView2.text="Player2 : $player2Point"
            }
    }

    private fun selectedBtn(){
           if (player==1){
               selectedBtn.text="X"
               selectedBtn.isEnabled=false
               selectedBtn.setTextColor(ContextCompat.getColor(this,R.color.red))
               player=2
           }else{
               selectedBtn.text="O"
               selectedBtn.isEnabled=false
               selectedBtn.setTextColor(ContextCompat.getColor(this,R.color.blue))
               player=1
           }
        win()
    }
    private fun click(){
            binding.apply {
                button.setOnClickListener {
                    selectedBtn=button
                    mutableButtonList.add(button)
                    selectedBtn()
                }
                button2.setOnClickListener {
                    selectedBtn=button2
                    mutableButtonList.add(button2)
                    selectedBtn()
                }
                button3.setOnClickListener {
                    selectedBtn=button3
                    mutableButtonList.add(button3)
                    selectedBtn()
                }
                button4.setOnClickListener {
                    selectedBtn=button4
                    mutableButtonList.add(button4)
                    selectedBtn()
                }
                button5.setOnClickListener {
                    selectedBtn=button5
                    mutableButtonList.add(button5)
                    selectedBtn()
                }
                button6.setOnClickListener {
                    selectedBtn=button6
                    mutableButtonList.add(button6)
                    selectedBtn()
                }
                button7.setOnClickListener {
                    selectedBtn=button7
                    mutableButtonList.add(button7)
                    selectedBtn()
                }
                button8.setOnClickListener {
                    selectedBtn=button8
                    mutableButtonList.add(button8)
                    selectedBtn()
                }
                button9.setOnClickListener {
                    selectedBtn=button9
                    mutableButtonList.add(button9)
                    selectedBtn()
                }
                button10.setOnClickListener {
                    reset()
                }
                button11.setOnClickListener {
                    newGame()
                }
        }
    }

    private fun newGame() {
        binding.apply {
            for (button in mutableWinList){
                button.isEnabled=true
                button.text=""
            }
            mutableButtonList.clear()
        }
    }

   private val winningCombinations = mutableListOf(
        mutableListOf(0, 1, 2),
        mutableListOf(3, 4, 5),
        mutableListOf(6, 7, 8),
        mutableListOf(0, 3, 6),
        mutableListOf(1, 4, 7),
        mutableListOf(2, 5, 8),
        mutableListOf(0, 4, 8),
        mutableListOf(2, 4, 6)
    )

   private fun checkWinner(): Int {
           for (combination in winningCombinations) {
                   if (mutableWinList[combination[0]].text == "X" &&
                       mutableWinList[combination[1]].text == "X" &&
                       mutableWinList[combination[2]].text == "X"
                   ) {
                       return 1
                   }else if (mutableWinList[combination[0]].text == "O" &&
                           mutableWinList[combination[1]].text == "O" &&
                           mutableWinList[combination[2]].text == "O"
                           ) {
                       return 2
                   }
           }
           return 3
       }

    private fun reset(){
        binding.apply {
            for (button in mutableWinList){
                button.isEnabled=true
                button.text=""
            }
            mutableButtonList.clear()
            player1Point=0
            player2Point=0
            textView.text="Player1 : 0"
            textView2.text="Player2 : 0"
        }
    }
}