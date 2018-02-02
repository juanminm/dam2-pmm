package org.institutoserpis.juanminm.accessodatos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class InsertarRegistroFragment extends DialogFragment {
    public static InsertarRegistroFragment newInstance(String valor) {
        InsertarRegistroFragment frag = new InsertarRegistroFragment();
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
        ViewGroup dlgview = (ViewGroup) inflater.inflate(R.layout.fragment_insertar_registro, null);
        // botÃ³n nuevo Fragment
        Button buttonShow = dlgview.findViewById(
                R.id.fragment_insertar_registro_btn_añadir);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((EjemploBaseDatos) getActivity()).addFragment();
            }
        });
        // botÃ³n cancelar
        Button buttonCancel = dlgview.findViewById(
                R.id.fragment_insertar_registro_btn_cancelar);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dismiss();
            }
        });
        // botÃ³n ir a Fragment anterior

        return new AlertDialog.Builder(getActivity()).setView(dlgview).create();
    }
}
