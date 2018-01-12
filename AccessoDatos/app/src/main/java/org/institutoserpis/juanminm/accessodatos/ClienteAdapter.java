package org.institutoserpis.juanminm.accessodatos;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by juamar on 12/01/18.
 */

public class ClienteAdapter extends ArrayAdapter<Cliente> {
    public Activity context;
    public Cliente[] clientes;

    public ClienteAdapter(Activity context, Cliente[] clientes) {
        super(context, R.layout.adapter_cliente, clientes);
        this.context = context;
        this.clientes = clientes;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.adapter_cliente, null);

        TextView nombreTextView = view.findViewById(R.id.adapter_cliente_tv_nombre);
        TextView telefonoTextView = view.findViewById(R.id.adapter_cliente_tv_telefono);

        nombreTextView.setText(clientes[position].getNombre());
        telefonoTextView.setText(clientes[position].getTelefono());

        return view;
    }

}