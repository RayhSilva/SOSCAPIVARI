package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtEmailL, txtSenhaL;
    Button btnEntrar;
     SQLiteDatabase bancoDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        txtEmailL = (EditText) findViewById(R.id.txtEmailL);
        txtSenhaL = (EditText) findViewById(R.id.txtSenhaL);
        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        //verificarLoginSenha();

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Entrar();
                verificarLoginSenha();
            }
        });


        }

    public void verificarLoginSenha () {
        String strLogin = txtEmailL.getText().toString();
        String strSenha = txtSenhaL.getText().toString();
        String str = "SELECT * FROM usuario WHERE Email='" + strLogin + "' and Senha='" + strSenha + "'";
        bancoDados = openOrCreateDatabase("sosCapivari", MODE_PRIVATE, null);
        Cursor meuCursor = bancoDados.rawQuery(str, null);
        if (meuCursor.getCount() > 0) {
            Toast.makeText(this, "Login com sucesso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, TelaPrincipal.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Falhou,Tente novamente!! ", Toast.LENGTH_SHORT).show();
            // O Toast não está funcionando! Verificar!!!

        }
    }

    public void Entrar() {
        Intent intent = new Intent(this, TelaPrincipal.class);
        startActivity(intent);
    }}