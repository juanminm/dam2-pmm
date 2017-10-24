package org.institutoserpis.juanminm.proyectopersona;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by juamar on 20/10/17.
 */

public class Persona implements Parcelable {

    private String nombre;
    private String apellidos;
    private int edad;
    private String sexo;

    public Persona(String nombre, String apellidos, int edad, String sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.sexo = sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String toString() {
        String fin = (sexo.equals("h") ? "Sr." : "Sra.") + " " + nombre + " " + apellidos + " " + edad;


        return fin;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeInt(edad);
        dest.writeString(sexo);

    }

    static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        public Persona createFromParcel(Parcel in) {
            return new Persona(in.readString(), in.readString(), in.readInt(), in.readString());
        }

        @Override
        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };
}
