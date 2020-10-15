package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private TextView mainTextView;
    private EditText mainEditText;
    private Button mainButton;
    private Button secondButton;
    private Button thirdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setOnClickListeners();
    }

    private void changeTextViewText()
    {
        String inputValue = mainEditText.getText().toString();
        if (inputValue.isEmpty())
        {
            return;
        }
        else
        {
            mainTextView.setText((inputValue));
        }
    }

    private void setOnClickListeners()
    {
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTextViewText();
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondActivity();
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdActivity();
            }
        });
    }

    private void goToSecondActivity() {
        String inputValue = mainEditText.getText().toString();
        if (inputValue.isEmpty())
        {
            Toast.makeText(this, "Introduceti un text pentru a continua", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Intent intent = new Intent(this,SecondActivity.class);
            intent.putExtra("extra", inputValue);
            startActivity(intent);
        }
    }

    private void goToThirdActivity() {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }


    private void initializeViews()
    {
        mainTextView = findViewById(R.id.textbox);
        mainEditText = findViewById(R.id.edittext);
        mainButton = findViewById(R.id.button);
        secondButton = findViewById(R.id.button_second);
        thirdButton = findViewById(R.id.button_third);
    }


}