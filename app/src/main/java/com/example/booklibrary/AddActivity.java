package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText Title, Author, Pages;
    Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Title = findViewById(R.id.title_input);
        Author = findViewById(R.id.author_input);
        Pages = findViewById(R.id.number_of_pages);
        AddButton = findViewById(R.id.add_button);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.AddBook(Title.getText().toString().trim() , Author.getText().toString().trim() , Integer.parseInt(Pages.getText().toString().trim()));
                startActivity(new Intent(AddActivity.this, MainActivity.class));
                finish();
            }
        });
    }
}