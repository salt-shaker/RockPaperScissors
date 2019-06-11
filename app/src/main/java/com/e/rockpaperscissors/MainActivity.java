package com.e.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int playerPick, cpuPick, winner, pScore, cScore;

    Button btn_rock, btn_paper, btn_scissors;
    ImageView iv_human, iv_cpu;
    TextView tv_scoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);

        iv_human = (ImageView) findViewById(R.id.iv_human);
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);

        tv_scoreBoard = (TextView) findViewById(R.id.tv_scoreBoard);

        pScore = 0;
        cScore = 0;

        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerPick = 1;
                cpuPick = (int) ((Math.random() * 2.5) + 1);
                setImage(iv_human, playerPick);
                setImage(iv_cpu, cpuPick);
                winner = checkWin(playerPick, cpuPick);
                updateBoard(winner);
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerPick = 2;
                cpuPick = (int) ((Math.random() * 2.5) + 1);
                iv_human.setImageResource(R.drawable.paper);
                setImage(iv_human, playerPick);
                setImage(iv_cpu, cpuPick);
                winner = checkWin(playerPick, cpuPick);
                updateBoard(winner);
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerPick = 3;
                cpuPick = (int) ((Math.random() * 2.5) + 1);
                setImage(iv_human, playerPick);
                setImage(iv_cpu, cpuPick);
                winner = checkWin(playerPick, cpuPick);
                updateBoard(winner);
            }
        });


    }

    public int checkWin(int human, int cpu) {
        // Rock, Paper, Scissor
        // 1       2       3

        //Rock
        if (human == 1) {
            // vs Rock
            if (cpu == 1) {
                return 0; // player draw
            }
            // vs Paper
            if (cpu == 2) {
                return -1; // player lose
            }
            // vs Scissors
            if (cpu == 3) {
                return 1; // player win
            }
        }

        // Paper
        if (human == 2) {
            // vs Rock
            if (cpu == 1) {
                return 1; // player win
            }
            // vs Paper
            if (cpu == 2) {
                return 0; // player draw
            }
            // vs Scissors
            if (cpu == 3) {
                return -1; // player lose
            }
        }

        //Scissors
        if (human == 3) {
            // vs Rock
            if (cpu == 1) {
                return -1; // player lose
            }
            // vs Paper
            if (cpu == 2) {
                return 1; // player win
            }
            // vs Scissors
            if (cpu == 3) {
                return 0; // player draw
            }
        }
        return 4; // If something goes wrong
    }

    public void updateBoard(int winner) {

        if (winner == -1) {
            cScore++;
            tv_scoreBoard.setText("Player Score: " + pScore + " | CPU Score: " + cScore);
        }
        if (winner == 0) {
            tv_scoreBoard.setText("Player Score: " + pScore + " | CPU Score: " + cScore);
        }
        if (winner == 1) {
            pScore++;
            tv_scoreBoard.setText("Player Score: " + pScore + " | CPU Score: " + cScore);
        }
    }

    public void setImage(ImageView iv, int i){
        if (i == 1) iv.setImageResource(R.drawable.rock);
        if (i == 2) iv.setImageResource(R.drawable.paper);
        if (i == 3) iv.setImageResource(R.drawable.scissors);
    }
}
