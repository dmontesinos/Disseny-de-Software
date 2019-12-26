package core.ds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActividadProyectosRaiz extends AppCompatActivity {

    ListView listView;
    String listElementos[] = {"Hola mundo", "Adios mundo", "Tercer elemento", "Otro elemento"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_proyectos_raiz);

        listView = (ListView) findViewById(R.id.listaActividades);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listElementos);
        listView.setAdapter((arrayAdapter));
    }
}
