package com.example.temalab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity2 extends AppCompatActivity {

    private String extraText;
    private TextView textBox;
    private Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initializeViews();
        setOnClickListeners();
        Intent intent = getIntent();
        extraText =intent.getStringExtra("extra");
        if(extraText.isEmpty()==false)
        {
            setTextBoxFunction(extraText);
        }
        else
        {
            goBackFunction();
        }

    }

    private void initializeViews()
    {
        textBox = findViewById(R.id.textbox);
        goBackButton = findViewById(R.id.goBackButton);
    }

    private void setOnClickListeners() {
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackFunction();
            }
        });
    }

    private void goBackFunction()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void setTextBoxFunction(String s)
    {
        if (s.isEmpty())
        {
            return;
        }
        else
        {
            textBox.setText((s));
        }
    }
}