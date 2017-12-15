package org.institutoserpis.juanminm.solobici;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Vector;

/**
 * Created by juamar on 5/12/17.
 */

public class VistaJuego extends View {
    private Vector<Grafico> Coches;
    private int numCoches = 5;
    private int numMotos = 3;

    private Grafico bici;
    private int giroBici;
    private float aceleracionBici;
    private static final int PASO_GIRO_BICI = 5;
    private static final float PASO_ACELERACION_BICI = 0.5f;

    private HiloJuego hiloJuego;
    private static int PERIODO_PROCESO = 50;
    private long ultimoProceso = 0;

    public VistaJuego(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable graficoBici;
        Drawable graficoCoche;
        Drawable graficoRueda;

        graficoCoche = context.getResources().getDrawable(R.drawable.coche);

        Coches = new Vector<>();

        for (int i = 0; i < numCoches; i++) {
            Grafico coche = new Grafico(this, graficoCoche);
            coche.setIncX(Math.random() * 4 - 2);
            coche.setIncY(Math.random() * 4 - 2);
            coche.setAngulo((int) (Math.random() * 360));
            coche.setRotacion((int) (Math.random() * 8 - 4));
            Coches.add(coche);
        }

        graficoBici = context.getResources().getDrawable(R.drawable.bici);
        bici = new Grafico(this, graficoBici);
        hiloJuego = new HiloJuego();
        hiloJuego.start();
    }

    protected synchronized void actualizaMovimiento() {
        long ahora = System.currentTimeMillis();
        // No hacemos nada si el período de proceso no se ha cumplido.
        if (ultimoProceso + PERIODO_PROCESO > ahora) {
            return;
        }
        // Para una ejecución en tiempo real calculamos retardo
        double retardo = (ahora - ultimoProceso) / PERIODO_PROCESO;
        // Actualizamos la posición de la bici
        bici.setAngulo((int) (bici.getAngulo() + giroBici * retardo));
        double nIncX = bici.getIncX() + aceleracionBici
                * Math.cos(Math.toRadians(bici.getAngulo())) * retardo;
        double nIncY = bici.getIncY() + aceleracionBici
                * Math.sin(Math.toRadians(bici.getAngulo())) * retardo;
        if (Grafico.distanciaE(0, 0, nIncX, nIncY) <= Grafico.getMaxVelocidad()) {
            bici.setIncX(nIncX);
            bici.setIncY(nIncY);
        }
        bici.incrementaPos();

        //Movemos los coches
        for (Grafico coche : Coches) {
            coche.incrementaPos();
        }
        ultimoProceso = ahora;
    }

    private class HiloJuego extends Thread {
        @Override
        public void run() {
            while (true) {
                actualizaMovimiento();
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        for (Grafico coche: Coches)
            do {
                coche.setPosX(Math.random() * (w - coche.getAncho()));
                coche.setPosY(Math.random() * (h - coche.getAlto()));
            } while (coche.distancia(bici) < (w + h) / 5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Grafico coche: Coches)
            coche.dibujarGrafico(canvas);
    }
}
