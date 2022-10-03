package com.marcio.gogrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CheckListActivity extends AppCompatActivity {
    // Variables
    LinearLayout groceryLayout;
    CheckBox chkBoxItem;
    String itemList;
    ArrayList<String> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);

        // Set Action bar Title
        this.setTitle("Check List");

        // Views
        groceryLayout = findViewById(R.id.textLayout2);

        // Get Intent
        Intent intent = getIntent();
        ArrayList<String> checkList = intent.getStringArrayListExtra("groceryList");

        if(checkList != null) {
            PrefConfig.writePref(getApplicationContext(), checkList);
        }
        else {
            taskList = PrefConfig.readListFromPref(this);
        }

        if(checkList != null) {
            for (int i = 0; i < checkList.size(); i++) {
                chkBoxItem = new CheckBox(this);
                itemList = checkList.get(i);
                chkBoxItem.setTextSize(24);
                chkBoxItem.setText(itemList);
                groceryLayout.addView(chkBoxItem);
            }
        }

        if(taskList != null) {
            for (int i = 0; i < taskList.size(); i++) {
                chkBoxItem = new CheckBox(this);
                itemList = taskList.get(i);
                chkBoxItem.setTextSize(24);
                chkBoxItem.setText(itemList);
                groceryLayout.addView(chkBoxItem);
            }
        }

    } // onCreate

    // Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    // Options Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_page: {
                Intent homePage = new Intent(this, MainActivity.class);
                startActivity(homePage);
                return true;
            }
            case R.id.new_list: {
                Intent newList = new Intent(this, NewListActivity.class);
                startActivity(newList);
                return true;
            }
            case R.id.check_list: {
                Intent checkList = new Intent(this, CheckListActivity.class);
                startActivity(checkList);
                return true;
            }
            case R.id.about_page: {
                Intent aboutPage = new Intent(this, AboutPageActivity.class);
                startActivity(aboutPage);
                return true;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }
}