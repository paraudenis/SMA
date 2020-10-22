package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView ListRV;
    private ListAdapter LAdapter;
    private List<ListModel> list;
    private EditText ET_LastName;
    private EditText ET_FirstName;
    private EditText ET_Age;
    private Button addButton;
    private Button removeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        initializeList();
        setOnClickListeners();
        setRecyclerView();

    }

    private void setOnClickListeners() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addButtonFunction();
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeButtonFunction();
            }
        });
    }

    private void addButtonFunction() {
        String lastName = ET_LastName.getText().toString();
        String firstName = ET_FirstName.getText().toString();
        if(lastName.isEmpty() || firstName.isEmpty() || isNumeric(ET_Age.getText().toString())==false)
        {
            Toast.makeText(this, "Complete the boxes", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            int age = Integer.parseInt(ET_Age.getText().toString());
            list.add(new ListModel(lastName,firstName,age));
            setRecyclerView();
        }
    }

    private void removeButtonFunction() {
        list.remove(0);
        setRecyclerView();
    }

    private void initializeList()
    {
        list = new ArrayList<>();
        list.add(new ListModel("asdf", "ghjk", 20));
        list.add(new ListModel("dqwdqw", "ghfwqfqwfjk", 20));
        list.add(new ListModel("asdfqwdfqwf", "ghqfwfqwfqwjk", 20));
        list.add(new ListModel("cqwcqw", "ghgrergrehjk", 20));
        list.add(new ListModel("ewf", "hrehrehregghjk", 20));
        list.add(new ListModel("asbvredf", "grgeergrehjk", 20));
    }

    private void setRecyclerView()
    {
        LAdapter = new ListAdapter(list);
        ListRV.setLayoutManager(new LinearLayoutManager(this));
        ListRV.setAdapter(LAdapter);
    }

    private void initializeViews()
    {
        ListRV = findViewById(R.id.rv_list);
        ET_LastName = findViewById(R.id.lastName);
        ET_FirstName = findViewById(R.id.firstName);
        ET_Age = findViewById(R.id.age);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}