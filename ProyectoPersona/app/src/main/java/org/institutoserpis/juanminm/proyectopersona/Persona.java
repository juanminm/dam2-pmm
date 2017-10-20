package org.institutoserpis.juanminm.proyectopersona;

import java.io.Serializable;

/**
 * Created by juamar on 20/10/17.
 */

public class Persona implements Serializable {

    private String nombre;
    private String apellidos;
    private int edad;
    private char sexo;

    public Persona(String nombre, String apellidos, int edad, char sexo) {
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

    public void setSexo(char sexo) {
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

    public char getSexo() {
        return sexo;
    }

    public String toString() {
        String fin = (sexo == 'h' ? "Sr." : "Sra.") + " " + nombre + " " + apellidos + " " + edad;


        return fin;
    }
}
