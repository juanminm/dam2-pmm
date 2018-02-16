package org.institutoserpis.juanminm.proyectofinal;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;


public class MarketFragment extends Fragment {

    private static final String PLAYER = "PLAYER";

    TabHost tabHost;
    ListView sellersLView;
    ListView buyersLView;
    List<Market> marketSellList;
    List<Market> marketBuyList;
    Player currentPlayer;

    static MarketFragment newInstance(Player player) {
        MarketFragment f = new MarketFragment();
        Bundle args = new Bundle();
        args.putSerializable(PLAYER, player);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabaseHelper dbHelper = new DatabaseHelper(getContext());
        Cursor cursor;

        currentPlayer = (Player) getArguments().getSerializable(PLAYER);
        marketSellList = new ArrayList<>();
        marketBuyList = new ArrayList<>();

        dbHelper.open();
        cursor = dbHelper.getItems(
                Globals.TABLE_MARKET_NAME,
                null,
                null,
                null,
                null
        );

        while(cursor.moveToNext()) {
            long marketId = cursor.getLong(0);
            long itemId = cursor.getLong(2);
            int quantity = cursor.getInt(3);
            double price = cursor.getDouble(4);
            int type = cursor.getInt(5);
            Player player;
            Item item;
            Cursor playerCursor;
            Cursor itemCursor;

            playerCursor = dbHelper.getItems(
                    Globals.TABLE_PLAYER_NAME,
                    new String[]{
                            Globals.TABLE_PLAYER_FIELD_ID,
                            Globals.TABLE_PLAYER_FIELD_NAME,
                            Globals.TABLE_PLAYER_FIELD_MONEY
                    },
                    "id = ?",
                    new String[]{Long.toString(itemId)},
                    null);

            playerCursor.moveToFirst();
            player = new Player(playerCursor.getLong(0), playerCursor.getString(1),
                    playerCursor.getDouble(2));
            playerCursor.close();

            itemCursor = dbHelper.getItems(
                    Globals.TABLE_ITEM_NAME,
                    null,
                    "id = ?",
                    new String[]{Long.toString(itemId)},
                    null);

            itemCursor.moveToFirst();
            item = new Item(itemCursor.getLong(0), itemCursor.getString(1));
            itemCursor.close();

            Market marketItem = new Market(marketId, player, item, quantity, price, type);


            if (marketItem.getType() == Market.MARKET_TYPE_SELL)
                marketSellList.add(marketItem);
            else
                marketBuyList.add(marketItem);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_market, container, false);
        MarketAdapter marketBuyAdapter;
        MarketAdapter marketSellAdapter;

        tabHost = v.findViewById(R.id.tabhost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("Sellers").setContent(R.id.Sellers).setIndicator("Sellers"));
        tabHost.addTab(tabHost.newTabSpec("Buyers").setContent(R.id.Buyers).setIndicator("Buyers"));

        marketBuyAdapter = new MarketAdapter(v.getContext(), marketBuyList);
        buyersLView = v.findViewById(R.id.fragment_market_lv_buyorders);
        buyersLView.setAdapter(marketBuyAdapter);

        marketSellAdapter = new MarketAdapter(v.getContext(), marketSellList);
        sellersLView = v.findViewById(R.id.fragment_market_lv_sellorders);
        sellersLView.setAdapter(marketSellAdapter);

        registerForContextMenu(buyersLView);
        registerForContextMenu(sellersLView);

        buyersLView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView , View v,int position, long id) {
                disableMenuItemOnSamePlayer(adapterView, position);
                return true;
            }
        });

        sellersLView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View v, int position, long id) {
                disableMenuItemOnSamePlayer(adapterView, position);
                return true;
            }
        });

        return v;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getActivity().getMenuInflater();

        switch (v.getId()) {
            case R.id.fragment_market_lv_buyorders:
                inflater.inflate(R.menu.menu_buyers_list, menu);
                break;
            case R.id.fragment_market_lv_sellorders:
                inflater.inflate(R.menu.menu_sellers_list, menu);
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        return true;
    }

    public void disableMenuItemOnSamePlayer(AdapterView<?> adapterView, int position) {
        if (currentPlayer != ((Market) adapterView.getItemAtPosition(position)).getPlayer())
            adapterView.showContextMenu();
    }
}
