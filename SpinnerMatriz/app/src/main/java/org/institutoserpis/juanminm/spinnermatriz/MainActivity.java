package org.institutoserpis.juanminm.spinnermatriz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerInfo());

        final String[] datos = new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private class SpinnerInfo implements AdapterView.OnItemSelectedListener {

        @Override
        public void onItemSelected(AdapterView<?> espinner, View selectedView, int selectedIndex,
                                   long id) {
            String selection = espinner.getItemAtPosition(selectedIndex).toString();
            showToast(selection);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}
