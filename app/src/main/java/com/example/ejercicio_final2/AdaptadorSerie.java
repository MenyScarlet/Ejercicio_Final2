package com.example.ejercicio_final2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Melania on 25/02/2018.
 */


public class AdaptadorSerie extends ArrayAdapter<Serie>{

    ArrayList<Serie> series;
    Context c;

    public AdaptadorSerie(Context c, ArrayList<Serie> series) {
        super(c, R.layout.item_serie, series);
        this.series = series;
        this.c = c;
    }

    public View getView(int position, View view, ViewGroup
            viewGroup) {
        LayoutInflater inflater =
                LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_serie, null);


        TextView tv_nombre = (TextView)
                item.findViewById(R.id.ItemLvNombre);
        tv_nombre.setText(series.get(position).getNombre() );


        TextView tv_genero = (TextView)
                item.findViewById(R.id.ItemLvGenero);
        tv_genero.setText(series.get(position).getGenero() );

        TextView tv_year = (TextView)
                item.findViewById(R.id.ItemLvYear);
        tv_year.setText(series.get(position).getYear() );

        Drawable drawable = this.getImagen(series.get(position).getGenero());
        ImageView iv_logo = (ImageView)
                item.findViewById(R.id.ItemIvSerie);
        iv_logo.setImageDrawable(drawable);
        return item;
    }

    private Drawable getImagen( String genero ){
        Drawable drawable;
        switch ( genero ){
            case "Acción":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.accion);
                break;
            case "Terror":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.terror);
                break;
            case "Humor":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.comedia);
                break;
            case "Romance":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.amor);
                break;
            case "Familiar":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.familiar);
                break;
            case "Aventura":
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.aventura);
                break;
            default:
                drawable = ContextCompat.getDrawable(c.getApplicationContext(),R.drawable.defecto);
        }
        return  drawable;
    }
}
