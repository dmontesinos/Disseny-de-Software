package com.example.joans.timetracker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

//Esta clase es una clase adaptadora que hemos creado, dentro de esta clase modificamos cada elemento
// de cada item de la lista, que en este caso es la lista de Actividades. De este modo podemos
//personalizar cada elemento que se muestra en la lista.

public class ActivitatAdapter extends ArrayAdapter<DadesActivitat> {
        private final int resource;

    public ActivitatAdapter(@NonNull Context context, int resource, @NonNull List<DadesActivitat> objects) {
        super(context, 0, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    //Esta función nos permite modificar lo que se ve en el adaptador.
    public View getView(final int position, @Nullable View constrainLayout, @NonNull ViewGroup parent) {

        // Vamos cogiendo cada item y lo metemos en dadesActivitat
         final DadesActivitat dadesActivitat = getItem(position);
         //Mira si alguna view se esta usando
        if (constrainLayout == null) {
            constrainLayout = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        //Ponemos el nombre al text view  del nombre a partir de la función de obtener el nombre
        TextView nombre = (TextView) constrainLayout.findViewById(R.id.nombre);
        nombre.setText(dadesActivitat.getNom());

        ImageView icono = constrainLayout.findViewById(R.id.icono_actividad);

        //Determinamos que icono se muestra en función de si es Proyecto o tarea
        if (dadesActivitat.isProjecte()){
             icono.setImageResource(R.mipmap.icono_proyecto);
        }
       else{
            icono.setImageResource(R.mipmap.icono_tarea);
        }



    //Establecemos la duración.
        TextView duracion = (TextView) constrainLayout.findViewById(R.id.duracion_i);
        duracion.setText("Duración: "+dadesActivitat.getHores()+"h "+ dadesActivitat.getMinuts()+"m "+ dadesActivitat.getSegons()+"s");

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

        //Cambiar el fondo de la actividad que esté en ejecución y cambiar el boton de play a pause
        ImageView icono_play = constrainLayout.findViewById(R.id.icono_play);


        if (dadesActivitat.isCronometreEngegat()){
            constrainLayout.setBackgroundColor(Color.rgb(97,196,255));
            icono_play.setImageResource(R.mipmap.icono_pause);
        }
        else{
                constrainLayout.setBackgroundColor(Color.WHITE);
            icono_play.setImageResource(R.mipmap.icono_play);
            }

        //En lugar de hacer con longClick en el item, es el botón de play quien activa el cronometro.


        icono_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (dadesActivitat.isTasca()) {
                    Intent inte;
                    if (!dadesActivitat.isCronometreEngegat()) {
                        inte = new Intent(
                                LlistaActivitatsActivity.ENGEGA_CRONOMETRE);

                    } else {
                        inte = new Intent(
                                LlistaActivitatsActivity.PARA_CRONOMETRE);

                    }
                    inte.putExtra("posicio", position);
                    getContext().sendBroadcast(inte);
                }



            }
        });



        return constrainLayout;
    }
}
