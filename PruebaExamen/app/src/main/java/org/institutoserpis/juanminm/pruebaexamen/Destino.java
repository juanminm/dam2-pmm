package org.institutoserpis.juanminm.pruebaexamen;

import java.io.Serializable;

/**
 * Created by Juanmi on 2017-11-16.
 */

public class Destino implements Serializable {

    private String zona;
    private String contientes;
    private double precio;
    private int imagen;

    public Destino(int zona, int contientes, double precio, int imagen) {
        this.zona = zona;
        this.contientes = contientes;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getZona() {
        return zona;
    }

    public double getPrecio() {
        return precio;
    }

    public String getContientes() {
        return contientes;
    }

    public int getImagen() {
        return imagen;
    }
}
