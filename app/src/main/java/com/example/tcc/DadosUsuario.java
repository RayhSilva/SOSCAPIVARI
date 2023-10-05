package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.annotation.Documented;

public class DadosUsuario extends AppCompatActivity {

    private TextView nomeUsuatio, emailUsuario;
    private Button deslogar;
    //FirebaseFirestore db = FirebaseFirestore.getInstance();
   // String usuarioId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_usuario);

        iniciarComponentes();

        deslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(DadosUsuario.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        //usuarioId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        // terminar a tela dados usuario
    }

    private void iniciarComponentes( ){
            nomeUsuatio =  findViewById(R.id.nomeUsuario);
            emailUsuario  = findViewById(R.id.emailUsuario);
            deslogar = findViewById(R.id.deslogar);

        }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dados_usuario:
                usuario();
                return true;
            case R.id.administrador:
                adm();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    public void usuario() {
        Intent intent = new Intent(this, DadosUsuario.class);
        startActivity(intent);
    }
    public void adm() {
        String url = "https://firebase.rafaelwendel.com/";
        Intent urlIntent = new Intent(
                Intent.ACTION_VIEW,
                Uri.parse(url)
        );
        startActivity(urlIntent);
    }

}
