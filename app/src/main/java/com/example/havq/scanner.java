package com.example.havq;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class scanner extends AppCompatActivity {
FirebaseFirestore firestore;

    Button qrBtn;
    @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        firestore=FirebaseFirestore.getInstance();


        qrBtn=findViewById(R.id.qrBtn);
        Map<String,Object> user = new HashMap<>();
        user.put("firstName","Tushar");
        user.put("lastName","Malviya");
        user.put("description","hvyCoder");

        Task<DocumentReference> documentReferenceTask = firestore.collection("users").add(user).addOnSuccessListener(documentReference -> Toast.makeText(scanner.this, "Success", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(scanner.this, "Failure", Toast.LENGTH_SHORT).show());
    }
}