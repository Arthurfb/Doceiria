package com.example.arthurfb.appdoces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void festaPessoalBrigadeiro(View view) {

        // Cria um intent para abrir a activity BrigadeiroPedido
        Intent brigadeiroIntent = new Intent(MainActivity.this, BrigadeiroPedido.class);

        // Inicia a activity
        startActivity(brigadeiroIntent);
    }

    public void festaPessoalOvo(View view) {

        // Cria um intent para abrir a activity FestaPessoa
        Intent festaPessoaIntent = new Intent(MainActivity.this, FestaPessoa.class);

        // Inicia a activity
        startActivity(festaPessoaIntent);
    }
}
