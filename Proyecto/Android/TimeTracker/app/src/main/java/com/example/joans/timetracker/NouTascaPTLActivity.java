package com.example.joans.timetracker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
//Clase que pide al usuario Nombre , Descripción  y Hora de Inicio, Hora de Inicio y tiempo limiote de un nueva Tarea Preprogramada
// de tiempo limitado que desee crear.

public class NouTascaPTLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_tasca_ptl);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Spinner de tiempo limitado

        Spinner spinner_tlp = (Spinner) findViewById(R.id.spinner_tl2);

        final String[] datos_tlp =
                new String[]{"1h","2h","3h","4h"};

        ArrayAdapter<String> adaptador_tlp =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item, datos_tlp);

        spinner_tlp.setAdapter(adaptador_tlp);

        //TimePicker para la hora de inicio
        final EditText horaInicioPTL =(EditText) findViewById(R.id.campoHora_I2);
        horaInicioPTL.setInputType(InputType.TYPE_NULL);
        horaInicioPTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldrPTL = Calendar.getInstance();
                int horaPTL = cldrPTL.get(Calendar.HOUR_OF_DAY);
                int minPTL = cldrPTL.get(Calendar.MINUTE);

                TimePickerDialog pickerPTL = new TimePickerDialog(NouTascaPTLActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                horaInicioPTL.setText(sHour + ":" + sMinute + " h");
                            }
                        }, horaPTL, minPTL, true);
                pickerPTL.show();
            }
        });

        //CalendarPicker de Fecha Inicio
        final Calendar calPTL = Calendar.getInstance();
        final String formato = "dd/MM/yy";
        final SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.US);


        final EditText fecha_inicioPTL = (EditText) findViewById(R.id.campoFecha_I4);
        final DatePickerDialog.OnDateSetListener listenerPTL = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                calPTL.set(Calendar.YEAR, year);
                calPTL.set(Calendar.MONTH, monthOfYear);
                calPTL.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                fecha_inicioPTL.setText(sdf.format(calPTL.getTime()));

            }

        };
        fecha_inicioPTL.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                new DatePickerDialog(NouTascaPTLActivity.this,listenerPTL,calPTL.get(Calendar.YEAR), calPTL.get(Calendar.MONTH),
                        calPTL.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //El boton CREAR te lleva a la activity de la tasca generada
        Button botonPTL = (Button) findViewById(R.id.botonTascaPTL);
        botonPTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tas_ptl = new Intent(NouTascaPTLActivity.this, TascaActivity.class);
                startActivity(intent_tas_ptl);

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

