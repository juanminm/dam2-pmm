package org.institutoserpis.juanminm.pruebaexamen;

import java.io.Serializable;

/**
 * Created by juamar on 14/11/17.
 */

public class Pedido implements Serializable {
    private String zona;
    private String tarifa;
    private double peso;
    private boolean conTarjeta;
    private boolean conCaja;

    public Pedido (String zona, String tarifa, boolean conTarjeta, boolean conCaja, double peso) {
        this.zona = zona;
        this.tarifa = tarifa;
        this.conTarjeta = conTarjeta;
        this.conCaja = conCaja;
        this.peso = peso;
    }

    public String getZona() {
        return zona;
    }

    public String getTarifa() {
        return tarifa;
    }

    public boolean isConCaja() {
        return conCaja;
    }

    public boolean isConTarjeta() {
        return conTarjeta;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return zona + "," + tarifa + "," + conCaja + "," + conTarjeta + "," + peso;
    }
}
