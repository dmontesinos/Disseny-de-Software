package core.ds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;


/*public class ActividadPrincipal extends AppCompatActivity {

    ListView listView;
    String listElementos[] = {"Hola mundo", "Adios mundo", "Tercer elemento", "Otro elemento"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listaElementos);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listElementos);
        listView.setAdapter((arrayAdapter));
    }
}*/

public class ActividadPrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butoPerComensar = (Button) findViewById(R.id.buttonStart);
        butoPerComensar.setOnClickListener(butoStartListener);
    }

    private View.OnClickListener butoStartListener = new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(ActividadPrincipalActivity.this, ListaActividadesActivity.class);
            startActivity(intent);
        }
    };
}