package com.example.ejercicio_final2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FormularioSeriesActivity extends AppCompatActivity {

    EditText ForEtNombre, ForEtTemporada, ForEtEpisodio, ForEtYear, ForEtSipnosis;
    RadioGroup ForRgGenero1, ForRgGenero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_series);

        ForEtNombre = (EditText)findViewById(R.id.ForEtNombre);
        ForEtTemporada = (EditText)findViewById(R.id.ForEtTemporada);
        ForEtEpisodio = (EditText)findViewById(R.id.ForEtEpisodios);
        ForEtYear = (EditText)findViewById(R.id.ForEtYear);
        ForEtSipnosis = (EditText)findViewById(R.id.ForEtSipnosis);
        ForRgGenero1 = (RadioGroup)findViewById(R.id.ForRgGenero1);
        ForRgGenero2 = (RadioGroup)findViewById(R.id.ForRgGenero2);

    }//FIN onCreate




    public void clickForBtnGuardar (View view){

        String nombre = ForEtNombre.getText().toString();
        String temporada = ForEtTemporada.getText().toString();
        String episodios = ForEtEpisodio.getText().toString();
        String year = ForEtYear.getText().toString();
        String sipnosis = ForEtSipnosis.getText().toString();
        int idGenero = ForRgGenero1.getCheckedRadioButtonId() +
                ForRgGenero2.getCheckedRadioButtonId();
        //RadioButton rbSelecionado = (RadioButton)findViewById(idGenero);
        //String textoRbSeleccionado = rbSelecionado.getText().toString();


        if (nombre.equals("") || temporada.equals("") || episodios.equals("")
                || year.equals("") || idGenero == -1) {

            Toast.makeText(getApplicationContext(),
                    "Debes de rellenar todos los campos",
                    Toast.LENGTH_LONG).show();
        }else{
            //Combertir string en int de temporada y episodio
            Serie serie = new Serie(nombre,temporada,episodios,idGenero,year,sipnosis);

            Intent i = new Intent(getApplicationContext(),
                    ListViewSeriesActivity.class);
            //i.putExtra();
            startActivity(i);

        }

    }

    public void clickForBtnBorrar (View view){

        ForEtNombre.setText("");
        ForEtTemporada.setText("");
        ForEtEpisodio.setText("");
        ForEtYear.setText("");
        ForEtSipnosis.setText("");
        ForRgGenero1.clearCheck();
        ForRgGenero2.clearCheck();

    }
}//FIN MainActivity
