package org.institutoserpis.juanminm.pruebaexamen;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Juanmi on 2017-11-16.
 */

public class DestinoAdapter extends ArrayAdapter<Destino> {
    private Activity context;
    private Destino[] destinos;

    public DestinoAdapter(Activity context, Destino[] destinos) {
        super(context, R.layout.listitem_destino, destinos);
        this.context = context;
        this.destinos = destinos;
    }

    public View getView(int i, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;

        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            //item = inflater.inflate(R.layout.listitem_destino, null);
            view = inflater.inflate(R.layout.listitem_destino, null);

            holder = new ViewHolder();
            holder.zona = view.findViewById(R.id.listitem_destino_tv_zona);
            holder.continentes = view.findViewById(R.id.listitem_destino_tv_continentes);
            holder.precio = view.findViewById(R.id.listitem_destino_tv_precio);
            view.setTag(holder);
        } else {
            holder = (ViewHolder)view.getTag();
        }

        holder.zona.setText(destinos[i].getZona());
        holder.continentes.setText(destinos[i].getContientes());
        holder.precio.setText(Double.toString(destinos[i].getPrecio()));

        return view;
    }

    @Override
    public View getDropDownView(final int position, View convertView, final ViewGroup parent) {
        final View view = getView(position, convertView, parent);

        return  view;
    }

    static class ViewHolder {
        TextView zona;
        TextView continentes;
        TextView precio;
    }
}