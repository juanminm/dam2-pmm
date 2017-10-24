package org.institutoserpis.juanminm.listasimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button botonAMyListaSimple = (Button) findViewById(
                R.id.activity_main_btn_to_my_lista_simple);
        final Button botonAMySpinnerSimple = (Button) findViewById(
                R.id.activity_main_btn_to_my_spinner_simple);

        botonAMyListaSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyListaSimple.class);
                startActivity(intent);
            }
        });

        botonAMySpinnerSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MySpinnerSimple.class);
                startActivity(intent);
            }
        });
    }
}
