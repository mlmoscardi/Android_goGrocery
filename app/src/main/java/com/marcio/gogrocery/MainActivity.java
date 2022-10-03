package com.marcio.gogrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // Variables
    ImageView newListButton;
    ImageView savedListsButton;
    ImageView aboutPageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Action bar Title
        this.setTitle("Home");

        // Views
        newListButton = findViewById(R.id.newListButton);
        savedListsButton = findViewById(R.id.checkListButton);
        aboutPageButton = findViewById(R.id.aboutPageButton);
    }

    // Buttons Functions
    public void newListBtn(View v) {
        Intent newList = new Intent(this, NewListActivity.class);
        startActivity(newList);
    }
    public void savedListsBtn(View v){
        Intent savedLists = new Intent(this, CheckListActivity.class);
        startActivity(savedLists);
    }
    public void aboutPageBtn(View v){
        Intent aboutPage = new Intent(this, AboutPageActivity.class);
        startActivity(aboutPage);
    }
}