package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class ThirdActivity extends AppCompatActivity {


    private TextView mainTextView;
    private EditText firstEditText;
    private EditText secondEditText;
    private Button mainButton;
    private Button firstButton;
    private Button secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initializeViews();
        setOnClickListeners();
    }

    private void setOnClickListeners()
    {
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextViewText();
            }
        });
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFirstActivity();
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });

    }

    private void goToFirstActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void goToSecondActivity() {
        String inputValue = "";
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("extra", inputValue);
        startActivity(intent);
    }

    private void changeTextViewText()
    {
        Integer firstValue = Integer.parseInt(firstEditText.getText().toString());
        Integer secondValue = Integer.parseInt(secondEditText.getText().toString());
        Integer sum;
        if (firstValue==null||secondValue==null)
        {
            return;
        }
        else
        {
            sum = firstValue + secondValue;
            mainTextView.setText((sum.toString()));
        }
    }

    private void initializeViews()
    {
        mainTextView = findViewById(R.id.textbox);
        firstEditText = findViewById(R.id.firstedittext);
        secondEditText = findViewById(R.id.secondedittext);
        mainButton = findViewById(R.id.button);
        firstButton = findViewById(R.id.button_first);
        secondButton = findViewById(R.id.button_second);
    }


}