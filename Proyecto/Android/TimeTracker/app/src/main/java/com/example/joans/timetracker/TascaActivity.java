package com.example.joans.timetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

//Clase que corresponde a la nueva Tarea creada

public class TascaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasca);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
