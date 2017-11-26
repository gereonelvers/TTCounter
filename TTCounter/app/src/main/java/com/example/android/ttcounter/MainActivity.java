package com.example.android.ttcounter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.ttcounter.R;

public class MainActivity extends AppCompatActivity {
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    String scoreText1 = "Currently ";
    String scoreText2 = " is in the lead, the score is ";
    String scoreText3 = ":";
    int playerAGames = 0;
    int playerBGames = 0;

    String serveText = " has to serve";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForPlayerA(View v) {
        scorePlayerA = scorePlayerA + 1;
        displayForTeamA(scorePlayerA);

        if(scorePlayerA > scorePlayerB){ displayScoreText(scoreText1 + "PlayerA" + scoreText2 + scorePlayerA + scoreText3 + scorePlayerB); }
        else if(scorePlayerB > scorePlayerA){displayScoreText(scoreText1 + "PlayerB" + scoreText2 + scorePlayerA + scoreText3 + scorePlayerB);}
        else {displayScoreText("Currently the score is even at " + scorePlayerA + scoreText3 + scorePlayerB);}

        if((scorePlayerA + scorePlayerB) % 2 == 0 ){displayServeText("PlayerA" + serveText);}
        else{displayServeText("PlayerB" + serveText);}

        if(scorePlayerA >= 12 & scorePlayerB + 2 <= scorePlayerA){
            displayScoreText("PlayerA has won!");
            playerAGames = playerAGames + 1;
            displayPlayerAGames(playerAGames);
            scorePlayerA = 0;
            scorePlayerB = 0;
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Game over!");
            alertDialog.setMessage("PlayerA has won, the scores have been reset!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        displayForTeamA(scorePlayerA);
        displayForTeamB(scorePlayerB);}
    }


    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForPlayerB(View v) {
        scorePlayerB = scorePlayerB + 1;
        displayForTeamB(scorePlayerB);

        if(scorePlayerA > scorePlayerB){ displayScoreText(scoreText1 + "PlayerA" + scoreText2 + scorePlayerA + scoreText3 + scorePlayerB); }
        else if(scorePlayerB > scorePlayerA){displayScoreText(scoreText1 + "PlayerB" + scoreText2 + scorePlayerA + scoreText3 + scorePlayerB);}
        else {displayScoreText("Currently the score is even at " + scorePlayerA + scoreText3 + scorePlayerB);}

        if((scorePlayerA + scorePlayerB) % 2 == 0 ){displayServeText("PlayerA" + serveText);}
        else{displayServeText("PlayerB" + serveText);}


        if(scorePlayerB >= 12 & scorePlayerA + 2 <= scorePlayerB){
            displayScoreText("PlayerB has won!");
            scorePlayerA = 0;
            scorePlayerB = 0;
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setTitle("Game over!");
            alertDialog.setMessage("PlayerB has won, the scores have been reset!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK!",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
            playerBGames = playerBGames + 1;
            displayPlayerBGames(playerBGames);
            displayForTeamA(scorePlayerA);
            displayForTeamB(scorePlayerB);
        }
    }



    /**
     * Resets Scores and Games
     */
    public void resetAll(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        playerAGames = 0;
        playerBGames = 0;
        displayForTeamA(scorePlayerA);
        displayForTeamB(scorePlayerB);
        displayPlayerAGames(playerAGames);
        displayPlayerBGames(playerBGames);
    }

    /**
     * Resets Scores
     */
    public void resetScore(View v) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        displayForTeamA(scorePlayerA);
        displayForTeamB(scorePlayerB);
    }

    /**
     * Updates scoreView
     */
    public void displayScoreText(String score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreText);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Updates serveView
     */
    public void displayServeText(String serve) {
        TextView scoreView = (TextView) findViewById(R.id.serveText);
        scoreView.setText(String.valueOf(serve));
    }

    /**
     * Displays PlayerA's won games
     */
    public void displayPlayerAGames(int games) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_games);
        scoreView.setText(String.valueOf(games));
    }

    /**
     * Displays PlayerB's won games
     */
    public void displayPlayerBGames(int games) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_games);
        scoreView.setText(String.valueOf(games));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(score));
    }
}