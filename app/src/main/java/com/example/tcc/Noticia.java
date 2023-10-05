package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Noticia extends AppCompatActivity {
    TextView textView19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        textView19= (TextView) findViewById(R.id.textView19);
        textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://g1.globo.com/sp/piracicaba-regiao/noticia/2023/01/03/apos-maior-enchente-da-historia-de-capivari-rio-baixa-e-familias-comecam-a-voltar-para-casas.ghtml";
               Intent urlIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                );
                startActivity(urlIntent);
            }
        });
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
        Intent intent = new Intent(this, Adm.class);
        startActivity(intent);
    }
}
