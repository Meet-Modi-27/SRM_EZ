package com.example.srm_ez2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
            To Get Back Button.
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }*/


        if (getSupportActionBar() != null) {
            // Create a SpannableString with the desired title text
            SpannableString spannableString = new SpannableString("SRM EZ");

            // Change the text color to your desired color
            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            // Set the styled SpannableString as the title
            getSupportActionBar().setTitle(spannableString);
        }
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.opt_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId==R.id.opt1){
            //Add intent here.
            Intent home = new Intent(this, Basic_Info.class);
            startActivity(home);
        }
        else if(itemId==R.id.opt2){
            Intent home = new Intent(this, Teachers.class);
            startActivity(home);
        }
        else if(itemId==R.id.opt3){
            Intent home = new Intent(this, Clubs.class);
            startActivity(home);
        }
        else if(itemId==R.id.opt4){
            Intent home = new Intent(this, Placements.class);
            startActivity(home);
        }
        else if(itemId==R.id.opt5){
            Intent home = new Intent(this, Contact_Us.class);
            startActivity(home);
            finish();
        }
        else{

        }

        return super.onOptionsItemSelected(item);
    }
}