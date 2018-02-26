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

    static final String EXTRA_SERIE = "EXTRA_SERIE";
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

        ForRgGenero1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if( i != -1 ) {
                    if (ForRgGenero2.getCheckedRadioButtonId() != -1) {
                        ForRgGenero2.clearCheck();
                    }
                    radioGroup.check(i);
                }
            }
        });

        ForRgGenero2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if( i != -1 ) {
                    if (ForRgGenero1.getCheckedRadioButtonId() != -1) {
                        ForRgGenero1.clearCheck();
                    }
                    radioGroup.check(i);
                }
            }
        });
    }//FIN onCreate

    public void clickForBtnGuardar (View view){

        String nombre = ForEtNombre.getText().toString();
        String temporada = ForEtTemporada.getText().toString();
        String episodios = ForEtEpisodio.getText().toString();
        String year = ForEtYear.getText().toString();
        String sipnosis = ForEtSipnosis.getText().toString();

        int IdRgGenero1 = ForRgGenero1.getCheckedRadioButtonId();
        int IdRgGenero2 = ForRgGenero2.getCheckedRadioButtonId();

        String genero = "";
        if(IdRgGenero1!=-1){
            RadioButton r = (RadioButton)  ForRgGenero1.findViewById(IdRgGenero1);
            genero = r.getText().toString();
        } else if(IdRgGenero2!=-1){
            RadioButton r = (RadioButton)  ForRgGenero2.findViewById(IdRgGenero2);
            genero = r.getText().toString();
        }


        if (nombre.equals("") || temporada.equals("") || episodios.equals("")
                || year.equals("") || genero.equals("")) {

            Toast.makeText(getApplicationContext(),
                    "Debes de rellenar todos los campos",
                    Toast.LENGTH_LONG).show();
        }else{

            int temporadaint = Integer.parseInt(temporada);
            int episodioint = Integer.parseInt(episodios);

            Serie serie = new Serie(nombre, temporadaint, episodioint, genero, year, sipnosis);

            Intent i = new Intent(getApplicationContext(),
                    ListViewSeriesActivity.class);

            i.putExtra(EXTRA_SERIE, serie);

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
