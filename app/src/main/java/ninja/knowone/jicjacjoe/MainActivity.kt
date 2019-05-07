package ninja.knowone.jicjacjoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View) {

        val btnChoice = view as Button
        var cellID = 0
        when (btnChoice.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }

        playGame(cellID, btnChoice)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    fun playGame(cellID:Int, btnChoice: Button) {

        if (activePlayer == 1) {
            btnChoice.text = "X"
            btnChoice.setBackgroundResource(R.color.peaGreen)
            player1.add(cellID)
            findWinner(player1)
            activePlayer = 2
            autoPlay()
        } else {
            btnChoice.text = "O"
            btnChoice.setBackgroundResource(R.color.softBlue)
            player2.add(cellID)
            findWinner(player2)
            activePlayer = 1
        }

        btnChoice.isEnabled = false
    }

    fun findWinner(P : ArrayList<Int>) {
        var winner = -1

        if (P.containsAll(listOf(1, 2, 3)) ||
            P.containsAll(listOf(4, 5, 6)) ||
            P.containsAll(listOf(7, 8, 9)) ||
            P.containsAll(listOf(1, 4, 7)) ||
            P.containsAll(listOf(2, 5, 8)) ||
            P.containsAll(listOf(3, 6, 9)) ||
            P.containsAll(listOf(1, 5, 9)) ||
            P.containsAll(listOf(3, 5, 7))) {
            winner = activePlayer
            Toast.makeText(this, "Player $winner is the winner!", Toast.LENGTH_LONG).show()
        }
    }

    fun autoPlay() {

        var emptyCell = ArrayList<Int>()
        for (cellId in 1..9) {
            if (!(player1.contains(cellId) || player2.contains(cellId))) {
                emptyCell.add(cellId)
            }
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCell.size -0) +0
        val cellID = emptyCell[randIndex]

        val randBtn:Button?
        when (cellID) {
            1 -> randBtn = btn1
            2 -> randBtn = btn2
            3 -> randBtn = btn3
            4 -> randBtn = btn4
            5 -> randBtn = btn5
            6 -> randBtn = btn6
            7 -> randBtn = btn7
            8 -> randBtn = btn8
            9 -> randBtn = btn9
            else -> randBtn = btn1
        }

        playGame(cellID, randBtn)
    }
}
