package com.example.srm_ez2;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;


public class Teachers extends AppCompatActivity implements RecyclerViewInterface{
    RecyclerView recyclerView;
    Adapter_t ad;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachers);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teacher"), Model.class)
                        .build();

        ad = new Adapter_t(options,this);
        recyclerView.setAdapter(ad);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ad.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ad.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem item =menu.findItem(R.id.search);

        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                process_search(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                process_search(s);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    private void process_search(String s) {
        FirebaseRecyclerOptions<Model> options =
                new FirebaseRecyclerOptions.Builder<Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("teacher").orderByChild("Name").startAt(s).endAt(s+"\uf8ff"), Model.class)
                        .build();

        ad = new Adapter_t(options,this);
        ad.startListening();
        recyclerView.setAdapter(ad);
    }

    @Override
    public void onItemClick(String name) {
        Log.d("","Value"+name);
        if("Hema Ma'am".equals(name)){
            Intent t0 = new Intent(this, teacher_0.class);
            startActivity(t0);
        }
        else if("Thilagavathy Ma'am".equals(name)){
            Intent t1 = new Intent(this,teacher1.class);
            startActivity(t1);
        }
        else if("Jeba Sir".equals(name)){
            Intent t2 = new Intent(this,teacher2.class);
            startActivity(t2);
        }
        else if("Pradeep Sir".equals(name)){
            Intent t3 = new Intent(this, teacher3.class);
            startActivity(t3);
        }
        else if("Dipankar Sir".equals(name)){
            Intent t4 = new Intent(this, teacher4.class);
            startActivity(t4);
        }
        else if("Uden Sir".equals(name)){
            Intent t5 = new Intent(this, teacher5.class);
            startActivity(t5);
        }else{
            Toast.makeText(this, "We are working on it!!", Toast.LENGTH_SHORT).show();
        }
    }
}