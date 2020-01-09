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
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

//Esta clase corresponde a la actividad de crear un nuevo Informe, en esta clase
// mostramos diferentes opciones para el informe, como el tipo o el formato

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

        //CalendarPicker de Fecha Desde
        final Calendar calD = Calendar.getInstance();
        final String formato = "dd/MM/yy";
        final SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.US);


        final EditText fechaD = (EditText) findViewById(R.id.campoDDesde);
        final DatePickerDialog.OnDateSetListener listenerD = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                calD.set(Calendar.YEAR, year);
                calD.set(Calendar.MONTH, monthOfYear);
                calD.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                fechaD.setText(sdf.format(calD.getTime()));

            }

        };
        fechaD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                new DatePickerDialog(NouInformeActivity.this,listenerD,calD.get(Calendar.YEAR), calD.get(Calendar.MONTH),
                        calD.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //CalendarPicker de Fecha Hasta
        final Calendar calH = Calendar.getInstance();
        final String formatoH = "dd/MM/yy";
        final SimpleDateFormat sdfh = new SimpleDateFormat(formatoH, Locale.US);


        final EditText fechaH = (EditText) findViewById(R.id.campoDHasta);
        final DatePickerDialog.OnDateSetListener listenerDH = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                calH.set(Calendar.YEAR, year);
                calH.set(Calendar.MONTH, monthOfYear);
                calH.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                fechaH.setText(sdfh.format(calH.getTime()));

            }

        };
        fechaH.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                new DatePickerDialog(NouInformeActivity.this,listenerDH,calH.get(Calendar.YEAR), calH.get(Calendar.MONTH),
                        calH.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        //TimePicker para la hora de Desde
        final EditText horaDesde =(EditText) findViewById(R.id.campoHDesde);
        horaDesde.setInputType(InputType.TYPE_NULL);
        horaDesde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldrD = Calendar.getInstance();
                int horaD = cldrD.get(Calendar.HOUR_OF_DAY);
                int minD = cldrD.get(Calendar.MINUTE);

                TimePickerDialog pickerD = new TimePickerDialog(NouInformeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                horaDesde.setText(sHour + ":" + sMinute + " h");
                            }
                        }, horaD, minD, true);
                pickerD.show();
            }
        });

        //TimePicker para la hora de Desde
        final EditText horaHasta =(EditText) findViewById(R.id.campoHHasta);
        horaHasta.setInputType(InputType.TYPE_NULL);
        horaHasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldrH = Calendar.getInstance();
                int horaH = cldrH.get(Calendar.HOUR_OF_DAY);
                int minH = cldrH.get(Calendar.MINUTE);

                TimePickerDialog pickerH = new TimePickerDialog(NouInformeActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker tp, int sHour, int sMinute) {
                                horaHasta.setText(sHour + ":" + sMinute + " h");
                            }
                        }, horaH, minH, true);
                pickerH.show();
            }
        });



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
