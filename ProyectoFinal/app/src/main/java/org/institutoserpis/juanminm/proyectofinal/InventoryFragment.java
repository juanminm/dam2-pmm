package org.institutoserpis.juanminm.proyectofinal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.opengles.GL;

/**
 * @author Juan Miguel Navarro Martínez
 */


public class InventoryFragment extends Fragment {
    private static final String PLAYER = "player";

    List<Inventory> inventoryList;

    static InventoryFragment newInstance(Player player) {
        InventoryFragment f = new InventoryFragment();
        Bundle args = new Bundle();
        args.putSerializable(PLAYER, player);// Mantenemos el numero para usarlo en cualquier momento.
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Player player = (Player) getArguments().getSerializable(PLAYER);

        if (player != null) {
            DatabaseHelper dbHelper = new DatabaseHelper(this.getContext());
            Cursor cursor;
            inventoryList = new ArrayList<>();

            dbHelper.open();
            cursor = dbHelper.getItems(
                    Globals.TABLE_INVENTORY_NAME,
                    new String[]{
                            Globals.TABLE_INVENTORY_FIELD_ID,
                            Globals.TABLE_INVENTORY_FIELD_PLAYER,
                            Globals.TABLE_INVENTORY_FIELD_ITEM,
                            Globals.TABLE_INVENTORY_FIELD_QUANTITY
                    },
                    "player_id = ?",
                    new String[]{Long.toString(player.getId())},
                    null);

            while (cursor.moveToNext()) {
                Inventory inventory = new Inventory(cursor.getLong(0), cursor.getLong(1),
                        cursor.getLong(2), cursor.getInt(3));
                inventoryList.add(inventory);
            }
            dbHelper.close();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inventory, container, false);

        ListView lv = v.findViewById(R.id.fragment_inventory_lv_itemlist);
        InventoryAdapter inventoryAdapter = new InventoryAdapter(v.getContext(), inventoryList);
        lv.setAdapter(inventoryAdapter);

        return v;
    }
}
