package org.institutoserpis.juanminm.listatarea_ver1;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity{
    //acciones
    public static final int NEW_ITEM = 1;
    public static final int EDIT_ITEM = 2;
    public static final int SHOW_ITEM = 3;

    //elemento seleccionado
    private int mLastRowSelected = 0;
    public static DataBaseHelper mDbHelper = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // abrir la base de datos
        mDbHelper = new DataBaseHelper(this);
        try {
            fillData();
        } catch (SQLException e) {
            showMessage(R.string.dataError);
        }
//        Button botonIni=(Button)findViewById(R.id.BotonPrincipal);
//        botonIni.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Intent intent = new Intent (MainActivity.this, ItemActivity.class);
//                startActivityForResult(intent, NEW_ITEM);
//            }
//
//
//        });
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void fillData() {
        // se abre la base de datos y se obtienen los elementos
        mDbHelper.open();
        Cursor itemCursor = mDbHelper.getItems();
        Persona item = null;
        ArrayList<Persona> resultList = new ArrayList<Persona>();
        // se procesa el resultado
        while (itemCursor.moveToNext()) {
            int id = itemCursor.getInt(itemCursor.getColumnIndex(DataBaseHelper.SL_ID));
            String name = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_NAME));
            String gender = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_GENDER));
            String birthDate = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_BIRTH_DATE));
            String nationality = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_NATIONALITY));
            String city = itemCursor.getString(itemCursor.getColumnIndex(DataBaseHelper.SL_CITY));
            item = new Persona();
            item.id = id;
            item.name = name;
            item.gender = gender;
            item.birthDate = birthDate;
            item.nationality = nationality;
            item.city = city;
            resultList.add(item);
        }
        //cerramos la base de datos
        itemCursor.close();
        mDbHelper.close();
        //se genera el adaptador
        TaskAdapter items = new TaskAdapter(this, R.layout.row_list, resultList, getLayoutInflater());
        //asignar adaptador a la lista
        setListAdapter(items);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.new_item:
                Intent intent = new Intent (this,ItemActivity.class);
                startActivityForResult(intent, NEW_ITEM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private class TaskAdapter extends ArrayAdapter<Persona> {
        private LayoutInflater mInflater;
        private List<Persona> mObjects;

        private TaskAdapter(Context context, int resource, List<Persona> objects, LayoutInflater mInflater) {
            super(context, resource, objects);
            this.mInflater = mInflater;
            this.mObjects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Persona persona = mObjects.get(position);
            // obtención de la vista de la línea de la tabla
            View row = mInflater.inflate(R.layout.row_list, null);
            //rellenamos datos
            TextView name = (TextView) row.findViewById(R.id.row_name);
            TextView birthDate = (TextView) row.findViewById(R.id.row_birthdate);
            TextView nationality = (TextView) row.findViewById(R.id.row_nationality);
            TextView city = (TextView) row.findViewById(R.id.row_city);
            name.setText(persona.name);
            birthDate.setText(persona.birthDate);
            nationality.setText(persona.nationality);
            city.setText(persona.city);

            // dependiendo de la importancia, se muestran distintos iconos
            ImageView icon = (ImageView) row.findViewById(R.id.row_gender);
            icon.setTag(persona.id);
            switch (persona.gender) {
                case "hombre":
                    icon.setImageResource(R.drawable.ic_green);
                    break;
                default:
                    icon.setImageResource(R.drawable.ic_red);
                    break;
            }
            return row;
        }
    }
    private class Persona {
        int id;
        String name;
        String gender;
        String birthDate;
        String nationality;
        String city;
    }

}