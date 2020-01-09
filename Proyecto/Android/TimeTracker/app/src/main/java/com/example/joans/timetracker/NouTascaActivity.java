package com.example.joans.timetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

//Clase que pide al usuario Nombre y Descripción de un nueva Tarea Básica que desee crear

public class NouTascaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_tasca);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //El boton CREAR te lleva a la activity de la tasca generada
        Button botonT = (Button) findViewById(R.id.botonTasca);
        botonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tas = new Intent(NouTascaActivity.this, TascaActivity.class);
                startActivity(intent_tas);



            }
        });
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
