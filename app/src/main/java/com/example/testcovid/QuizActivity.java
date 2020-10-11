package com.example.testcovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


    }

    //action when submit button is clicked
    public void submitQuiz(View view) {
        if (answerValid()) {
            if (suspicious()) {
                Intent toHosp = new Intent(getBaseContext(), HospActivity.class);
                startActivity(toHosp);
            } else {
                Intent toSafe = new Intent(getBaseContext(), SafeActivity.class);
                startActivity(toSafe);
            }

        } else {
            //Display error message
            Toast.makeText(getApplicationContext(), "Please check all the questions", Toast.LENGTH_LONG).show();
        }
    }

    //check input of radio button and decide result
    private boolean suspicious() {
        RadioButton q1y = findViewById(R.id.q1y);
        RadioButton q2y = findViewById(R.id.q2y);
        RadioButton q3y = findViewById(R.id.q3y);

        if (q1y.isChecked() && q2y.isChecked() && q3y.isChecked()) {
            return true;
        } else {
            return false;
        }
    }

    //checks if all radio button is selected
    private boolean answerValid() {
        RadioGroup rg1 = findViewById(R.id.radioGroup1);
        RadioGroup rg2 = findViewById(R.id.radioGroup2);
        RadioGroup rg3 = findViewById(R.id.radioGroup3);

        if (rg1.getCheckedRadioButtonId() == -1 || rg2.getCheckedRadioButtonId() == -1 || rg3.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }
}