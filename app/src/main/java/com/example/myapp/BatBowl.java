package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BatBowl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = (TextView) findViewById(R.id.title);
        title.setText("Bat or Bowl ?");
        Button bat = (Button) findViewById(R.id.left);
        bat.setText("BAT");
        Button bowl = (Button) findViewById(R.id.right);
        bowl.setText("BOWL");
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winner = "UBAT";
                Intent intent = new Intent(BatBowl.this,GamePage.class);
                intent.putExtra("winner",winner);
                startActivity(intent);
            }
        });
        bowl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String winner = "UBOWL";
                Intent intent = new Intent(BatBowl.this,GamePage.class);
                intent.putExtra("winner",winner);
                startActivity(intent);
            }
        });

    }
}