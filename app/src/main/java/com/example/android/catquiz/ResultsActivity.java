package com.example.android.catquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";
    public int score = MainActivity.score;
    public String name;
    Bundle bundle;
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

    //creates an intent for the Reset button, that takes you back to the Main Activity
    public void startMainActivity(View view) {
        Intent startMain = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(startMain);
    }

    //creates an intent for the Share Results button, which takes you to an email app to share your results with your friends
    public void shareResults(View view) {
        String shareMessageBody;
        String congrMessage = congratsMessage.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SENDTO);
        shareIntent.setType("text");
        shareIntent.setData(Uri.parse("mailto:")); // only email apps should handle this
        shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.share_subject));
        shareMessageBody = getString(R.string.results_message_body);
        shareMessageBody += "\n" + name;
        shareMessageBody += "\n" + score + "/6";
        shareMessageBody += "\n" + congrMessage;
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareMessageBody);
        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(shareIntent);

        }
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
