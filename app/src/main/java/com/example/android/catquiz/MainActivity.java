package com.example.android.catquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText userNameInput;
    public static int score = 0;
    public static String name;
    final static String SCORE_KEY = "score_key";
    final static String NAME_KEY = "name_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameInput = findViewById(R.id.user_name);
        name = userNameInput.getText().toString().toUpperCase();


    // Creates an onClick Listener on the start button, which opens an intent to the next quiz screen
    Button startButton = (Button) findViewById(R.id.start_button);
    startButton.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent question1Intent = new Intent(MainActivity.this, Question1Activity.class);
            Bundle bundle = new Bundle();
            bundle.putString(NAME_KEY, name);
            bundle.putInt(SCORE_KEY, score);
            question1Intent.putExtras(bundle);
            startActivity(question1Intent);
        }
    });
}

}