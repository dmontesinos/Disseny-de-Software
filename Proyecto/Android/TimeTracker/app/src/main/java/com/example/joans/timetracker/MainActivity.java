package com.example.joans.timetracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//Es la activity de inicio, muestra la pantalla prinicipal con un botón
//que nos envia a la siguiente activity.

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butoPerComensar = (Button) findViewById(R.id.botonComenzar);
        butoPerComensar.setOnClickListener(butoStartListener);
    }

    //El botón de comenzar te envia a la lista de Actividades
    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LlistaActivitatsActivity.class);
            startActivity(intent);
        }
    };

}
