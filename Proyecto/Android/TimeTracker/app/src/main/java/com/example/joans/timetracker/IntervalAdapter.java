package com.example.joans.timetracker;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
//Esta clase es una clase adaptadora que hemos creado, dentro de esta clase modificamos cada elemento
// de cada item de la lista, que en este caso es la lista de Intervalos. De este modo podemos
//personalizar cada elemento que se muestra en la lista.


public class IntervalAdapter extends ArrayAdapter<DadesInterval> {
    private final int resource;

    public IntervalAdapter(@NonNull Context context, int resource, @NonNull List<DadesInterval> objects) {
        super(context, 0, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View constrainLayout, @NonNull ViewGroup parent) {

        // Obtenemos el intervalo seleccionado
        DadesInterval dadesInterval = getItem(position);

        if (constrainLayout == null) {
            constrainLayout = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }


        //La duración del intervalo , funcion creada para ese propósito, getDuradaString
        TextView duracion_intervalo= (TextView) constrainLayout.findViewById(R.id.duracion_intervalo);
        duracion_intervalo.setText("Duración: "+dadesInterval.getDuradaString());


        return constrainLayout;
    }
}
