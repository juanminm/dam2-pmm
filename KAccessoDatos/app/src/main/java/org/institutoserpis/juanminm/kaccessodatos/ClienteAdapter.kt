package org.institutoserpis.juanminm.kaccessodatos

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

/**
 * Created by juamar on 16/01/18.
 */
class ClienteAdapter(var context: Activity, var clientes: Array<Cliente>) :
        ArrayAdapter<Cliente>(context, R.layout.adapter_cliente, clientes) {

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.layoutInflater
        val view = inflater.inflate(R.layout.adapter_cliente, null)

        val nombreTextView = view.findViewById<TextView>(R.id.adapter_cliente_tv_nombre)
        val telefonoTextView = view.findViewById<TextView>(R.id.adapter_cliente_tv_telefono)

        nombreTextView.text = clientes[position].nombre;
        telefonoTextView.text = clientes[position].telefono;

        return view
    }
}