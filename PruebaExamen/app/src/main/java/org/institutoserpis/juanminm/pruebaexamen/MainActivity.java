package org.institutoserpis.juanminm.pruebaexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String PEDIDO = "org.institutoserpis.juanminm.pruebaexamen.PEDIDO";

    private Destino[] destinos;

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

        destinos = new Destino[]{
                new Destino(
                        R.string.global_zona_a,
                        R.string.global_zona_a_continentes,
                        30,
                        R.drawable.asia_oceania),
                new Destino(
                        R.string.global_zona_b,
                        R.string.global_zona_b_continentes,
                        20,
                        R.drawable.america_africa),
                new Destino(
                        R.string.global_zona_c,
                        R.string.global_zona_c_continentes,
                        10,
                        R.drawable.europa)
        };

        DestinoAdapter adaptadorDestinos = new DestinoAdapter(this, destinos);
        zonaSpinner.setAdapter(adaptadorDestinos);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch(item.getItemId()) {
            case R.id.menu_opt_mostrar_logo:
                //TODO Pasar a LogoActivity
                return true;
            case R.id.menu_opt_acerca_de:
                intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void calcular() {
        Intent intent = new Intent(this, ResultadoActivity.class);
        Bundle bundle = new Bundle();
        Pedido pedido;
        int posicion;
        int tarifa;
        double peso;
        boolean conCaja;
        boolean conTarjeta;

        // Obtener la zona
        posicion = zonaSpinner.getSelectedItemPosition();

        // Obtener la tarifa
        switch(tarifaRGroup.getCheckedRadioButtonId()) {
            case R.id.activity_main_rb_tarifa_normal:
                tarifa = 0;
                break;
            case R.id.activity_main_rb_tarifa_urgente:
                tarifa = 1;
                break;
            default:
                tarifa = 0;
        }

        // Obtener si tendra caja, targeta o ambas
        conCaja = cajaRegaloCBox.isChecked();
        conTarjeta = conTarjetaCBox.isChecked();

        //Obtener peso
        peso = Double.valueOf(pesoEText.getText().toString());

        pedido = new Pedido(destinos[posicion], tarifa, conTarjeta, conCaja, peso);

        bundle.putSerializable(PEDIDO, pedido);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
