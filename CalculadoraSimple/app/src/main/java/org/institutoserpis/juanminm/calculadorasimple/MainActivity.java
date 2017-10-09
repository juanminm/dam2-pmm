package org.institutoserpis.juanminm.calculadorasimple;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText num1EditText = (EditText) findViewById(R.id.activity_main_et_num1);
        final EditText num2EditText = (EditText) findViewById(R.id.activity_main_et_num2);
        final EditText resultadoEditText = (EditText) findViewById(R.id.activity_main_et_resultado);
        final RadioGroup seleccionOperacionGroup = (RadioGroup) findViewById(
                R.id.activity_main_rg_seleccionar_operacion);

        seleccionOperacionGroup.clearCheck();
        seleccionOperacionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                double resultado = 0;
                double num1 = Double.parseDouble(num1EditText.getText().toString());
                double num2 = Double.parseDouble(num2EditText.getText().toString());

                if (group.getCheckedRadioButtonId() == R.id.activity_main_rb_suma) {
                    resultado = num1 + num2;
                }
                if (group.getCheckedRadioButtonId() == R.id.activity_main_rb_resta) {
                    resultado = num1 - num2;
                }

                resultadoEditText.setText(String.valueOf(resultado));
            }
        });
    }
}
