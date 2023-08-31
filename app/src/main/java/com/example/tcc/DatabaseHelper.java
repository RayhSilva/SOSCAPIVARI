package com.example.tcc;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    public void criarUsuario(String txtNomeC, String txtEmailC, String txtSenhaC, ProgressBar progressBar) {
//cria um usuario no firebase
  auth.createUserWithEmailAndPassword(txtEmailC, txtSenhaC).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
      @Override
      public void onComplete(@NonNull Task<AuthResult> task) {

    if(task.isSuccessful()){
        //cria um cadastro de usuario no banco de dados
        reference.child("usuarios").child(auth.getCurrentUser().getUid()).child("nome").setValue(txtNomeC);
        reference.child("usuarios").child(auth.getCurrentUser().getUid()).child("e-mail").setValue(txtEmailC);

        Toast.makeText(context,"Usuário foi criado com sucesso",Toast.LENGTH_SHORT).show();
        CriarConta cc= new CriarConta();
        Intent i = new Intent (cc.activity, TelaInicial.class);
        cc.activity.startActivity(i);
        cc.activity.finish();
    } else {
        progressBar.setVisibility(View.GONE);
        String erro= task.getException().toString();
        if(erro.equals("com.google.firebase.auth.FirebaseAuthInvalidCredentialsException:" +
                " The email address is badly formatted.")){
            Toast.makeText(context, "Insira um e-mail válido", Toast.LENGTH_SHORT).show();
        } else if(erro.equals("com.google.firebase.auth.FirebaseAuthWeakPasswordException:" +
                " The given password is invalid. [ Password should be at least 6 characters ]")){
            Toast.makeText(context, "A senha deve ter no mínimo 6 caracteres", Toast.LENGTH_SHORT).show();
        } else if(erro.equals("com.google.firebase.auth.FirebaseAuthUserCollisionException:" +
                " The email address is already in use by another account.")){
            Toast.makeText(context, "Já existe um usuário com esse e-mail", Toast.LENGTH_SHORT).show();
        }
        System.out.println("nao ok" +task.getException());
    }


      }
  });

    }
//AUTENTICAR USUARIO
    public void autenticaUsuario(String txtEmailL, String txtSenhaL) {

        auth.signInWithEmailAndPassword(txtEmailL,txtSenhaL ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //continuar no minuto 53:20

                }
                    
                }



        });

    }
}
