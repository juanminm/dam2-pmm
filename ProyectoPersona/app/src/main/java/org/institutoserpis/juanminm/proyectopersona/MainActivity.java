package org.institutoserpis.juanminm.proyectopersona;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final static String NOMBRE = "org.institutoserpis.juanminm.proyectopersona.NOMBRE";
    final static String APELLIDOS = "org.institutoserpis.juanminm.proyectopersona.APELLIDOS";
    final static String SEXO = "org.institutoserpis.juanminm.proyectopersona.SEXO";

    private Persona[] datos = new Persona[1000];

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (Button)findViewById(R.id.boton);

        registerForContextMenu(boton);

        for (int i = 0; i < datos.length; i++) {
            Random random = new Random();

            if (random.nextFloat() < 0.5f)
                datos[i] = new Persona("Jorge", "Huerto Gazcon", i, "h");
            else
                datos[i] = new Persona("Maria", "Suarez Mendoza", i, "m");
        }

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

    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc2:
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.SubMnuOpc1:
                Toast.makeText(this, "Submenu: Opción 1", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.SubMnuOpc2:
                Toast.makeText(this, "Submenu: Opción 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc3:
                Intent intent = new Intent(this, AcercaDeActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
    }

    public boolean onContextItemSelected(MenuItem itemMnuContex) {
        switch (itemMnuContex.getItemId()) {
            case R.id.CtxLblOpc1:
                Toast.makeText(this, "Opcion 1 pulsada!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.CtxLblOpc2:
                Toast.makeText(this, "Opcion 2 pulsada!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(itemMnuContex);
        }
    }

    private void sendInfoToActivity(Persona persona) {
        Intent intent = new Intent(this, SaludoActivity.class);
        Bundle bundle = new Bundle();

        //bundle.putString(NOMBRE, persona.getNombre());
        //bundle.putString(APELLIDOS, persona.getApellidos());
        //bundle.putChar(SEXO, persona.getSexo());
        //bundle.putSerializable("PERSONA");
        bundle.putParcelable("PARCEL", persona);

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
            View item = convertView;
            ViewHolder holder;

            if (item == null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.listitem_persona, null);
                holder = new ViewHolder();
                holder.nombre = item.findViewById(R.id.tvNombre);
                holder.apellidos = item.findViewById(R.id.tvApellidos);
                holder.edad = item.findViewById(R.id.tvEdad);
                item.setTag(holder);
            } else {
                holder = (ViewHolder)item.getTag();
            }

            holder.nombre.setText(datos[i].getNombre());
            holder.apellidos.setText(datos[i].getApellidos());
            holder.edad.setText(Integer.toString(datos[i].getEdad()));

            /*
             * comprtu
             */
            if (datos[i].getSexo().equals("h"))
                item.setBackgroundResource(R.color.hombre);
            else
                item.setBackgroundResource(R.color.mujer);


            return item;
        }
    }

    static class ViewHolder{
        TextView nombre;
        TextView apellidos;
        TextView edad;
    }
}
