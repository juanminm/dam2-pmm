package org.institutoserpis.juanminm.proyectofinal;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class MainActivity extends AppCompatActivity {
    Button inventoryButton;
    Button marketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Player player = (Player) getIntent().getExtras().getSerializable(LoginActivity.LOGGED_PLAYER);

        inventoryButton = findViewById(R.id.activity_main_btn_inventory);
        marketButton = findViewById(R.id.activity_main_btn_market);

        inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(InventoryFragment.newInstance(player));
            }
        });

        marketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(MarketFragment.newInstance(player));
            }
        });

        Fragment newFragment = InventoryFragment.newInstance(player);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main_frame_mainview, newFragment).commit();
    }

    private void changeFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_main_frame_mainview, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }
}
