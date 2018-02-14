package org.institutoserpis.juanminm.examen2ev;

import android.app.Fragment;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;


public class ItemFragment extends Fragment {
    //referencias a elementos de pantalla
    TextView mItem = null;
    TextView mPlace = null;
    TextView mDescription = null;
    TextView mImportance = null;
    //identificador de entrada
    Integer mRowId = null;

    static ItemFragment newInstance(int number) {
        ItemFragment f = new ItemFragment();
        Bundle args = new Bundle();
        args.putInt("id", number);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRowId = getArguments().getInt("id");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.detail_item, container, false);

        mItem = (TextView) v.findViewById(R.id.item);
        mPlace = (TextView) v.findViewById(R.id.place);
        mDescription  = (TextView) v.findViewById(R.id.description);
        mImportance  = (TextView) v.findViewById(R.id.importance);
        //identificador visible o no
        TableRow tr = (TableRow) v.findViewById(R.id.idRow);
        if (mRowId!=null){
            tr.setVisibility(View.VISIBLE);
            populateFieldsFromDB(v);
        }
        else{
            tr.setVisibility(View.GONE);
        }

        populateFieldsFromDB(v);

        return v;
    }

    private void populateFieldsFromDB(View v) {
        try {
            MainActivity.mDbHelper.open();
            Cursor c = MainActivity.mDbHelper.getItem(mRowId.intValue());
            if (c.moveToFirst()) {
                //diferentes maneras de obtener los datos del cursor
                //Mediante nombre de columna y lanza excepción si no existe
                mItem.setText(c.getString(c.getColumnIndexOrThrow(DataBaseHelper.SL_ITEM)));
                //Mediante nombre de columna y devuelve -1 si no existe
                mPlace.setText(c.getString(c.getColumnIndex(DataBaseHelper.SL_PLACE)));
                //Mediante posición del campo en el cursor
                mDescription.setText(c.getString(2));
                mImportance.setText(Integer.toString(c.getInt(3)));
                TextView id = (TextView) v.findViewById(R.id.identificator);
                id.setText(Integer.toString(c.getInt(4)));
            }
            c.close();
            MainActivity.mDbHelper.close();
        } catch (SQLException e) {
            e.printStackTrace();
            //showMessage(R.string.dataError);
        }
    }
}
