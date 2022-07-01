package com.example.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondInnings extends Game{

    public void declareWinner(int score,int firstInningsScore,char batter,Button playAgain,View view,Button[] buttonSet){
        playAgain.setVisibility(view.VISIBLE);
        int rundiff = score - firstInningsScore;
        char won = '_';
        if(rundiff>0){
            won = batter;
        }
        else if(rundiff<0){
            won = switchBatter(batter);
        }
        else{
            won = 'T';
        }
        String message = "";
        rundiff = Math.abs(rundiff);
        TextView turn = (TextView) findViewById(R.id.turn);
        switch(won){
            case 'U':{
                message = "Congrats!! You won by "+rundiff +" runs";
                turn.setTextColor(Color.parseColor("#008000"));
                break;
            }
            case 'C':{
                message = "Computer has won by "+rundiff +" runs";
                turn.setTextColor(Color.parseColor("#B81E1E"));
                break;
            }
            case 'T':{
                message = "Match tied !";
                turn.setTextColor(Color.parseColor("#008000"));
            }
        }

        turn.setText(message);
        disableButtons(buttonSet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        TextView number = (TextView) findViewById(R.id.editTextNumber);

        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        Button six = (Button) findViewById(R.id.button6);
        Button[] buttonSet = {one,two,three,four,five,six};

        TextView turn = (TextView) findViewById(R.id.turn);
        Button playAgain  = (Button) findViewById(R.id.bottom);
        playAgain.setText("play again");
        Bundle extras = getIntent().getExtras();
        char batter = extras.getChar("batter");
        int firstInningsScore = extras.getInt("firstInningsScore");
        //batter = switchBatter(batter);
        displayTurn(batter);
        setScoreColor(batter,number);
        number.setText("0");
        TextView target = (TextView) findViewById(R.id.target);
        String targetMessage ="Target : "+String.valueOf(firstInningsScore+1);
        target.setText(targetMessage);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(1,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(2,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(3,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(4,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(5,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = computeScore(6,number,batter);
                int score = Integer.parseInt(number.getText().toString());
                if(score>firstInningsScore || status==-1){
                    declareWinner(score,firstInningsScore,batter,playAgain,view,buttonSet);
                }
            }
        });
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondInnings.this,MainActivity.class);
                startActivity(intent);
            }
        });





    }
}