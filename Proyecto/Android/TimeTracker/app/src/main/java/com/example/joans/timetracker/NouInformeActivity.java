package com.example.joans.timetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.Calendar;

//Esta clase corresponde a la actividad de crear un nuevo Informe, en esta clase
// mostramos diferentes opciones para el informe.

public class NouInformeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_informe);

        //Spinner de la opción personalizado con sus items

        Spinner spinner_p = (Spinner) findViewById(R.id.spinner_personalizado);

        final String[] datos_personalizado =
                new String[]{"Ninguno","Ultima semana","Ultimo mes","Ultimo año"};

        ArrayAdapter<String> adaptador_personalizado =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos_personalizado);

        spinner_p.setAdapter(adaptador_personalizado);


        //Spinner de la opción del tipo de informe
        Spinner spinner_t = (Spinner) findViewById(R.id.spinner_tipo);

        final String[] datos_tipo =
                new String[]{"Breve","Detallado"};

        ArrayAdapter<String> adaptador_tipo =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos_tipo);

        spinner_t.setAdapter(adaptador_tipo);


        //Spinner de la opción del formato de informe
        Spinner spinner_f = (Spinner) findViewById(R.id.spinner_formato);

        final String[] datos_formato =
                new String[]{"Texto","Web","PDF","Hoja de Cálculo"};

        ArrayAdapter<String> adaptador_formato =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos_formato);

        spinner_f.setAdapter(adaptador_formato);


        //El boton CREAR te lleva a la activity del informe generado
        Button botonInforme = (Button) findViewById(R.id.botonInforme);
        botonInforme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_informe = new Intent(NouInformeActivity.this, InformeActivity.class);
                startActivity(intent_informe);



            }
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
