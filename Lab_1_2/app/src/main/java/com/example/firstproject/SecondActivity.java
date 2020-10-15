package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    private String extraText;
    private TextView mainTextView;
    private EditText mainEditText;
    private Button mainButton;
    private Button firstButton;
    private Button thirdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initializeViews();
        setOnClickListeners();
        Intent intent = getIntent();
        extraText = intent.getStringExtra("extra");
        if(extraText.isEmpty()==false)
        {
            mainTextView.setText(extraText);
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
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToFirstActivity();
            }
        });
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToThirdActivity();
            }
        });

    }

    private void goToFirstActivity() {
        String inputValue = mainEditText.getText().toString();
        if (inputValue.isEmpty())
        {
            Toast.makeText(this, "Introduceti un text pentru a continua", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("extra", inputValue);
            startActivity(intent);
        }
    }

    private void goToThirdActivity() {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
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

    private void initializeViews()
    {
        mainTextView = findViewById(R.id.textbox);
        mainEditText = findViewById(R.id.edittext);
        mainButton = findViewById(R.id.button);
        firstButton = findViewById(R.id.button_first);
        thirdButton = findViewById(R.id.button_third);
    }
}