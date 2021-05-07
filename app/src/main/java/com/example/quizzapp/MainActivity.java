package com.example.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    //Bind the RadioButtons using butterknife
    @BindView(R.id.radio_Nauru) RadioButton answerOneRadioButton;

    @BindView(R.id.peter_otoole_radio) RadioButton answerTwoRadioButton;

    @BindView(R.id.seychelles_radio) RadioButton answerThreeRadioButton;

    @BindView(R.id.elvis_radio) RadioButton answerFourRadioButton;

    @BindView(R.id.north_korea_radio) RadioButton answerFiveRadioButton;

    @BindView(R.id.microsoft_radio) RadioButton answerSixRadioButton;

    @BindView(R.id.theodore_roosevelt_radio) RadioButton answerSevenRadioButton;


    /**
     * On submit button tap this method goes through all the correct answers, checks if they're selected or not.
     * It calculates the total score value by increasing it one by one.
     * The final score is shown as a toast
     * @param view - Submit button
     */
    public void checkAnswers(View view) {
        //Get the name
        EditText userNameEditText = (EditText) findViewById(R.id.username);
        String userName = userNameEditText.getText().toString();

        updateScore(answerOneRadioButton.isChecked());

        updateScore(answerTwoRadioButton.isChecked());

        updateScore(answerThreeRadioButton.isChecked());

        updateScore(answerFourRadioButton.isChecked());

        updateScore(answerFiveRadioButton.isChecked());

        updateScore(answerSixRadioButton.isChecked());

        updateScore(answerSevenRadioButton.isChecked());

        CheckBox answerEightCheckBoxOne = (CheckBox) findViewById(R.id.buda_CheckBox);
        CheckBox answerEightCheckBoxTwo = (CheckBox) findViewById(R.id.pest_CheckBox);
        CheckBox answerEightCheckBoxThree = (CheckBox) findViewById(R.id.budapest_CheckBox);
        CheckBox answerEightCheckBoxFour = (CheckBox) findViewById(R.id.danube_CheckBox);

        updateScore(answerEightCheckBoxOne.isChecked() && answerEightCheckBoxTwo.isChecked() && answerEightCheckBoxThree.isChecked() && answerEightCheckBoxFour.isChecked());

        CheckBox answerNineCheckBoxOne = (CheckBox) findViewById(R.id.ironman_CheckBox);
        CheckBox answerNineCheckBoxTwo = (CheckBox) findViewById(R.id.batman_CheckBox);
        CheckBox answerNineCheckBoxThree = (CheckBox) findViewById(R.id.spiderman_CheckBox);
        CheckBox answerNineCheckBoxFour = (CheckBox) findViewById(R.id.antman_CheckBox);

        updateScore((answerNineCheckBoxOne.isChecked() && answerNineCheckBoxThree.isChecked() && (!answerNineCheckBoxTwo.isChecked()) && (!answerNineCheckBoxFour.isChecked())));

        Log.v("MainACtivity", "Question 9: " + answerNineCheckBoxOne.isChecked() + " "
                + answerNineCheckBoxTwo.isChecked() + " " + answerNineCheckBoxThree.isChecked() + " " + answerNineCheckBoxFour.isChecked() + " " +
                (answerNineCheckBoxOne.isChecked() && answerNineCheckBoxThree.isChecked()
                        && (!answerNineCheckBoxTwo.isChecked()) && (!answerNineCheckBoxFour.isChecked())));

        String message = new String();

        if (userName.isEmpty()) {
            message = getString(R.string.result_toast) + " " + String.valueOf(score);
        } else {
            message = userName + ", " + getString(R.string.result_toast) + " " + String.valueOf(score);
        }

        Toast totalScore = Toast.makeText(this, message, Toast.LENGTH_LONG);
        totalScore.show();

        score = 0;
    }

    /**
     * if the given boolean is true then increase score by one
     * @param correctAnswer - boolean indicating if the correct answer is selected or not, derived from checking the isChecked state
     */
    public void updateScore(boolean correctAnswer) {
        if (correctAnswer) {
            score++;
        }
    }

}
