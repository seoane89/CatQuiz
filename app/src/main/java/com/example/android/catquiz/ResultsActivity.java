package com.example.android.catquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    TextView userName;
    TextView userScore;
    TextView congratsMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent ResultsIntent = getIntent();
        final Bundle bundle = ResultsIntent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);
        userName = findViewById(R.id.name_text);
        userScore = findViewById(R.id.score_text);
        congratsMessage = findViewById(R.id.results_text);

//creates a message to congratulate the user based on the number of correct answers
        userName.setText(name);
        userScore.setText(score + "/6");
        if (score <= 4) {
            congratsMessage.setText(R.string.do_better);
        }
        if (score >= 4) {
            congratsMessage.setText(R.string.an_expert);
        }


    }
    //Saves the state of our intent keys and score value when the screen is rotated
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBundle("bundle", bundle);
        savedInstanceState.putInt("score", score);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bundle = savedInstanceState.getBundle("bundle");
        score = savedInstanceState.getInt("score");
    }
}
