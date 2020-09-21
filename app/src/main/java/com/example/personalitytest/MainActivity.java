package com.example.personalitytest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentCallbacks2;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button mStartButton ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView Welcome;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/FredokaOne-Regular.ttf");
        Welcome = (TextView)findViewById(R.id.welcome);
        mStartButton = (Button)findViewById(R.id.startButton);

        Welcome.setTypeface(typeface);
        mStartButton.setTypeface(typeface);

        Welcome.setText("Welcome to Mentor Assessment Test!");
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,QuizActivity.class));
            }
        });
    }

}