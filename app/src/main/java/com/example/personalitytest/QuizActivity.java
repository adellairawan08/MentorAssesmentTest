package com.example.personalitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class QuizActivity extends AppCompatActivity {


    private TextView mQuestion,mPrompt;
    private Button mTrueButton,mFalseButton;


    private boolean mAnswer;
    private int mScore = 0;
    private int mQuestionsNumber = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/FredokaOne-Regular.ttf");
        mQuestion = (TextView)findViewById(R.id.questions);
        mTrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton = (Button) findViewById(R.id.falseButton);
        mPrompt=(TextView)findViewById(R.id.prompt);

        mQuestion.setTypeface(typeface);
        mPrompt.setTypeface(typeface);
        mTrueButton.setTypeface(typeface);
        mFalseButton.setTypeface(typeface);

        updateQuestion();
        //Logic for true button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (mAnswer == true) {
                   mScore++;

                   if (mQuestionsNumber == QuizBook.questions.length ){
                       Intent i = new Intent(QuizActivity.this ,ResultActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putInt("finalScore",mScore);
                       i.putExtras(bundle);
                       QuizActivity.this.finish();
                       startActivity(i);
                   }else {
                       updateQuestion();
                   }
               }
               else {
                   if (mQuestionsNumber == QuizBook.questions.length ) {
                       Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                       Bundle bundle = new Bundle();
                       bundle.putInt("finalScore", mScore);
                       i.putExtras(bundle);
                       QuizActivity.this.finish();
                       startActivity(i);
                   }else {
                       updateQuestion();
                   }
               }
            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswer == false) {
                    mScore++;

                    if (mQuestionsNumber == QuizBook.questions.length ){
                        Intent i = new Intent(QuizActivity.this ,ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore",mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
                else {
                    if (mQuestionsNumber == QuizBook.questions.length ) {
                        Intent i = new Intent(QuizActivity.this, ResultActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", mScore);
                        i.putExtras(bundle);
                        QuizActivity.this.finish();
                        startActivity(i);
                    }else {
                        updateQuestion();
                    }
                }
            }
        });
    }
    private void updateQuestion(){
        mQuestion.setText(QuizBook.questions[mQuestionsNumber]);
        mAnswer = QuizBook.answers[mQuestionsNumber];
        mQuestionsNumber++;
    }
}