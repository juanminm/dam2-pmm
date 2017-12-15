package org.institutoserpis.juanminm.cargarpreferencias;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EjemploPreferenciasActivity extends AppCompatActivity {
    private Button btnPreferencias;
    private Button btnObtenerPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_preferencias);

        btnPreferencias = findViewById(R.id.BtnPreferencias);
        btnObtenerPreferencias = findViewById(R.id.BtnObtenerPreferencias);

        btnPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EjemploPreferenciasActivity.this, PantallaOpciones.class));
            }
        });

        btnObtenerPreferencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(
                        EjemploPreferenciasActivity.this);
                String preferen1="desactivada";
                if (pref.getBoolean("Opcion1", false))
                    preferen1="actidada";

                Toast.makeText(getApplicationContext(),preferen1,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),pref.getString("opcion2",""),Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),pref.getString("opcion3",""),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
