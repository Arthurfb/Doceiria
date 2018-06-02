package com.example.arthurfb.appdoces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void festaPessoalBrigadeiro(View view) {
        //A pessoa pede brigadeiro ao apertar o botão Brigadeiro//
        String tipoPedido = "Pediu Brigadeiro";

        // Cria um intent para abrir a activity BrigadeiroPedido
        Intent brigadeiroIntent = new Intent(MainActivity.this, BrigadeiroPedido.class);
        brigadeiroIntent.putExtra("nome", tipoPedido);

        // Inicia a activity
        startActivity(brigadeiroIntent);
    }

    public void festaPessoalOvo(View view) {
        //A pessoa pede ovo de colher ao apertar o botão Ovo De Colher//
        String tipoPedido = "Pediu Ovo De Colher";

        // Cria um intent para abrir a activity FestaPessoa//
        Intent ovoIntent = new Intent(MainActivity.this, FestaPessoa.class);
        ovoIntent.putExtra("nome", tipoPedido);

        // Inicia a activity
        startActivity(ovoIntent);
    }
}
