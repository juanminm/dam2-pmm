package org.institutoserpis.juanminm.canvas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ejemploCanvasBtn;
    Button ejemploShapeDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ejemploCanvasBtn = findViewById(R.id.activity_main_btn_ejemplo_canvas);
        ejemploShapeDrawable = findViewById(R.id.activity_main_btn_ejemplo_shape_drawable);

        ejemploCanvasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EjemploCanvas.class);
                startActivity(intent);
            }
        });

        ejemploShapeDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EjemploShapeDrawable.class);
                startActivity(intent);
            }
        });
    }
}
