package com.example.joans.timetracker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class IntervalAdapter extends ArrayAdapter<DadesInterval> {
    private final int resource;

    public IntervalAdapter(@NonNull Context context, int resource, @NonNull List<DadesInterval> objects) {
        super(context, 0, objects);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View constrainLayout, @NonNull ViewGroup parent) {

        // Get the data item for this position
        DadesInterval dadesInterval = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (constrainLayout == null) {
            constrainLayout = LayoutInflater.from(getContext()).inflate(resource, parent, false);
        }

        //Establecemos la duración del intervalo, queda feo asi
        /*TextView duracion_intervalo = (TextView) constrainLayout.findViewById(R.id.duracion_intervalo);
        duracion_intervalo.setText("Desde: "+dadesInterval.getDataInicial());

        TextView duracion_intervalo2 = (TextView) constrainLayout.findViewById(R.id.duracion_intervalo2);
        duracion_intervalo2.setText("Hasta: "+ dadesInterval.getDataFinal());*/

        //La duracion del intervalo mejor aprovechar el toString
        TextView duracion_intervalo= (TextView) constrainLayout.findViewById(R.id.duracion_intervalo);
        duracion_intervalo.setText("Duración: "+dadesInterval.toString());


        return constrainLayout;
    }
}
