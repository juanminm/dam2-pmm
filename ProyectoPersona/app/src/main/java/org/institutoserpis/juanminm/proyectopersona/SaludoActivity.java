package org.institutoserpis.juanminm.proyectopersona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SaludoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        TextView saludo = (TextView) findViewById(R.id.saludo);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String mensajeSaludo = "";
        //Persona nombre = (Persona) bundle.getSerializable("PERSONA");
        Persona nombre = bundle.getParcelable("PARCEL");

        mensajeSaludo += "Saludos, " + nombre.toString();

        saludo.setText(mensajeSaludo);
    }
}
