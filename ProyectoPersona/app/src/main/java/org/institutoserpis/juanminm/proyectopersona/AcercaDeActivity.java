package org.institutoserpis.juanminm.proyectopersona;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AcercaDeActivity extends AppCompatActivity {

    TextView acercaDe;
    TextView version;
    TextView autores;
    TextView repositorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        acercaDe = (TextView) findViewById(R.id.activity_acercade_acercade);
        version = (TextView) findViewById(R.id.activity_acercade_version);
        autores = (TextView) findViewById(R.id.activity_acercade_autores);
        repositorio = (TextView) findViewById(R.id.activity_acercade_codigofuente);

        acercaDe.setText(String.format(getString(R.string.app_about), getString(R.string.app_name)));
        version.setText(String.format(getString(R.string.app_version), getString(R.string.app_version_number)));
        autores.setText(String.format(getString(R.string.app_authors), getString(R.string.app_author_list)));
        repositorio.setText(String.format(getString(R.string.app_sourcecode), getString(R.string.app_sourcecode_url)));
    }
}
