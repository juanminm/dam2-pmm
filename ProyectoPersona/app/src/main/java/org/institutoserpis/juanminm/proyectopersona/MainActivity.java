package org.institutoserpis.juanminm.proyectopersona;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static String NOMBRE = "org.institutoserpis.juanminm.proyectopersona.NOMBRE";
    final static String APELLIDOS = "org.institutoserpis.juanminm.proyectopersona.APELLIDOS";
    final static String SEXO = "org.institutoserpis.juanminm.proyectopersona.SEXO";

    private Persona[] datos = new Persona[]{
            new Persona("Jorge", "Rodrigo Anchon", 32, 'h'),
            new Persona("Maria", "Sanchez Estela", 25, 'm'),
            new Persona("Sergio", "Lopez Vela", 27, 'h')
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorPersonas adaptador = new AdaptadorPersonas(this);
        ListView lstOpciones = (ListView) findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);


        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendInfoToActivity(datos[position]);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void sendInfoToActivity(Persona persona) {
        Intent intent = new Intent(this, SaludoActivity.class);
        Bundle bundle = new Bundle();

//        bundle.putString(NOMBRE, persona.getNombre());
//        bundle.putString(APELLIDOS, persona.getApellidos());
//        bundle.putChar(SEXO, persona.getSexo());
        bundle.putSerializable("PERSONA", persona);

        intent.putExtras(bundle);

        startActivity(intent);
    }

    class AdaptadorPersonas extends ArrayAdapter {
        Activity context;

        AdaptadorPersonas(Activity context) {
            super(context, R.layout.listitem_persona, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_persona, null);

            TextView lblNombre = item.findViewById(R.id.tvNombre);
            lblNombre.setText(datos[i].getNombre());

            TextView lblApellidos = item.findViewById(R.id.tvApellidos);
            lblApellidos.setText(datos[i].getApellidos());

            TextView lblEdad = item.findViewById(R.id.tvEdad);
            lblEdad.setText(Integer.toString(datos[i].getEdad()));

            return item;
        }
    }
}
