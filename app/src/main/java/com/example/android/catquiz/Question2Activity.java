package com.example.android.catquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question2Activity extends AppCompatActivity {
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    RadioGroup question2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        Intent question2Intent = getIntent();
        final Bundle bundle = question2Intent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);
        question2 = findViewById(R.id.q2);
    }

    public void checkAnswer() {
// Checks if we answered correctly

        if (question2.getCheckedRadioButtonId() == R.id.q2b) {
            score += 1;
        }
    }


    public void onNextButtonClicked(View view) {
        checkAnswer();
        Intent question3Intent = new Intent(Question2Activity.this, Question3Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, name);
        bundle.putInt(SCORE_KEY, score);
        question3Intent.putExtras(bundle);
        startActivity(question3Intent);
    }

    //Saves the state of our intent keys and score value when the screen is rotated
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(NAME_KEY, name);
        savedInstanceState.putInt(SCORE_KEY, score);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(NAME_KEY);
        score = savedInstanceState.getInt(SCORE_KEY);
    }
}