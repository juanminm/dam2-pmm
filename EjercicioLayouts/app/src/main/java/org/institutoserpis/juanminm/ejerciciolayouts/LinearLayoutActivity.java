package org.institutoserpis.juanminm.ejerciciolayouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by juamar on 26/09/17.
 */

public class LinearLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        final Button botonPrueba = (Button) findViewById(R.id.botonPrueba);
        final TextView etiquetaPrueba = (TextView) findViewById(R.id.etiquetaPrueba);

        botonPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart LinearLayout", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume LinearLayout", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause LinearLayout", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop LinearLayout", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart LinearLayout", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy LinearLayout", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
