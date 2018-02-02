package org.institutoserpis.juanminm.listatarea_ver2;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity {
    //referencias a elementos de pantalla
    TextView mName = null;
    TextView mGender = null;
    TextView mBirthDate = null;
    TextView mNationality = null;
    TextView mCity = null;
    //identificador de entrada
    Integer mRowId = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //obtención de extras, identificador y acción
        Bundle extras = getIntent().getExtras();
        mRowId = (savedInstanceState == null) ? null :
                (Integer) savedInstanceState.getSerializable(DataBaseHelper.SL_ID);
        if (mRowId == null) {
            mRowId = extras != null ? extras.getInt(DataBaseHelper.SL_ID): null;
        }
        // es solo para visualizar?
        if (extras != null && extras.getInt("action")== MainActivity.SHOW_ITEM) {
            setContentView(R.layout.detail_item);
        }
        else{
            setContentView(R.layout.new_item);
            //botón de salvar
            Button saveBtn = (Button) findViewById(R.id.add);
            saveBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    setResult(RESULT_OK);
                    saveData();
                    finish();
                }
            });
        }
// obtener referencias
        mName = (TextView) findViewById(R.id.name);
        mGender = (TextView) findViewById(R.id.gender);
        mBirthDate = (TextView) findViewById(R.id.birth_date);
        mNationality = (TextView) findViewById(R.id.nationality);
        mCity = (TextView) findViewById(R.id.city);
        //identificador visible o no
        TableRow tr = (TableRow) findViewById(R.id.idRow);
        if (mRowId!=null){
            tr.setVisibility(View.VISIBLE);
            populateFieldsFromDB();
        }
        else{
            tr.setVisibility(View.GONE);
        }
    }
    protected void saveData() {
//obtener datos
        String nameText = mName.getText().toString();
        String genderText = mGender.getText().toString();
        String birthDateText = mBirthDate.getText().toString();
        String nationalityText = mNationality.getText().toString();
        String cityText = mCity.getText().toString();
        //insertar
        try{
            MainActivity.mDbHelper.open();
            MainActivity.mDbHelper.insertItem(nameText, genderText, birthDateText, nationalityText,
                    cityText);
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            showMessage(R.string.dataError);
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void populateFieldsFromDB() {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(mRowId.intValue());
            if (c.moveToFirst()) {
                //diferentes maneras de obtener los datos del cursor
                //Mediante nombre de columna y lanza excepción si no existe
                mName.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_NAME)));
                //Mediante nombre de columna y devuelve -1 si no existe
                mGender.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_GENDER)));
                mBirthDate.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_BIRTH_DATE)));
                mNationality.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_NATIONALITY)));
                mCity.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_CITY)));
                TextView id = (TextView) findViewById(R.id.identificator);
                id.setText(Integer.toString(c.getInt(4)));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            showMessage(R.string.dataError);
        }
    }

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
