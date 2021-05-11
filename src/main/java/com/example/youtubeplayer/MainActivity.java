package com.example.youtubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText url;
    Button button;
    String input, final_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = findViewById(R.id.url);
        button = findViewById(R.id.button);

    }


    public void playVid(View v)
    {
        input = url.getText().toString();
        final_input = input.substring(17);
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("input",final_input);
        startActivity(intent);

    }
}
