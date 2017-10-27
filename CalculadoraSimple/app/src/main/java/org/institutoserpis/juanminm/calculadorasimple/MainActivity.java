package org.institutoserpis.juanminm.calculadorasimple;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1EditText;
    EditText num2EditText;
    EditText resultadoEditText;
    RadioGroup seleccionOperacionGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1EditText = (EditText) findViewById(R.id.activity_main_et_num1);
        num2EditText = (EditText) findViewById(R.id.activity_main_et_num2);
        resultadoEditText = (EditText) findViewById(R.id.activity_main_et_resultado);
        seleccionOperacionGroup = (RadioGroup) findViewById(
                R.id.activity_main_rg_seleccionar_operacion);

        num1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (canCalculate())
                    calculate();
            }
        });

        num2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (canCalculate())
                    calculate();
            }
        });

        seleccionOperacionGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                calculate();
            }
        });
    }

    private boolean canCalculate() {
        return !num1EditText.getText().toString().equals("") &&
                !num1EditText.getText().toString().equals("-") &&
                !num1EditText.getText().toString().equals(".") &&
                !num2EditText.getText().toString().equals("") &&
                !num2EditText.getText().toString().equals("-") &&
                !num2EditText.getText().toString().equals(".") ;
    }

    private void calculate() {
        double resultado = 0;
        double num1 = Double.parseDouble(num1EditText.getText().toString());
        double num2 = Double.parseDouble(num2EditText.getText().toString());

        if (seleccionOperacionGroup.getCheckedRadioButtonId() == R.id.activity_main_rb_suma) {
            resultado = num1 + num2;
        }
        if (seleccionOperacionGroup.getCheckedRadioButtonId() == R.id.activity_main_rb_resta) {
            resultado = num1 - num2;
        }

        resultadoEditText.setText(String.valueOf(resultado));
    }
}