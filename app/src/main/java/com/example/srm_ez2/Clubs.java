package com.example.srm_ez2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SearchView;

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
    public void onItemClick(int position) {
        Log.d("Demo", "Position: "+ position);

    }
}