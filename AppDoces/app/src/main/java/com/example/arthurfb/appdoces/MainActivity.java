package com.example.arthurfb.appdoces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.content.Context;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;

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

        //Notification//
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        //Create the intent that’ll fire when the user taps the notification//

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.brigadeiro.com/"));//só pra ser um intent implícito
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mBuilder.setContentTitle("Aviso");
        mBuilder.setContentText("Escolha o brigadeiro");

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());

        // Inicia a activity
        startActivity(brigadeiroIntent);
    }

    public void festaPessoalOvo(View view) {
        //A pessoa pede ovo de colher ao apertar o botão Ovo De Colher//
        String tipoPedido = "Pediu Ovo De Colher";

        // Cria um intent para abrir a activity FestaPessoa//
        Intent ovoIntent = new Intent(MainActivity.this, FestaPessoa.class);
        ovoIntent.putExtra("nome", tipoPedido);

        //Notification
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this);

        //Create the intent that’ll fire when the user taps the notification//

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ovodecolher.com/"));//só pra ser um intent implícito
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);

        mBuilder.setSmallIcon(R.drawable.ic_launcher_background);
        mBuilder.setContentTitle("Aviso");
        mBuilder.setContentText("Escolha o ovo de colher");

        NotificationManager mNotificationManager =

                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(001, mBuilder.build());

        // Inicia a activity
        startActivity(ovoIntent);
    }
}


