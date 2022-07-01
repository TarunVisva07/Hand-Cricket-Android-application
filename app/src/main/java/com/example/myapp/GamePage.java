package com.example.myapp;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GamePage extends Game
{
    public char getBatter(String winner,Bundle extras){
        char batter = '_';
        if(winner.equals("UBAT")){
            batter = 'U';
        }
        else if(winner.equals("UBOWL")){
            batter = 'C';
        }
        else if(winner.equals("C")){
            int random = getRandomNumber(1,100);
            //Computer makes random choice as to bat or bowl
            if(random%2==0){
                batter = 'U';
            }
            else{
                batter = 'C';
            }
        }
        return batter;
    }
    public void declareWicket(Button nextInn,View v,TextView turn,Button[] buttonSet,char batter){
        nextInn.setVisibility(v.VISIBLE);
        turn.setText("Wicket!!");
        if(batter=='U') turn.setTextColor(Color.parseColor("#B81E1E"));
        else if (batter=='C') turn.setTextColor(Color.parseColor("#008000"));
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

        Button nextInn = (Button) findViewById(R.id.bottom);
        TextView turn = (TextView) findViewById(R.id.turn);
        Bundle extras = getIntent().getExtras();
        String winner = extras.getString("winner");
        char batter = getBatter(winner,extras);
        setScoreColor(batter,number);
        displayTurn(batter);
        number.setText("0");
        one.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(1, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);
                }
            }
        });
        two.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(2, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);

                }
            }
        });
        three.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(3, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);
                }
            }
        });
        four.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(4, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);
                }
            }
        });
        five.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(5, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);
                }
            }
        });
        six.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Getting who bats initially
                int status = computeScore(6, number, batter);//Calculate score for the batter
                if(status==-1){
                    declareWicket(nextInn,v,turn,buttonSet,batter);
                }
            }
        });
        nextInn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int firstInningsScore = Integer.parseInt(number.getText().toString());
                Intent intent = new Intent(GamePage.this,SecondInnings.class);
                intent.putExtra("firstInningsScore",firstInningsScore);
                intent.putExtra("batter",switchBatter(batter));
                startActivity(intent);
            }
        });

    }
}