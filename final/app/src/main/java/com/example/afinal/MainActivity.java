package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText e1;
    public static final String extra="com.example.final.Extra.e1";
    public static final String extra2="com.example.final.Extra.e2";
    private EditText e2;
    private Button start;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @SuppressLint("SetTextI18n")
    public void openact(View view){
        Intent intent = new Intent(this, MainActivity2.class);
        e1=findViewById(R.id.tet);
        e2=findViewById(R.id.edit);
        start=findViewById(R.id.button);
        String word =e1.getText().toString();
        String hint=e2.getText().toString();
        intent.putExtra(extra,word);
        intent.putExtra(extra2,hint);
        startActivity(intent);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
// Retrieve the high score, defaulting to 0 if not found
        int highScore = sharedPreferences.getInt("highScore", 0);
        TextView f=findViewById(R.id.textView3);
        f.setText("High Score " + highScore);
    }

}
