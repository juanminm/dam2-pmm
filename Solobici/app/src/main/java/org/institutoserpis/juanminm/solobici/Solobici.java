package org.institutoserpis.juanminm.solobici;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Solobici extends AppCompatActivity {

    private Button juegoBoton;
    private Button preferenciasBoton;
    private Button acerdaCeBoton;
    private Button salirBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solobici);

        juegoBoton = findViewById(R.id.activity_solibici_btn_jugar);
        preferenciasBoton = findViewById(R.id.activity_solibici_btn_configurar);
        acerdaCeBoton = findViewById(R.id.activity_solibici_btn_acercade);
        salirBoton = findViewById(R.id.activity_solibici_btn_salir);

        juegoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarJuego();
            }
        });

        preferenciasBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Lanzar preferencias
            }
        });

        acerdaCeBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Lanzar acercaDe
            }
        });

        salirBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO parar juego
            }
        });
    }

    public void lanzarJuego() {
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }
}
