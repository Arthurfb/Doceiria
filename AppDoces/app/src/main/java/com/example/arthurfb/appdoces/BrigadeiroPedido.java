package com.example.arthurfb.appdoces;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BrigadeiroPedido extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brigadeiro_pedido);

        //Lista de opções do spinner na Activity BrigadeiroPedido
        Spinner festaOuPessoal = (Spinner) findViewById(R.id.festaOuPessoal);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.opçoes_array,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        festaOuPessoal.setAdapter(adapter);
    }

    String sabor;
    int preçoPorBrigadeiro = 1;
    int preçoTotal;

    //Realiza o pedido//
    public void verificarSabor(View view) {

        //Define o sabor//
        boolean saborEscolhido = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio1_opçao1:
                if (saborEscolhido)
                    sabor = "KitKat";
                break;
            case R.id.radio1_opçao2:
                if (saborEscolhido)
                    sabor = "Oreo";
                break;
            case R.id.radio1_opçao3:
                if (saborEscolhido)
                    sabor = "Brigadeiro Tradicional";
                break;
            case R.id.radio1_opçao4:
                if (saborEscolhido)
                    sabor = "Churros";
                break;
            case R.id.radio1_opçao5:
                if (saborEscolhido)
                    sabor = "Leite Ninho";
                break;
        }
    }

    public void pedir(View view) {
        //Recebe o pedido da activity anterior//
        Intent intentPedido = getIntent();
        String pedido = intentPedido.getStringExtra("nome");

        //Para saber quantos brigadeiros foram pedidos//
        EditText quantidade_texto = (findViewById(R.id.quantidadeBrigadeiro));
        String quantidadeTexto = quantidade_texto.getText().toString();

        //Converte a String quantidadeTexto para int//
        int quantidadeTextoInt = new Integer(quantidadeTexto).intValue();

        //Calcula o preço//
        preçoTotal = quantidadeTextoInt * preçoPorBrigadeiro;

        //Valores que serão inseridos na mensagem enviada ao fornecedor//
        String mensagemDoPreço = "Seu pedido contem: " + quantidadeTextoInt;
        mensagemDoPreço += "\n Sabor: " + sabor;
        mensagemDoPreço += "\n No valor de: " + "R$" + preçoTotal;

        //Envia dados para o email
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:arthur.ferreira@souunit.com.br")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pedido realizado");
        intent.putExtra(Intent.EXTRA_TEXT, " Contém os seguintes dados:\n" + pedido + "\n" + mensagemDoPreço);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
