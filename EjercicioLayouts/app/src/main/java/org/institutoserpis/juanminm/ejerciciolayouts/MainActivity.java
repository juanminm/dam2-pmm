package org.institutoserpis.juanminm.ejerciciolayouts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by juamar on 26/09/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton botonALinear = (ImageButton) findViewById(R.id.botonALinear_img);
        final ImageButton botonATable = (ImageButton) findViewById(R.id.botonATable_img);
        final ImageButton botonARelative = (ImageButton) findViewById(R.id.botonARelative_img);
        final ImageButton botonAGrid = (ImageButton) findViewById(R.id.botonAGrid_img);

        botonALinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        botonATable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });

        botonARelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        botonAGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GridLayoutActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart MainActivity", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume MainActivity", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        Toast.makeText(this,"onPause MainActivity", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop MainActivity", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart MainActivity", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        Toast.makeText(this,"onDestroy MainActivity", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


}
