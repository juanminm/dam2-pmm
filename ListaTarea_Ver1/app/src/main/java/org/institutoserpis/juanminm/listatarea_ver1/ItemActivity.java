package org.institutoserpis.juanminm.listatarea_ver1;

import android.app.Activity;
import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
// obtener referencias
        mName = (TextView) findViewById(R.id.name);
        mGender = (TextView) findViewById(R.id.gender);
        mBirthDate = (TextView) findViewById(R.id.birth_date);
        mNationality = (TextView) findViewById(R.id.nationality);
        mCity = (TextView) findViewById(R.id.city);
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

    private void showMessage(int message){
        Context context = getApplicationContext();
        CharSequence text = getResources().getString(message);
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
