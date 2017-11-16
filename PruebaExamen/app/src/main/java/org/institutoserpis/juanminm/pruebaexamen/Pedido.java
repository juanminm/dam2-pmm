package org.institutoserpis.juanminm.pruebaexamen;

import java.io.Serializable;

/**
 * Created by juamar on 14/11/17.
 */

public class Pedido implements Serializable {
    private int zona;
    private int tarifa;
    private double peso;
    private boolean conTarjeta;
    private boolean conCaja;

    public Pedido (int zona, int tarifa, boolean conTarjeta, boolean conCaja, double peso) {
        this.zona = zona;
        this.tarifa = tarifa;
        this.conTarjeta = conTarjeta;
        this.conCaja = conCaja;
        this.peso = peso;
    }

    public int getZona() {
        return zona;
    }

    public int getTarifa() {
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
