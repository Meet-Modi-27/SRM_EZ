package com.example.srm_ez2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Clubs extends AppCompatActivity implements RecyclerViewInterface {
    RecyclerView recyclerView;
    Adapter_c ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);


        recyclerView = findViewById(R.id.c_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Club_Model> options =
                new FirebaseRecyclerOptions.Builder<Club_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Clubs"), Club_Model.class)
                        .build();

        ac = new Adapter_c(options,this);
        recyclerView.setAdapter(ac);
    }
    @Override
    protected void onStart() {
        super.onStart();
        ac.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        ac.stopListening();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                txtSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                txtSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str) {
        FirebaseRecyclerOptions<Club_Model> options =
                new FirebaseRecyclerOptions.Builder<Club_Model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Clubs").orderByChild("C_name").startAt(str).endAt(str + "~"), Club_Model.class)
                        .build();

        ac = new Adapter_c(options,this);
        ac.startListening();
        recyclerView.setAdapter(ac);
    }

    @Override
    public void onItemClick(String name) {
        if("Alexa Developers".equals(name)){
            Intent c0 = new Intent(this, club_0.class);
            startActivity(c0);
        }
        else if("GitHub Community".equals(name)){
            Intent c1 = new Intent(this,club1.class);
            startActivity(c1);
        }
        else if("SRM MUN Society".equals(name)){
            Intent c2 = new Intent(this,club2.class);
            startActivity(c2);
        }
        else if("Liftoff".equals(name)){
            Intent c3 = new Intent(this, club3.class);
            startActivity(c3);
        }
        else if("GeeksforGeeks".equals(name)){
            Intent c4 = new Intent(this, club4.class);
            startActivity(c4);
        }
        else if("SRM Team Robocon".equals(name)){
            Intent c5 = new Intent(this, club5.class);
            startActivity(c5);
        }
        else if("SRM Next Tech Lab".equals(name)){
            Intent c6 = new Intent(this, club6.class);
            startActivity(c6);
        }
        else if("RUDRA MARS ROVER".equals(name)){
            Intent c7 = new Intent(this, club7.class);
            startActivity(c7);
        }else{
            Toast.makeText(this, "We are working on it!!", Toast.LENGTH_SHORT).show();
        }
    }
}