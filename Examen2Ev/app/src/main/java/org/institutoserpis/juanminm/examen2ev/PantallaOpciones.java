package org.institutoserpis.juanminm.examen2ev;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by juamar on 15/12/17.
 */

public class PantallaOpciones extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, new SettingsFragment());
        ft.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        setResult(RESULT_OK);
        finish();
    }
}
