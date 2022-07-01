package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String userChoice = "";
        Button odd = (Button) findViewById(R.id.left);
        Button even = (Button) findViewById(R.id.right);
        odd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "ODD";
                Intent intent = new Intent(MainActivity.this,Toss.class);
                intent.putExtra("choice",choice);
                startActivity(intent);
            }
        });
        even.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String choice = "EVEN";
                Intent intent = new Intent(MainActivity.this,Toss.class);
                intent.putExtra("choice",choice);
                startActivity(intent);
            }
        });
    }
}