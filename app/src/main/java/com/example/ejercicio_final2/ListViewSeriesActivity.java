package com.example.ejercicio_final2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewSeriesActivity extends AppCompatActivity {

    ListView lvSeries;
    ArrayList<Serie> lista_series = new ArrayList<Serie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_series);

        lvSeries = (ListView) findViewById(R.id.LvSeries);
        AdaptadorSerie adaptadorSerie = new AdaptadorSerie(this, lista_series);
        lvSeries.setAdapter(adaptadorSerie);

        Bundle b = getIntent().getExtras();
        if (b!=null){
            Serie s = b.getParcelable(FormularioSeriesActivity.EXTRA_SERIE);
        }



    }

    private void Cargardatos(){

        lista_series.add()

    }
}
