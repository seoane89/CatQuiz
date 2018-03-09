package com.example.android.catquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Question5Activity extends AppCompatActivity {
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    CheckBox q5a, q5b, q5c, q5d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        Intent question5Intent = getIntent();
        final Bundle bundle = question5Intent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);
        q5a = findViewById(R.id.q5a);
        q5b = findViewById(R.id.q5b);
        q5c = findViewById(R.id.q5c);
        q5d = findViewById(R.id.q5d);
    }

    public void checkAnswer() {
    // Checks if we selected all the correct checkboxes and adds 1 point if we did

        boolean question5a = q5a.isChecked();
        boolean question5b = q5b.isChecked();
        boolean question5c = q5c.isChecked();
        boolean question5d = q5d.isChecked();

        if (question5a && question5b && !question5c && question5d) {
            score = score + 1;
        }
    }

    public void onNextButtonClicked(View view) {
        checkAnswer();
        Intent question6Intent = new Intent(Question5Activity.this, Question6Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString(NAME_KEY, name);
        bundle.putInt(SCORE_KEY, score);
        question6Intent.putExtras(bundle);
        startActivity(question6Intent);
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