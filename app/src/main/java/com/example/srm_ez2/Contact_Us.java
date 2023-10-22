package com.example.srm_ez2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Contact_Us extends AppCompatActivity {

    EditText name,phone,prob;
    FirebaseFirestore firebaseFirestore;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Button submit;
        submit=findViewById(R.id.submit);
        name=findViewById(R.id.editTextText);
        phone=findViewById(R.id.editTextPhone);
        prob=findViewById(R.id.problem);
        firebaseFirestore = FirebaseFirestore.getInstance();


        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                Intent back = new Intent(Contact_Us.this, MainActivity.class);
                String Uname = name.getText().toString();
                String mob = phone.getText().toString();
                String pr = prob.getText().toString();
                if(Uname.isEmpty() || mob.isEmpty()){
                    Toast.makeText(Contact_Us.this, "Any one field is missing.", Toast.LENGTH_SHORT).show();
                }
                else{
                    DocumentReference dr= firebaseFirestore.collection("EZ").document();
                    Map<String, Object> Users = new HashMap<>();
                    Users.put("Name: ",Uname);
                    Users.put("Phone Number",mob);
                    Users.put("Problem: ",pr);
                    dr.set(Users).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Contact_Us.this, "Will reach to You shortly.", Toast.LENGTH_SHORT).show();
                            startActivity(back);
                            finish();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Contact_Us.this, "Could not store data!!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}