package com.example.android.catquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    RadioGroup question1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        Intent question1Intent = getIntent();
        final Bundle bundle = question1Intent.getExtras();
        name = bundle.getString(NAME_KEY);
        score = bundle.getInt(SCORE_KEY);

//checks if the user answered correct the question
        checkAnswer();


// Creates an onClick Listener on the next button, which opens an intent to the next question screen

        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent question2Intent = new Intent(Question1Activity.this, Question2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString(NAME_KEY, name);
                bundle.putInt(SCORE_KEY, score);
                question2Intent.putExtras(bundle);
                startActivity(question2Intent);
            }
        });
    }


    public void checkAnswer() {
// Checks if we answered correctly, or else gives out a warning toast
        question1 = findViewById(R.id.q1);
        if (question1.getCheckedRadioButtonId() == R.id.q1a) {
            score += 1;}
            else if (question1.getCheckedRadioButtonId() == R.id.q1b){
            Toast.makeText(getApplicationContext(), getString(R.string.wrong_answer),
                    Toast.LENGTH_SHORT).show();
            // ask how to make the toast show only when one of the other answers is checked
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
    }}