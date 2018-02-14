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

public class InventoryAdapter extends ArrayAdapter<Inventory> {
    public Context context;
    public List<Inventory> inventory;


    public InventoryAdapter(Context context, List<Inventory> inventory) {
        super(context, R.layout.adapter_inventory, inventory);
        this.context = context;
        this.inventory = inventory;
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        ViewHolder holder = new ViewHolder();
        String[] columns = {Globals.TABLE_ITEM_FIELD_NAME};
        String[] selArgs = {Long.toString(inventory.get(position).getItemId())};
        String itemName = "";
        Cursor cursor;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.adapter_inventory, parent, false);
            holder.itemTextView = convertView.findViewById(R.id.adapter_inventory_tv_item);
            holder.quantityTextView = convertView.findViewById(R.id.adapter_inventory_tv_quantity);
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
        holder.quantityTextView.setText(String.format(Locale.getDefault(), "%d",
                inventory.get(position).getQuantity()));

        return convertView;
    }

    static class ViewHolder {
        TextView itemTextView;
        TextView quantityTextView;
    }

}