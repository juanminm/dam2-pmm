package org.institutoserpis.juanminm.pruebaexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PEDIDO = "org.institutoserpis.juanminm.pruebaexamen.PEDIDO";

    Button calcularButton;
    CheckBox conTarjetaCBox;
    CheckBox cajaRegaloCBox;
    EditText pesoEText;
    RadioGroup tarifaRGroup;
    Spinner zonaSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEText = findViewById(R.id.activity_main_et_peso_paquete);
        tarifaRGroup = findViewById(R.id.activity_main_rg_tarifa);
        cajaRegaloCBox = findViewById(R.id.activity_main_cb_caja);
        conTarjetaCBox = findViewById(R.id.activity_main_cb_tarjeta);
        zonaSpinner = findViewById(R.id.activity_main_sp_zona);
        calcularButton = findViewById(R.id.activity_main_btn_calcular);

        final String[] paises = new String[]{
                getResources().getString(R.string.activity_main_zona_a),
                getResources().getString(R.string.activity_main_zona_b),
                getResources().getString(R.string.activity_main_zona_c)
        };

        ArrayAdapter<String> adaptadorZonas = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, paises);

        adaptadorZonas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zonaSpinner.setAdapter(adaptadorZonas);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    protected void calcular() {
        //Intent intent = new Intent(this, Resultado.class);
        //Bundle bundle = new Bundle();
        Pedido pedido;
        int tarifa;
        int zona;
        double peso;
        boolean conCaja;
        boolean conTarjeta;

        // Obtener la zona
        switch(zonaSpinner.getSelectedItemPosition()) {
            case 0:
                zona = 0;
                break;
            case 1:
                zona = 1;
                break;
            case 2:
                zona = 2;
                break;
            default:
                zona = 0;
                break;
        }

        // Obtener la tarifa
        switch(tarifaRGroup.getCheckedRadioButtonId()) {
            case R.id.activity_main_rb_tarifa_normal:
                tarifa = 1;
                break;
            case R.id.activity_main_rb_tarifa_urgente:
                tarifa = 2;
                break;
            default:
                tarifa = 1;
        }

        // Obtener si tendra caja, targeta o ambas
        conCaja = cajaRegaloCBox.isChecked();
        conTarjeta = conTarjetaCBox.isChecked();

        //Obtener peso
        peso = Double.valueOf(pesoEText.getText().toString());

        pedido = new Pedido(zona, tarifa, conTarjeta, conCaja, peso);

        //bundle.putSerializable(PEDIDO, pedido);
        //intent.putExtras(bundle);
        //startActivity(intent);

        Toast.makeText(this, pedido.toString(), Toast.LENGTH_SHORT).show();
    }
}
