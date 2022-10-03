package com.marcio.gogrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        // Set Action bar Title
        this.setTitle("About Page");
    }

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