package com.example.personalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView  mMentor;
    Button mRetryButton;
    Animation smalltobig;
    ImageView images;
    boolean imageDisplay = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        smalltobig = AnimationUtils.loadAnimation(this,R.anim.smalltobig);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/FredokaOne-Regular.ttf");

        mMentor = (TextView) findViewById(R.id.Mentor);
        mRetryButton = (Button) findViewById(R.id.retry);
        images = findViewById(R.id.images);


        mMentor.setTypeface(typeface);
        mRetryButton.setTypeface(typeface);
        mMentor.startAnimation(smalltobig);

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");



        if (score == 5) {
            images.setImageResource(R.drawable.woman);
            mMentor.setText("Mentor" + "\r\n" + "JULIE, 28" + "\r\n" + "\r\n" + "she work as a PR for multinational company in Indonesia. She like to spend her time practicing her communication skill.");
        } else if (score == 4) {
            images.setImageResource(R.drawable.woman);
            mMentor.setText("Mentor" + "\r\n" + "JULIE, 28 " +"\r\n" + "\r\n" + "she often work on arranging social event,she can charm people with her charismatic leadership by listening to people.  ");
        } else if (score == 3) {
            images.setImageResource(R.drawable.woman);
            mMentor.setText("Mentor" + "\r\n" + "JULIE, 28 " + "\r\n" + "\r\n"  + "She know how to manage her time and she have the perfect secret to balance her work and personal life!");
        } else if (score == 2) {
            images.setImageResource(R.drawable.man);
            mMentor.setText("Mentor " + "\r\n" + " JORDAN, 30 " + "\r\n" + "\r\n"  + "He work as a research scientist for the government, he like to record and analyze data with his fellow scientist");
        } else if (score == 1) {
            images.setImageResource(R.drawable.man);
            mMentor.setText("Mentor " + "\r\n" + "JORDAN, 30 " + "\r\n" + "\r\n" + "He like to write research paper alone in his lab so that he could think and it bring him peace ");
        } else if (score == 0) {
            images.setImageResource(R.drawable.man);
            mMentor.setText("Mentor" + "\r\n" + "JORDAN, 30 " + "\r\n" + "\r\n" + "He doesn't go out much except to go to work, but it's a good thing he said. He have more time exploring new hobbies and discovering new invention ");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, QuizActivity.class));
                ResultActivity.this.finish();
            }
        });
    }
}