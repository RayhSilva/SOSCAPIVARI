package com.example.tcc;

import android.content.Context;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseHelper {

    Context context;

    public DatabaseHelper(Context context) {
        this.context = context;
    }

    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    public void criarUsuario(String txtNomeC, String txtEmailC, String txtSenhaC) {

  auth.createUserWithEmailAndPassword(txtEmailC, txtSenhaC).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {

    if(task.isSuccessful()){
        System.out.println("ok");
    } else {
        System.out.printf("NAO OK");
    }


      }
  });

    }
}
