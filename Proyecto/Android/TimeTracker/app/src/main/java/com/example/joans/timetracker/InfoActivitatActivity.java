package com.example.joans.timetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

//Esta clase es la encargada de asignar los datos recogidos, mediante
// un intent, de una actividad seleccionada y mostrarlos por pantalla.

public class InfoActivitatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_activitat);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Capturamos el intent de los datos serializados
        DadesActivitat dadesActivitat = (DadesActivitat) getIntent().getSerializableExtra("dades_activitat");

        //Campo del nombre de la actividad
        TextView nombre_act = (TextView) findViewById(R.id.nombre_act);
        nombre_act.setText(dadesActivitat.getNom());


        //Campo de la descricpción de la actividad
        TextView descripcion_act = (TextView) findViewById(R.id.descripcion_Act);
        descripcion_act.setText(dadesActivitat.getDescripcio());

        //Campo de la duración de la actividad
        TextView duracion_act = (TextView) findViewById(R.id.duracion_Act);
        duracion_act.setText(dadesActivitat.toString());

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
