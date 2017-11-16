package org.institutoserpis.juanminm.pruebaexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class AcercaDeActivity extends AppCompatActivity {

    TextView versionTView;
    TextView autoresTView;
    TextView copyrightTView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        int anyo = Calendar.getInstance().get(Calendar.YEAR);

        versionTView = findViewById(R.id.activity_acerca_de_tv_version);
        autoresTView = findViewById(R.id.activity_acerca_de_tv_autores);
        copyrightTView = findViewById(R.id.activity_acerca_de_tv_copyright);

        versionTView.setText(String.format(
                getResources().getString(R.string.activity_acerca_de_version),
                getResources().getString(R.string.activity_acerca_de_version_numero)
        ));

        autoresTView.setText(String.format(
                getResources().getString(R.string.activity_acerca_de_autores),
                getResources().getString(R.string.activity_acerca_de_autores_nombres)
        ));

        copyrightTView.setText(String.format(
                getResources().getString(R.string.actitivy_acerca_de_copyright),
                anyo
        ));
    }
}
