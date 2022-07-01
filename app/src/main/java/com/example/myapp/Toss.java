package com.example.myapp;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;
import android.widget.EditText;
import android.widget.Toast;


import org.w3c.dom.Text;

public class Toss extends AppCompatActivity
{
    protected void disableButtons(Button[] buttonSet) {
        for (Button button : buttonSet) {
            button.setClickable(false);
        }
    }

    public void updateChoice(char player,int inp){
        TextView t = new TextView(this);
        String playerName = "";
        if(player=='U'){
            t = (TextView) findViewById(R.id.userScore);
            playerName = "You : ";
        }
        else if(player=='C'){
            t = (TextView) findViewById(R.id.compScore);
            playerName = "Comp : ";
        }

        t.setText(playerName+String.valueOf(inp));

    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void getTossResult(TextView tossResult,int value,String choice,Button[] buttonSet){
        updateChoice('U',value);
        int compChoice = getRandomNumber(1,6);
        updateChoice('C',compChoice);
        int total = value + compChoice;
        char winner = '_';
        if((total%2==0 && choice.equals("EVEN"))||(total%2==1 && choice.equals("ODD")))
        {
            tossResult.setText("You have won the toss !!");
            tossResult.setTextColor(Color.parseColor("#008000"));
        }
        else {
            tossResult.setText("Computer has won the toss");
            tossResult.setTextColor(Color.parseColor("#B81E1E"));
        }
        disableButtons(buttonSet);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        TextView number = (TextView) findViewById(R.id.editTextNumber);

        Button one = (Button) findViewById(R.id.button1);
        Button two = (Button) findViewById(R.id.button2);
        Button three = (Button) findViewById(R.id.button3);
        Button four = (Button) findViewById(R.id.button4);
        Button five = (Button) findViewById(R.id.button5);
        Button six = (Button) findViewById(R.id.button6);
        Button[] buttonSet = {one,two,three,four,five,six};

        Button next  = (Button)findViewById(R.id.next);
        TextView tossTitle = (TextView) findViewById(R.id.tossTitle);
        Bundle extras = getIntent().getExtras();
        String choice = extras.getString("choice");
        tossTitle.setText(choice);
        TextView tossResult = (TextView) findViewById(R.id.tossResult);

        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,1,choice,buttonSet);
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,2,choice,buttonSet);
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,3,choice,buttonSet);
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,4,choice,buttonSet);
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,5,choice,buttonSet);
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getTossResult(tossResult,6,choice,buttonSet);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                char winner = tossResult.getText().toString().charAt(0);
                if(winner=='Y'){
                    Intent intent = new Intent(Toss.this,BatBowl.class);
                    //intent.putExtra("winner",winner);
                    startActivity(intent);
                }
                else if (winner=='C'){
                    Intent intent = new Intent(Toss.this,GamePage.class);
                    intent.putExtra("winner","C");
                    startActivity(intent);
                }

            }
        });





    }




}