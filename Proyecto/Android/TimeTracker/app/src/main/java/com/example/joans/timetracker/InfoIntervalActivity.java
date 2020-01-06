package com.example.joans.timetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

//Esta clase es la encargada de asignar los datos recogidos, mediante
// un intent, de un intervalo seleccionado y mostrarlos por pantalla.

public class InfoIntervalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_interval);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Captamos el intent con los datos del intervalo serializados, y lo guardamos en una variable.
        DadesInterval dadesInterval = (DadesInterval) getIntent().getSerializableExtra("dades_interval");




        //Campo Desde en fecha
        TextView fechaDesde = (TextView) findViewById(R.id.fechaDesde);
        fechaDesde.setText(String.valueOf(dadesInterval.getDataI()));


        //Campo Hasta en fecha
        TextView fechaHasta = (TextView) findViewById(R.id.fechaHasta);
        fechaHasta.setText(String.valueOf(dadesInterval.getDataF()));

        TextView duracionIntervalo = (TextView) findViewById(R.id.duracion_i);
        duracionIntervalo.setText(dadesInterval.getDuradaString());


    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {


            //Este case se encarga de que el boton de back te lleve hacia atras
            case android.R.id.home:
                onBackPressed();
                return true;

        }

        return true;
    }
}
