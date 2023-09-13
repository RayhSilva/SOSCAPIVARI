package com.example.tcc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Alerta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerta);


        DatabaseHelper helper = new DatabaseHelper(getApplicationContext());
        helper.ListarAlertas(new listarAlertasCallback(){


            @Override
            public void listarAlertasOnCallback(ArrayList<MovimentoOBJ> listaMovimentos) {
                System.out.println(listaMovimentos.size());
                //setar o adapter do rw
            }
        });
    }

        public interface listarAlertasCallback {
            void listarAlertasOnCallback(ArrayList<MovimentoOBJ> listaMovimentos);
            // PAREI NO MINUTO 23:36
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
