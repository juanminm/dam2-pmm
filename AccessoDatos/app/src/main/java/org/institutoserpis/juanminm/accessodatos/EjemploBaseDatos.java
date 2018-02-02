package org.institutoserpis.juanminm.accessodatos;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class EjemploBaseDatos extends AppCompatActivity {

    Spinner clientesSpinner;
    private int mStackPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_base_datos);

        ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this, "DBClientes", null, 1);

        SQLiteDatabase db = cliBDh.getWritableDatabase();

        if (db != null) {
            for (int cont = 1; cont <= 3; cont++) {
                int codigo = cont;
                String nombre = "Cliente" + cont;
                String telefono = cont + "XXXXXXX";

                db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) "
                        + "VALUES ('" + codigo + "', '" + nombre + "', '" + telefono + "')");
            }
//
//            //Insertar un registro
//            db.execSQL("INSERT INTO Clientes (nombre, telefono) VALUES ('cli1','11111') ");
//            //Actualizar un registro
//            db.execSQL("UPDATE Clientes SET telefono='00000' WHERE nombre='cli1' ");
//            //Eliminar un registro
//            db.execSQL("DELETE FROM Clientes WHERE nombre='cli1' ");
//
//            //Ejemplo de utilización del método insert()
//            //Creamos el registro que queremos insertar utilizando un objeto ContentValues
//            ContentValues nuevoRegistro = new ContentValues();
//            nuevoRegistro.put("nombre", "cli10");
//            nuevoRegistro.put("telefono", "101010");
//            //Insertamos el registro en la base de datos
//            //El primer parámetro es el nombre de la tabla donde insertaremos.
//            //El segundo parámetro solo sirve en caso de introducir un registro vacio
//            //El tercer paráemtro es el objeto ContentValues que contiene el registro a insertar
//            db.insert("Clientes", null, nuevoRegistro);
//
//            //Ejemplo de utilización del método update()
//            //Establecemos los campos-valores que vamos a actualizar
//            ContentValues valores = new ContentValues();
//            valores.put("telefono", "101010XX");
//
//            //Actualizamos el registro en la base de datos
//            //El tercer argumento es la condición del UPDATE tal como lo haríamos en la cláusula
//            //WHERE en una sentencia SQL normal.
//            //El cuarto argumento son partes variables de la sentencia SQL que aportamos en un
//            vector de valores aparte
//            String[] args = new String[]{"cli1", "cli2"};
//            db.update("Clientes", valores, "nombre=? OR nombre=?", args);
//
//            //Ejemplo de utilización del método delete()
//            //Eliminamos el registro del cliente 'cli2'
//            String[] args2 = new String[]{"cli2"};
//            db.delete("Clientes", "nombre=?", args2);
//
//            //Ejemplo Select
//            String[] args3 = new String[]{"cli1"};
//            Cursor c = db.rawQuery("SELECT nombre,telefono FROM Clientes WHERE nombre=? ", args3);
//
//            //Ejemplo Select2
            String[] campos = new String[]{"nombre", "telefono"};
            String[] args4 = new String[]{"cli1"};
            Cursor c = db.query("Clientes", campos, null, null, null, null, null);
            //Cursor c = db.rawQuery("SELECT nombre, telefono FROM Clientes", null);
            final ArrayList<Cliente> clientes = new ArrayList<>();

            //Nos aseguramos de que exista al menos un registro
            if (c.moveToFirst()) {
                //Recorremos el cursor hasta que no haya más registros
                do {
                    clientes.add(new Cliente(c.getString(0), c.getString(1)));
                } while (c.moveToNext());
            }

            c.close();

            clientesSpinner = findViewById(R.id.activity_ejemplo_base_datos_sp_clientes);
            ClienteAdapter adapter = new ClienteAdapter(this, clientes.toArray(new Cliente[clientes.size()]));
            clientesSpinner.setAdapter(adapter);

            clientesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView parent, View view, int position, long id) {
                    Toast.makeText(EjemploBaseDatos.this, "Item clicked => " + clientes.get(position), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });

            //Cerramos la base de datos
            db.close();
        } //del if
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_opt_insertar_registro:

        }
    }

    void addFragment() {
        mStackPosition++;
        // Instanciamos nuevo Fragment
        Fragment newFragment = SimpleFragment.newInstance(mStackPosition);
        // Se aÃ±ade el Fragment a la actividad
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentShow, newFragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);// poneos la transacion a la pila
        ft.commit();
    }

    public showDialogFragment(InsertarRegistroFragment dialogFragment) {
        dialogFragment = InsertarRegistroFragment.newInstance();
        dialogFragment.show(getFragmentManager(), "dialog");
    }

}