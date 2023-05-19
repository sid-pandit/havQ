package com.example.havq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
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
        Intent saveThe;
        saveThe=new Intent(scanner.this,MainActivity3.class);

        qrBtn=findViewById(R.id.qrBtn);

        qrBtn.setOnClickListener(view -> startActivity(saveThe));
        Map<String,Object> user = new HashMap<>();
        user.put("firstName","Tushar");
        user.put("lastName","Malviya");
        user.put("description","hvyCoder");

        Task<DocumentReference> documentReferenceTask = firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(scanner.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(e -> Toast.makeText(scanner.this, "Failure", Toast.LENGTH_SHORT).show());
    }
}