package org.institutoserpis.juanminm.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * @author Juan Miguel Navarro Martínez
 */

class MarketAdapter extends ArrayAdapter<Market> {
    public Context context;
    public List<Market> market;


    public MarketAdapter(Context context, List<Market> market) {
        super(context, R.layout.adapter_market, market);
        this.context = context;
        this.market = market;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        ViewHolder holder = new ViewHolder();
        String[] columns = {Globals.TABLE_ITEM_FIELD_NAME};
        String[] selArgs = {Long.toString(market.get(position).getItem().getId())};
        String itemName = "";
        Cursor cursor;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_market, parent, false);
            holder.itemTextView = convertView.findViewById(R.id.adapter_market_tv_item);
            holder.quantityTextView = convertView.findViewById(R.id.adapter_market_tv_units);
            holder.priceUnitTextView = convertView.findViewById(R.id.adapter_market_tv_price);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        dbHelper.open();
        cursor = dbHelper.getItems(Globals.TABLE_ITEM_NAME, columns, "id = ?", selArgs, null);
        if (cursor.moveToNext())
            itemName = cursor.getString(0);
        dbHelper.close();
        holder.itemTextView.setText(itemName);
        holder.quantityTextView.setText(String.format(Locale.getDefault(), "%d units",
                market.get(position).getUnits()));
        holder.priceUnitTextView.setText(String.format(Locale.getDefault(), "%.2fcr",
                market.get(position).getPriceUnit()));

        return convertView;
    }

    static class ViewHolder {
        TextView itemTextView;
        TextView quantityTextView;
        TextView priceUnitTextView;
    }
}
