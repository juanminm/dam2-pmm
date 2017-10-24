package org.institutoserpis.juanminm.tiposdeeventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        Button btn = (Button) findViewById(R.id.activity_main_boton3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Pulsando boton Tres", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void cmdDos_click() {
        Toast.makeText(ctx, "Pulsando boton Dos", Toast.LENGTH_SHORT).show();
    }
}
