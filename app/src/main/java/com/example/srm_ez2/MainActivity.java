package com.example.srm_ez2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    LinearLayout b1,b2,b3,b4;
    RecyclerView upcoming_recycler,facts_recycler;
    Toolbar toolbar;
    Adapter_Upcoming ad;
    Adapter_facts ad1;
    @SuppressLint("MissingInflatedId")
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
            SpannableString spannableString = new SpannableString("");

            // Change the text color to your desired color
            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

            // Set the styled SpannableString as the title
            getSupportActionBar().setTitle(spannableString);
        }

        //Recycler Views

        upcoming_recycler = findViewById(R.id.upcoming_recycle);
        upcoming_recycler();
        FirebaseRecyclerOptions<upcoming_model> options =
                new FirebaseRecyclerOptions.Builder<upcoming_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Upcoming"), upcoming_model.class)
                        .build();

        ad = new Adapter_Upcoming(options);
        upcoming_recycler.setAdapter(ad);

        facts_recycler = findViewById(R.id.home_facts_recycler);
        facts_recycler();
        FirebaseRecyclerOptions<facts_model> option=
                new FirebaseRecyclerOptions.Builder<facts_model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("facts"), facts_model.class)
                        .build();

        ad1 = new Adapter_facts(option);
        facts_recycler.setAdapter(ad1);



        //Clickable Layout.

        b1 =(LinearLayout) findViewById(R.id.teacher);
        b2=(LinearLayout) findViewById(R.id.clubs);
        b3=(LinearLayout) findViewById(R.id.placements);
        b4= (LinearLayout) findViewById(R.id.contacts);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivity.this, Teachers.class);
                startActivity(home);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivity.this, Clubs.class);
                startActivity(home);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivity.this, Placements.class);
                startActivity(home);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(MainActivity.this, Contact_Us.class);
                startActivity(home);
            }
        });
    }

    private void facts_recycler() {
        facts_recycler.setHasFixedSize(true);
        facts_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    protected void onStart() {
        super.onStart();
        ad.startListening();
        ad1.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ad.stopListening();
        ad1.stopListening();
    }

    private void upcoming_recycler() {

        upcoming_recycler.setHasFixedSize(true);
        upcoming_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }
}