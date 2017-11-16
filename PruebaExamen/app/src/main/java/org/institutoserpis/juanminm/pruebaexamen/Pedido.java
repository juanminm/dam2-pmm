package org.institutoserpis.juanminm.pruebaexamen;

import java.io.Serializable;

/**
 * Created by juamar on 14/11/17.
 */

public class Pedido implements Serializable {
    private Destino destino;
    private int tarifa;
    private double peso;
    private boolean conTarjeta;
    private boolean conCaja;

    public Pedido (Destino destino, int tarifa, boolean conTarjeta, boolean conCaja, double peso) {
        this.destino = destino;
        this.tarifa = tarifa;
        this.conTarjeta = conTarjeta;
        this.conCaja = conCaja;
        this.peso = peso;
    }

    public Destino getDestino() {
        return destino;
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
        return destino + "," + tarifa + "," + conCaja + "," + conTarjeta + "," + peso;
    }
}
