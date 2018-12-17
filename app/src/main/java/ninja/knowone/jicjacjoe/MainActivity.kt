package ninja.knowone.jicjacjoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

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
            btnChoice.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            findWinner(player1)
            activePlayer = 2
        } else {
            btnChoice.text = "O"
            btnChoice.setBackgroundColor(Color.BLUE)
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
}
