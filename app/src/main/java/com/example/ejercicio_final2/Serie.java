package com.example.ejercicio_final2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Melania on 23/02/2018.
 */

public class Serie implements Parcelable {

    //Atributos
    String nombre;
    int temporada;
    int episodio;
    String genero;
    String year;
    String sipnosis;

    //CREATOR
    public static final Parcelable.Creator<Serie> CREATOR = new
            Parcelable.Creator<Serie>() {
                public Serie createFromParcel(Parcel in) {
                    return new Serie(in);
                }
                public Serie[] newArray(int size) {
                    return new Serie[size];
                }
            };
//FIN CREATOR

    //Constructor

    public Serie(String nombre, int temporada, int episodio,
                 String genero, String year, String sipnosis) {
        this.nombre = nombre;
        this.temporada = temporada;
        this.episodio = episodio;
        this.genero = genero;
        this.year = year;
        this.sipnosis = sipnosis;
    }

    public Serie (Parcel p){

        readFromParcel(p);

    }

    //Getters & setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getEpisodio() {
        return episodio;
    }

    public void setEpisodio(int episodio) {
        this.episodio = episodio;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.nombre);
        parcel.writeString(this.genero);
        parcel.writeString(this.year);
        parcel.writeString(this.sipnosis);
        parcel.writeInt(this.temporada);
        parcel.writeInt(this.episodio);

    }
}

private void readFromParcel (Parcel p){

    this.nombre = p.readString();
    this.genero = p.readString();
    this.year = p.readString();
    this.sipnosis = p.readString();
    this.temporada = p.readInt();
    this.episodio = p.readInt();

}
