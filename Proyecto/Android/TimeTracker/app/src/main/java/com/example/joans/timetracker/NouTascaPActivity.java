package com.example.joans.timetracker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
//Clase que pide al usuario Nombre , Descripción  y Hora de Inicio de un nueva Tarea Preprogramada que desee crear

public class NouTascaPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nou_tasca_p);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //CalendarPicker de Fecha Inicio
        final Calendar cal = Calendar.getInstance();
        final String formato = "dd/MM/yy";
        final SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.US);


        final EditText fecha_inicio = (EditText) findViewById(R.id.campoFecha_I);
        final DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                cal.set(Calendar.YEAR, year);
                cal.set(Calendar.MONTH, monthOfYear);
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                fecha_inicio.setText(sdf.format(cal.getTime()));

            }

        };
        fecha_inicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                new DatePickerDialog(NouTascaPActivity.this,listener,cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
                        cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        //TimePicker para la hora de inicio
        final EditText horaInicio =(EditText) findViewById(R.id.campoHora_I);
        horaInicio.setInputType(InputType.TYPE_NULL);
        horaInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int hora = cldr.get(Calendar.HOUR_OF_DAY);
                int min = cldr.get(Calendar.MINUTE);

                TimePickerDialog picker = new TimePickerDialog(NouTascaPActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                horaInicio.setText(sHour + ":" + sMinute + " h");
                            }
                        }, hora, min, true);
                picker.show();
            }
        });


        //El boton CREAR te lleva a la activity de la tasca generada
        Button botonTP = (Button) findViewById(R.id.botonTascaP);
        botonTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_tasP = new Intent(NouTascaPActivity.this, TascaActivity.class);
                startActivity(intent_tasP);



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
