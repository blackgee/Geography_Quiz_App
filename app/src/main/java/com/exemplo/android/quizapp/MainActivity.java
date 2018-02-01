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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* This method saves the user's name, defines the right answers and checks the answers */
        private int calculateScore() {

        EditText fieldName = (EditText) findViewById(R.id.user_name);
        userName = fieldName.getText().toString();

        RadioButton canberraRadioButton = (RadioButton) findViewById(R.id.canberra_radiobutton);
        boolean isCanberra = canberraRadioButton.isChecked();

        RadioButton saoPauloRadioButton = (RadioButton) findViewById(R.id.sao_paulo_radiobutton);
        boolean isSaoPaulo = saoPauloRadioButton.isChecked();

        RadioButton africaRadioButton = (RadioButton) findViewById(R.id.africa_radiobutton);
        boolean isAfrica = africaRadioButton.isChecked();

        EditText riverName = (EditText) findViewById(R.id.river_name);
        String isAmazon = riverName.getText().toString();

        RadioButton indiaRadioButton = (RadioButton) findViewById(R.id.india_radiobutton);
        boolean isIndia = indiaRadioButton.isChecked();

        RadioButton volgaRadioButton = (RadioButton) findViewById(R.id.volga_radiobutton);
        boolean isVolga = volgaRadioButton.isChecked();

        CheckBox spanishCheckBox = (CheckBox) findViewById(R.id.spanish_checkbox);
        boolean isSpanish = spanishCheckBox.isChecked();

        CheckBox englishCheckBox = (CheckBox) findViewById(R.id.english_checkbox);
        boolean isEnglish = englishCheckBox.isChecked();

        CheckBox hindiUrduCheckBox = (CheckBox) findViewById(R.id.hindi_urdu_checkbox);
        boolean isHindiUrdu = hindiUrduCheckBox.isChecked();

        CheckBox mandarinCheckBox = (CheckBox) findViewById(R.id.mandarin_checkbox);
        boolean isMandarin = mandarinCheckBox.isChecked();

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
                    "Congratulations " + userName + "\nYou did great! " + "\nScore: " + score + "/8", Toast.LENGTH_LONG).show();
        }

        if (score <= 5) {
            Toast.makeText(MainActivity.this,
                    "You can do better " + userName + "\nTry again " + "\nScore: " + score + "/8", Toast.LENGTH_LONG).show();
        }

    }

    // reset the quiz

    public void resetScore(View v) {

        ((EditText) findViewById(R.id.user_name)).setText("");

        ((EditText) findViewById(R.id.river_name)).setText("");

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.RGroup1);
        radioGroup1.clearCheck();

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.RGroup2);
        radioGroup2.clearCheck();

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.RGroup3);
        radioGroup3.clearCheck();

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.RGroup4);
        radioGroup4.clearCheck();

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.RGroup5);
        radioGroup5.clearCheck();

        CheckBox checkBox = (CheckBox) findViewById(R.id.spanish_checkbox);
        checkBox.setChecked(false);

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.english_checkbox);
        checkBox1.setChecked(false);

        CheckBox checkBox2 = (CheckBox) findViewById(R.id.mandarin_checkbox);
        checkBox2.setChecked(false);

        CheckBox checkBox3 = (CheckBox) findViewById(R.id.hindi_urdu_checkbox);
        checkBox3.setChecked(false);

    }

}
