package com.example.temalab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private LinearLayout dialog;
    private Button dialogButton;
    private EditText mainEditText;
    private Button okButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        setOnClickListeners();
    }

    private void initializeViews()
    {
        dialog = findViewById(R.id.dialog);
        mainEditText = findViewById(R.id.editText);
        dialogButton = findViewById(R.id.showDialogButton);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
    }

    private void setOnClickListeners()
    {
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogFunction();
            }
        });
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okButtonFunction();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelButtonFunction();
            }
        });
    }

    private void showDialogFunction()
    {
        dialog.setVisibility(View.VISIBLE);
    }

    private void hideDialogFunction()
    {
        dialog.setVisibility(View.INVISIBLE);
    }

    private void okButtonFunction()
    {
        String inputValue = mainEditText.getText().toString();
        if (inputValue.isEmpty())
        {
            Toast.makeText(this, "Introduceti un text pentru a continua", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            Intent intent = new Intent(this,MainActivity2.class);
            intent.putExtra("extra", inputValue);
            startActivity(intent);
            hideDialogFunction();
        }
    }

    private void cancelButtonFunction()
    {
        Toast.makeText(this, "Se ascunde dialogul", Toast.LENGTH_SHORT).show();
        hideDialogFunction();
    }
}