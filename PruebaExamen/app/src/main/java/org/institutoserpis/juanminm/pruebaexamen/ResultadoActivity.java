package org.institutoserpis.juanminm.pruebaexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private double peso;
    private int zona;

    TextView zonaTView;
    TextView tarifaTView;
    TextView pesoTView;
    TextView decoracionTView;
    TextView costeFinalTView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Bundle bundle = getIntent().getExtras();
        Pedido pedido = (Pedido)bundle.getSerializable(MainActivity.PEDIDO);

        zonaTView = findViewById(R.id.activity_resultado_tv_zona);
        tarifaTView = findViewById(R.id.activity_resultado_tv_tarifa);
        pesoTView = findViewById(R.id.activity_resultado_tv_peso);
        decoracionTView = findViewById(R.id.activity_resultado_tv_decoracion);
        costeFinalTView = findViewById(R.id.activity_resultado_tv_coste_final);

        zonaTView.setText(obtenerZona(pedido));
        tarifaTView.setText(obtenerTarifa(pedido));
        decoracionTView.setText(obtenerDecoracion(pedido));
        pesoTView.setText(obtenerPeso(pedido));
        costeFinalTView.setText(obtenerCoste(pedido));
    }

    private String obtenerTarifa(Pedido pedido) {
        int tarifa;

        switch (pedido.getTarifa()) {
            case 0:
                tarifa = R.string.activity_resultado_tarifa_normal;
                break;
            case 1:
                tarifa = R.string.activity_resultado_tarifa_urgente;
                break;
            default:
                tarifa = R.string.activity_resultado_tarifa_normal;
        }

        return String.format(getResources().getString(R.string.activity_resultado_tarifa),
                getResources().getString(tarifa));
    }

    private String obtenerZona(Pedido pedido) {
        Destino destino = pedido.getDestino();

        return String.format(getResources().getString(R.string.activity_resultado_zona),
                destino.getZona(), destino.getContientes());
    }

    private String obtenerDecoracion(Pedido pedido) {
        String decoracion;

        boolean conCajaRegalo = pedido.isConCaja();
        boolean conTarjetaDedicatoria = pedido.isConTarjeta();

        /*
         * A partir de aqui se utiliza el String.format para crear una string no dependiende del
         * lenguaje del desarrollador, ya que utiliza los recursos String que dependen del lenguaje
         * del sistema o de la configuración de la aplicación si asi es desarrollada.
         * */
        if (!conCajaRegalo && !conTarjetaDedicatoria) {
            /*
             * Si no hay ninguna ninguna dedicatoria, la variable String decoración almacenará el
             * texto "Decoración: Sin decoración.", reemplazando el %s por "Sin decoración".
             */
            decoracion = String.format(
                    getResources().getString(R.string.activity_resultado_decoracion),
                    getResources().getString(R.string.activity_resultado_decoracion_ninguna)
            );
        } else {
            /*
             * Si hay alguna decoración pero antes de especificar cual o cuales, la String
             * decoracion contendra el texto "Decoración: Con %s." donde el %s original es
             * reemplazado por "Con %s". El nuevo %s se utilizará despues para especificar que
             * decoraciones tiene el pedido.
             */
            decoracion = String.format(
                    getResources().getString(R.string.activity_resultado_decoracion),
                    getResources().getString(R.string.activity_resultado_decoracion_alguna)
            );


            if (conCajaRegalo && conTarjetaDedicatoria) {
                /*
                 * Si tiene tanto la caja regalo como la tarjeta dedicatoria, la String decoracion
                 * devolvera "Decoración: Con caja regalo y tarjeta dedicatoria.".
                 */
                decoracion = String.format(
                        decoracion,
                        getResources().getString(R.string.activity_resultado_decoracion_regalo)
                                + " " + getResources().getString(
                                R.string.activity_resultado_decoracion_ambas)
                                + " " + getResources().getString(
                                R.string.activity_resultado_decoracion_dedicatoria)
                );
            }
            else if(conCajaRegalo) {
                /*
                 * Si solo tiene la la caja regalo, la String decoracion
                 * devolvera "Decoración: Con caja regalo.".
                 */
                decoracion = String.format(decoracion,
                        getResources().getString(R.string.activity_resultado_decoracion_regalo)
                );
            } else {
                /*
                 * Como el último caso es cuando solo tiene la tarjeta dedicatoria, el resultado de
                 * String decoracion es "Decoración: Con tarjeta dedicatoria.".
                 */
                decoracion = String.format(
                        decoracion,
                        getResources().getString(R.string.activity_resultado_decoracion_dedicatoria)
                );
            }
        }

        return decoracion;
    }

    private String obtenerPeso(Pedido pedido) {
        peso = pedido.getPeso();

        return String.format(getResources().getString(R.string.activity_resultado_peso), peso);
    }

    private String obtenerCoste(Pedido pedido) {
        double costeZona;
        double costeVariablePeso;
        double costeFijoPeso;
        double precioFinal;
        double incrementoTarifa;
        String coste;

        switch (zona) {
            case 0:
                costeZona = 30;
                break;
            case 1:
                costeZona = 20;
                break;
            case 2:
                costeZona = 10;
                break;
            default:
                costeZona = 30;
        }

        if (peso < 6) {
            costeVariablePeso = 1;
        } else if (peso > 10) {
            costeVariablePeso = 2;
        } else {
            costeVariablePeso = 1.5;
        }
        costeFijoPeso = peso * costeVariablePeso;

        incrementoTarifa = pedido.getTarifa() == 1 ? 0.3 : 0;

        precioFinal = costeZona + peso * costeFijoPeso + (costeZona + costeFijoPeso)
                * incrementoTarifa;

        coste = String.format(getResources().getString(R.string.activity_resultado_coste), precioFinal,
                costeZona, costeVariablePeso, peso, costeZona + costeFijoPeso, incrementoTarifa);

        return coste;
    }
}
