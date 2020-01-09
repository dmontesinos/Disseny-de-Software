package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//Es la clase correspondiente a los diferentes tipos que se pueden crear, en esta clase simplemente
// al clicar en la tarea que interese, te manda a su activity correspondiente.
public class TipusTascaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipus_tasca);

        //Te manda a la tarea basica
        TextView basica = (TextView) findViewById(R.id.tareaB);
        basica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tareab = new Intent(TipusTascaActivity.this, NouTascaActivity.class);
                startActivity(intent_tareab);



            }
        });

        //Te manda a la tarea de tiempo limitado
        TextView tiempo_limitado = (TextView) findViewById(R.id.tareaTL);
        tiempo_limitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tl = new Intent(TipusTascaActivity.this, NouTascaTLActivity.class);
                startActivity(intent_tl);



            }
        });

        //Te manda a la tarea preprogramada
        TextView tiempo_p = (TextView) findViewById(R.id.tareaP);
        tiempo_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_p = new Intent(TipusTascaActivity.this, NouTascaPActivity.class);
                startActivity(intent_p);



            }
        });

        //Te manda a la tarea preprogramada con tiempo limitado
        TextView tiempo_ptl = (TextView) findViewById(R.id.tareaPTL);
        tiempo_ptl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_ptl = new Intent(TipusTascaActivity.this, NouTascaPTLActivity.class);
                startActivity(intent_ptl);



            }
        });



    }
}
