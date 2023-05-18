package com.example.afinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity2 extends AppCompatActivity {
    int alphabetCounter = 0;
    int score=300;
    String word;
    int y=3;
    int hs=0;
    int h=3;
    int highScore=0;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        GridLayout gridLayout = findViewById(R.id.gridLayout2);
        Button hint = findViewById(R.id.clue);
        Intent intent = getIntent();
        word = intent.getStringExtra(MainActivity.extra);
        String clue = intent.getStringExtra(MainActivity.extra2);
        // TextView q=findViewById(R.id.textView3);
        Button check = findViewById(R.id.check);
        Button reset = findViewById(R.id.reset);
        TextView t = findViewById(R.id.textView);
        String k="";
        String w= updateLifeTextView(k,y);
        hint.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onbackpressed();
            }

            private void onbackpressed() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
                // Set the message show for the Alert time
                builder.setMessage(clue);
                // Set Alert Title
                builder.setTitle("clue");
                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);
                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Ok", (dialog, which) -> {
                    // When the user click yes button then app will close
                });
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();
            }
        });
        ArrayList<Character> array = new ArrayList<>();
        List<Character> alphabetList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetList.add(c);
        }
        if (word != null) {
            for (int b = 0; b < word.length(); b++) {
                array.add(word.charAt(b));
            }
        }
        assert word != null;
        if (word.length() > 16) {
            Toast.makeText(this, "please enter a word with 16 or less letters", Toast.LENGTH_SHORT).show();
            finish();
        }
        List<Character> alphas = new ArrayList<>(alphabetList);
        alphas.removeAll(array);
        Collections.shuffle(alphas);
        Collections.shuffle(array);
        Collections.shuffle(array);
        // Shuffle the alphabet list
      //  shuffler(array,alphas);

//        String s = "";
//        for (int k = 0; k < array.size(); k++)
//        {
//            s += array.get(k);
//            //    data[k] += array.get(k);
//        }
//        for(int x=0;x<word.length();x++) {
//            for (int w = 0; w < alphabetList.size(); w++) {
//                if (!(String.valueOf(alphabetList.get(w)).equalsIgnoreCase(String.valueOf(array.get(x))))) {
//                    alphas.add(alphabetList.get(w));
//                    w++;
//                }
//            }
//        }
        // String data[] =new String[0];
//        Collections.shuffle(array);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View child = gridLayout.getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                if (i < word.length()) {
                    button.setText(String.valueOf(array.get(i)));
                } else {
                    if (i - word.length() < alphas.size()) {
                        button.setText(String.valueOf(alphas.get(i - word.length())));
                        //                    if(!(String.valueOf(alphabetList.get(alphabetCounter)).equalsIgnoreCase(String.valueOf(array.get(i))))) {
                        //                        button.setText(String.valueOf(alphabetList.get(alphabetCounter)));
                        //  alphabetCounter++;
                        //                    }
                    }
                }
//                String m = "__ ";
//                for (int y = 1; y <= word.length(); y++) {
//                    t.append(m);
//                }

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle button click event here
                        String buttonText = button.getText().toString();
                        t.append(buttonText);
                    }
                                        });

                            }
                        }

@SuppressLint("CutPasteId") TextView r = findViewById(R.id.chances);
        r.setText(w);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
// Get the SharedPreferences editor
        SharedPreferences.Editor editor = sharedPreferences.edit();

       // r.setText("you have 3 chances to guess the correct word");
        // AtomicInteger y= new AtomicInteger(3);
        // t.setText(s);
        // EditText e =findViewById(R.id.editTextText);

        check.setOnClickListener(v -> {
            String g = t.getText().toString();
            if (g.length() < word.length()) {
                Toast.makeText(this, "please enter a " + word.length() + " lettered word", Toast.LENGTH_SHORT).show();
                //  q.setText("please enter a " + word.length() + "lettered word");
                //   y.getAndDecrement();
                t.setText(null);
                // r.setText("REMAINING CHANCES: "+ y);
            } else {
                if (t.getText().toString().equalsIgnoreCase(word)) {
                    hs = h * 100;
                    if (h == 3) {
                        Toast.makeText(this, " your score is " + score, Toast.LENGTH_SHORT).show();
                        highScore= hs; // Replace with your actual high score value
                        editor.putInt("highScore", highScore);
                        editor.apply();
                        finish();
                    } else if (h == 2) {
                        Toast.makeText(this, " your score is 200", Toast.LENGTH_SHORT).show();
                         highScore = hs; // Replace with your actual high score value
                        editor.putInt("highScore", highScore);
                        editor.apply();
                        finish();
                        //   q.setText("your score is 200");
                    } else if (h == 1) {
                        Toast.makeText(this, " your score is 100", Toast.LENGTH_SHORT).show();
                         highScore = hs; // Replace with your actual high score value
                        editor.putInt("highScore", highScore);
                        editor.apply();
                        finish();
                        //   q.setText("your score is 100");
                    }
                    //  q.setText("awesome!! you got it");
                } else {
                    //shuffler(array,alphas);
                    Toast.makeText(this, "oops! wrong. Try Again", Toast.LENGTH_SHORT).show();
                    shuffleGrid();
                    //enableAllButtons();
                    String b=handleWrongOption();
                    r.setText(b);
                    t.setText(null);
                    // q.setText("oops! wrong. Try Again");
                     h--;
                    // r.setText("REMAINING CHANCES: "+ y);
                    if (h == 0) {
                        Toast.makeText(this, "sorry! you ran out of chances", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            }
        });
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("");
            }
        });
    }

//    private void enableAllButtons() {
//        for (int i = 0; i < gridLayout.getChildCount(); i++) {
//            View child = gridLayout.getChildAt(i);
//            if (child instanceof Button) {
//                Button button = (Button) child;
//                button.setEnabled(true);
//    }

    private void shuffleGrid() {
        GridLayout gridLayout = findViewById(R.id.gridLayout2);
        List<Character> alphaList = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphaList.add(c);
        }
        ArrayList<Character> array = new ArrayList<>();
        if (word != null) {
            for (int b = 0; b < word.length(); b++) {
                //array = new ArrayList<>();
                //assert false;
                array.add(word.charAt(b));
            }
        }
        List<Character> alphas = new ArrayList<>(alphaList);
        alphas.removeAll(array);
        Collections.shuffle(array);
        Collections.shuffle(alphas);

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View child = gridLayout.getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                if (i < word.length()) {
                    button.setText(String.valueOf(array.get(i)));
                } else {
                    if (i - word.length() < alphas.size()) {
                        button.setText(String.valueOf(alphas.get(i - word.length())));
                        //                    if(!(String.valueOf(alphabetList.get(alphabetCounter)).equalsIgnoreCase(String.valueOf(array.get(i))))) {
                        //                        button.setText(String.valueOf(alphabetList.get(alphabetCounter)));
                        //  alphabetCounter++;
                        //                    }
                    }
                }
//                String m = "__ ";
//                for (int y = 1; y <= word.length(); y++) {
//                    t.append(m);
//                }
                TextView t=findViewById(R.id.textView);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Handle button click event here
                        String buttonText = button.getText().toString();
                        t.append(buttonText);
                        // String p = (String) t.getText();
//                        String newString = p.replace("__ ", buttonText);
                    }
                });
            }
            }
        }
    private String updateLifeTextView(String l,int o) {
        String heart = "\u2665"; // Unicode for heart symbol
        String lives = "";
        for (int i = 0; i < o; i++) {
            lives += heart + " ";
        }
        return lives;
    }
    private String handleWrongOption() {
        y--;
        String s="";// Reduce the life count by 1
        return updateLifeTextView(s,y);
    }
    }




