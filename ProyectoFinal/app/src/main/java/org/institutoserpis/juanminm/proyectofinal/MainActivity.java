package org.institutoserpis.juanminm.proyectofinal;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Player player = (Player) getIntent().getExtras().getSerializable(LoginActivity.LOGGED_PLAYER);

        Fragment newFragment = InventoryFragment.newInstance(player);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main_frame_mainview, newFragment).commit();
    }
}
