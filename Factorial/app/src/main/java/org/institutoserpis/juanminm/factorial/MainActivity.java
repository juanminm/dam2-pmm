package org.institutoserpis.juanminm.factorial;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToFactSinHilosButton;
    Button goToFactConHilosButton;
    Button goToFactConAsynctaskButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToFactSinHilosButton = findViewById(R.id.activity_main_btn_fact_sin_hilos);
        goToFactConHilosButton = findViewById(R.id.activity_main_btn_fact_con_hilos);
        goToFactConAsynctaskButton = findViewById(R.id.activity_main_btn_fact_con_asyntask);

        goToFactSinHilosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FactorialSinHilosActivity.class);

                goToActivity(intent);
            }
        });

        goToFactConHilosButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FactorialConHilosActivity.class);

                goToActivity(intent);
            }
        });

        goToFactConAsynctaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
    }

    private void goToActivity(Intent intent) {
        startActivity(intent);
    }
}
