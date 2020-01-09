package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
//Clase que pide al usuario Nombre , Descripción  y tiempo limite de un nueva Tarea con tiempo
// limitado que desee crear.

public class NouTascaTLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_tasca_tl);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Spinner de tiempo limitado

        Spinner spinner_tl = (Spinner) findViewById(R.id.spinner_tl);

        final String[] datos_tl =
                new String[]{"1h","2h","3h","4h"};

        ArrayAdapter<String> adaptador_tl =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos_tl);

        spinner_tl.setAdapter(adaptador_tl);

        //El boton CREAR te lleva a la activity de la tasca generada
        Button botonT = (Button) findViewById(R.id.botonTascaTL);
        botonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tas_tl = new Intent(NouTascaTLActivity.this, TascaActivity.class);
                startActivity(intent_tas_tl);



            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            //Este case se encarga de que el boton de back te lleve hacia atrás
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return true;
    }


}
