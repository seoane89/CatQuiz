package com.example.android.catquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Question3Activity extends AppCompatActivity {
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    RadioGroup question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        Intent question3Intent = getIntent();
        final Bundle bundle = question3Intent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);
        question3 = findViewById(R.id.q3);
    }

    public void checkAnswer() {
// Checks if we answered correctly

        if (question3.getCheckedRadioButtonId() == R.id.q3a) {
            score += 1;
        }
    }


    public void onNextButtonClicked(View view) {
        checkAnswer();
        Intent question4Intent = new Intent(Question3Activity.this, Question4Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, name);
        bundle.putInt(SCORE_KEY, score);
        question4Intent.putExtras(bundle);
        startActivity(question4Intent);
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