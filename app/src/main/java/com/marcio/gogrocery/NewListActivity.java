package com.marcio.gogrocery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class NewListActivity extends AppCompatActivity {

    // Variables
    TextInputLayout textInputLayout;
    EditText userInput;
    LinearLayout outputLayout;
    String textInput;

    // Global Arrays
    ArrayList<String> list = new ArrayList<>();
    ArrayList<String> finalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list);

        // Set Action bar Title
        this.setTitle("New List");

        // Views
        textInputLayout = findViewById(R.id.textInputLayout);
        userInput = findViewById(R.id.userInput);
        outputLayout = findViewById(R.id.textLayout);
    }

    // Add Items
    public void addItemBtn(View v) {
        textInput = textInputLayout.getEditText().getText().toString();

        if(textInput.isEmpty()) {
            // do nothing
        }
        else {
            userInput.getText().clear();
            list.add(textInput);

            // Create Views
            TextView item = new TextView(this);
            AlertDialog dialog = new AlertDialog.Builder(this).create();
            EditText editText = new EditText(this);

            // Create Dialogs
            dialog.setTitle("Edit item");
            dialog.setView(editText);
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Save Item",
                    new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    item.setText(editText.getText().toString());
                }
            });

            item.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    editText.setText(item.getText().toString());
                    dialog.show();
                    return false;
                }
            });

            item.setTextSize(24);
            for (int i = 0; i < list.size(); i++) {
                String itemList = list.get(i);
                item.setText(itemList);
            }
            outputLayout.addView(item);
        }
    }

    // Check List
    public void checkListBtn(View v) {
        if(outputLayout.getChildCount() <=0) {
            Toast.makeText(this, "Your list is empty! Please add items.", Toast.LENGTH_SHORT).show();
        }
        else {
            for (int i = 0; i < outputLayout.getChildCount(); i++) {
                View element = outputLayout.getChildAt(i);
                if (element instanceof TextView) {
                    String newList = ((TextView) element).getText().toString();
                    finalList.add(newList);
                }
            }
            Intent checkList = new Intent(NewListActivity.this, CheckListActivity.class);
            checkList.putExtra("groceryList", finalList);
            startActivity(checkList);
        }
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