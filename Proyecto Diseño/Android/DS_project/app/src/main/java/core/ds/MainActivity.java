package core.ds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonComenzar = (Button) findViewById(R.id.botonComenzar);
        botonComenzar.setOnClickListener(botonStartListener);

        /*new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(MainActivity.this, ActividadProyectosRaiz.class);
                startActivity(intent);
                finish();
            };
        }, 3000);*/
    }

    private View.OnClickListener botonStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ActividadProyectosRaiz.class);
            startActivity(intent);
        }
    };
}
