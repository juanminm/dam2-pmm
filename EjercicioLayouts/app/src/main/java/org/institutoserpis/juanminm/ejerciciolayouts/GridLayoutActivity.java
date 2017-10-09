package org.institutoserpis.juanminm.ejerciciolayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by juamar on 26/09/17.
 */

public class GridLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);

        final Button botonPrueba = (Button) findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView) findViewById(R.id.etiquetaPrueba);

        botonPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
