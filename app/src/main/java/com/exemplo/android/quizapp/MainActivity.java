package com.exemplo.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    String userName;
    String isAmazon;
    EditText et1;
    EditText et2;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;
    RadioButton rb4;
    RadioButton rb5;
    CheckBox cb1;
    CheckBox cb2;
    CheckBox cb3;
    CheckBox cb4;
    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioGroup rg4;
    RadioGroup rg5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.user_name);
        et2 = (EditText) findViewById(R.id.answer_river);
        rb1 = (RadioButton) findViewById(R.id.answer_1);
        rb2 = (RadioButton) findViewById(R.id.answer_2);
        rb3 = (RadioButton) findViewById(R.id.answer_3);
        rb4 = (RadioButton) findViewById(R.id.answer_4);
        rb5 = (RadioButton) findViewById(R.id.answer_5);
        cb1 = (CheckBox) findViewById(R.id.answer_7a);
        cb2 = (CheckBox) findViewById(R.id.answer_7b);
        cb3 = (CheckBox) findViewById(R.id.answer_7c);
        cb4 = (CheckBox) findViewById(R.id.answer_7d);
        rg1 = (RadioGroup) findViewById(R.id.rgroup_1);
        rg2 = (RadioGroup) findViewById(R.id.rgroup_2);
        rg3 = (RadioGroup) findViewById(R.id.rgroup_3);
        rg4 = (RadioGroup) findViewById(R.id.rgroup_4);
        rg5 = (RadioGroup) findViewById(R.id.rgroup_5);
        
    }

    /* This method saves the user's name, defines the right answers and checks the answers */
    private int calculateScore() {


        userName = et1.getText().toString();

        boolean isCanberra = rb1.isChecked();

        boolean isSaoPaulo = rb2.isChecked();

        isAmazon = et2.getText().toString();

        boolean isVolga = rb3.isChecked();

        boolean isAfrica = rb4.isChecked();

        boolean isIndia = rb5.isChecked();

        boolean isSpanish = cb1.isChecked();

        boolean isEnglish = cb2.isChecked();

        boolean isMandarin = cb3.isChecked();

        boolean isHindiUrdu = cb4.isChecked();


        int score = 0;

        if (isCanberra) {
            score = score + 1;
        }

        if (isSaoPaulo) {
            score = score + 1;
        }

        //ignores caps in the answer about the longest river in the world

        if ("Amazon".equalsIgnoreCase(isAmazon)) {
            score = score + 1;
        }

        if (isAfrica) {
            score = score + 1;
        }

        if (isIndia) {
            score = score + 1;
        }

        if (isVolga) {
            score = score + 1;
        }

        if (isSpanish) {
            score = score + 1;
        }

        if (isMandarin) {
            score = score + 1;
        }

        if (isEnglish) {
            score = score - 1;
        }

        if (isHindiUrdu) {
            score = score - 1;
        }

        return score;
    }

    /**
     * This method calculates the score of the quiz.
     */
    public void showResult(View view) {
        score = calculateScore();
        display(score);
    }

    /**
     * creates the method to display the toast message with the results
     */

    private void display(int finalResult) {

        if (score >= 6) {
            Toast.makeText(MainActivity.this,
                    getString(R.string.congratulations) + userName + "\n" + getString(R.string.did_great) + "\n" + getString(R.string.score_word) + score + getString(R.string.number_8), Toast.LENGTH_LONG).show();
        }

        if (score <= 5) {
            Toast.makeText(MainActivity.this,
                    getString(R.string.you_can_do_better) + userName + "\n" + getString(R.string.try_again) + "\n" + getString(R.string.score_word) + score + getString(R.string.number_8), Toast.LENGTH_LONG).show();
        }

    }

    // reset the quiz

    public void resetScore(View v) {

        (et1).setText("");

        (et2).setText("");

        rg1.clearCheck();

        rg2.clearCheck();

        rg3.clearCheck();

        rg4.clearCheck();

        rg5.clearCheck();

        cb1.setChecked(false);

        cb2.setChecked(false);

        cb3.setChecked(false);

        cb4.setChecked(false);

    }

}
