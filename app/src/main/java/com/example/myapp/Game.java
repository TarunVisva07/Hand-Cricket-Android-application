package com.example.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    protected  String getPlayer(char player){
        String playerName = "";
        if(player=='U'){
            playerName = "YOU";
        }
        else{
            playerName = "COMP";
        }
        return playerName;
    }
    protected   void updateScore(TextView number, int userChoice, int compChoice, char batter){
        int score = Integer.parseInt(number.getText().toString());
        if(batter=='U'){
            score = score + userChoice;
        }
        else if (batter=='C'){
            score = score + compChoice;
        }
        number.setText(String.valueOf(score));
    }
    protected void updateChoice(char player,int inp){
        TextView t = new TextView(this);
        String playerName = "";
        if(player=='U'){
            t = (TextView) findViewById(R.id.userScore);
            playerName = getPlayer(player)+" : ";
        }
        else if(player=='C'){
            t = (TextView) findViewById(R.id.compScore);
            playerName = getPlayer(player)+" : ";
        }
        t.setText(playerName+String.valueOf(inp));

    }
    protected   int getRandomNumber(int min, int max) {
        return (int) ((Math.random()
                * (max - min)) + min);
    }
    protected void setScoreColor(char batter,TextView score){
        if(batter=='U'){
            score.setTextColor(Color.parseColor("#008000"));
        }
        else if(batter=='C'){
            score.setTextColor(Color.parseColor("#B81E1E"));
        }
    }
    protected  int computeScore(int value,TextView number,char batter){
        updateChoice('U',value);
        int compChoice = getRandomNumber(1,7);
        updateChoice('C',compChoice);
        if (compChoice==value){
            // TextView wicket = (TextView) findViewById(R.id.editTextTextPersonName2);
            //wicket.setText("Wicket!!!");
            return -1;
        }
        updateScore(number,value,compChoice,batter);
        return 0;
    }
    protected void displayTurn(char batter){
        TextView turn = (TextView)findViewById(R.id.turn);
        if(batter == 'U'){
            turn.setText("You are batting");
        }
        else{
            turn.setText("Computer is batting");
        }

    }
    protected void disableButtons(Button[] buttonSet){
        for(Button button:buttonSet){
            button.setClickable(false);
        }

    }
    protected char switchBatter(char batter){
        return batter=='U'?'C':'U';
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
