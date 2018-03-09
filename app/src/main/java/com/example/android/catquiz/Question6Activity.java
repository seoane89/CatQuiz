package com.example.android.catquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Question6Activity extends AppCompatActivity {
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    EditText question6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        Intent question6Intent = getIntent();
        final Bundle bundle = question6Intent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);
        question6 = findViewById(R.id.q6_answer);
    }

    public void checkAnswer() {
// Checks if we answered correctly

        String q6Answer = question6.getText().toString().toLowerCase();
        if (q6Answer.equals(getString(R.string.q6_1))) {
            score = score + 1;
        }
        if (q6Answer.equals(getString(R.string.q6_2))) {
            score = score + 1;
        }
        if (q6Answer.equals(getString(R.string.q6_3))) {
            score = score + 1;
        }
    }


    public void onNextButtonClicked(View view) {
        checkAnswer();
        Intent resultsIntent = new Intent(Question6Activity.this, ResultsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, name);
        bundle.putInt(SCORE_KEY, score);
        resultsIntent.putExtras(bundle);
        startActivity(resultsIntent);
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