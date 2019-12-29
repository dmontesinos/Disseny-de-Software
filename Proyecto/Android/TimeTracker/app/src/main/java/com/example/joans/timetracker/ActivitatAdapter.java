package com.example.joans.timetracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ActivitatAdapter extends ArrayAdapter<DadesActivitat> {
    private final int resource;

    public ActivitatAdapter(@NonNull Context context, int resource, @NonNull List<DadesActivitat> objects) {
        super(context, 0, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    //Esta función nos permite modificar lo que se ve en el adaptador.
    public View getView(int position, @Nullable View constrainLayout, @NonNull ViewGroup parent) {

        // Vamos cogiendo cada item y lo metemos en dadesActivitat
        DadesActivitat dadesActivitat = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (constrainLayout == null) {
            constrainLayout = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        //Ponemos el nombre al text view  del nombre a partir de la función de obtener el nombre
        TextView nombre = (TextView) constrainLayout.findViewById(R.id.nombre);
        nombre.setText(dadesActivitat.getNom());

        ImageView icono = constrainLayout.findViewById(R.id.icono_actividad);

        //Deteminamos que icono se muestra en función de si es Proyecto o tarea
        if (dadesActivitat.isProjecte()){
             icono.setImageResource(R.mipmap.icono_proyecto);
        }
       else{
            icono.setImageResource(R.mipmap.icono_tarea);
        }

       //Establecemos la duración.
        TextView duracion = (TextView) constrainLayout.findViewById(R.id.duracion);
        //duracion.setText(String.valueOf(dadesActivitat.getDurada()));
        duracion.setText(dadesActivitat.getHores()+"h "+ dadesActivitat.getMinuts()+"m "+ dadesActivitat.getSegons()+"s");

        //Modificamos icono de basura, aunque en xml ya definido por si se implementa eliminar actividad tenerlo ya capturado
        ImageView icono_basura = constrainLayout.findViewById(R.id.icono_basura);
        icono_basura.setImageResource(R.mipmap.icono_basura);

        //El icono de play solo será visible para las tareas, asi que la ocultamos de los proyectos.
        ImageView play = (ImageView) constrainLayout.findViewById(R.id.icono_play);
        if(dadesActivitat.isProjecte()){
            play.setVisibility(View.INVISIBLE);
        }
        else{
            play.setVisibility(View.VISIBLE);
        }



        //Cmabiar el fondo de la actividad que esté en ejecución
        // if dadesActivitat.isCronometreEngegat()
        //constrainLayout.setBackgroundColor(Color.BLUE);
        // else
        //constrainLayout.setBackgroundColor(Color.WHITE);


        // si is tasca, muestras el boton playstop
        // setear icono pausa o play dependiendo de dadesActivitat.isCronometreEngegat()
        // llamar al onclick con la funcionalidad de play o pausa
        return constrainLayout;
    }
}
