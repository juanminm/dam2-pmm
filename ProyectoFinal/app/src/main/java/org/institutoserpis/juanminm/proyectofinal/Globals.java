package org.institutoserpis.juanminm.proyectofinal;

/**
 * Created by juamar on 2/02/18.
 */

final class Globals {
    // Database settings
    static final String DATABASE_NAME = "GameMarket";
    static final int DATABASE_VERSION = 1;

    // Table Player
    static final String TABLE_PLAYER_NAME = "player";
    static final String TABLE_PLAYER_FIELD_ID = "id";
    static final String TABLE_PLAYER_FIELD_NAME = "name";
    static final String TABLE_PLAYER_FIELD_PASSWORD = "password";
    static final String TABLE_PLAYER_FIELD_MONEY = "money";

    // Table Items
    static final String TABLE_ITEM_NAME = "item";
    static final String TABLE_ITEM_FIELD_ID = "id";
    static final String TABLE_ITEM_FIELD_NAME = "name";

    // Table Inventory
    static final String TABLE_INVENTORY_NAME = "inventory";
    static final String TABLE_INVENTORY_FIELD_PLAYER = "player_id";
    static final String TABLE_INVENTORY_FIELD_ITEM = "item_id";
    static final String TABLE_INVENTORY_FIELD_QUANTITY = "quantity";

    // Table Market
    static final String TABLE_MARKET_NAME = "market";
    static final String TABLE_MARKET_FIELD_ID = "id";
    static final String TABLE_MARKET_FIELD_PLAYER = "player_id";
    static final String TABLE_MARKET_FIELD_ITEM = "item_id";
    static final String TABLE_MARKET_FIELD_UNITS = "units";
    static final String TABLE_MARKET_FIELD_PRICE_UNIT = "price_unit";
    static final String TABLE_MARKET_FIELD_TYPE = "type";

    // CREATE Queries
    static final String CREATE_TABLE_PLAYER = String.format(
            "CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s DOUBLE NOT NULL)",
            TABLE_PLAYER_NAME,
            TABLE_PLAYER_FIELD_ID,
            TABLE_PLAYER_FIELD_NAME,
            TABLE_PLAYER_FIELD_PASSWORD,
            TABLE_PLAYER_FIELD_MONEY
    );

    static final String CREATE_TABLE_ITEM = String.format(
            "CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY, " +
                    "%s TEXT NOT NULL)",
            TABLE_ITEM_NAME,
            TABLE_ITEM_FIELD_ID,
            TABLE_ITEM_FIELD_NAME
    );

    static final String CREATE_TABLE_INVENTORY = String.format(
            "CREATE TABLE %s (" +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL)",
            TABLE_INVENTORY_NAME,
            TABLE_INVENTORY_FIELD_PLAYER,
            TABLE_PLAYER_NAME,
            TABLE_PLAYER_FIELD_ID,
            TABLE_INVENTORY_FIELD_ITEM,
            TABLE_ITEM_NAME,
            TABLE_ITEM_FIELD_ID,
            TABLE_INVENTORY_FIELD_QUANTITY

    );

    static final String CREATE_TABLE_MARKET = String.format(
            "CREATE TABLE %s (" +
                    "%s INTEGER NOT NULL, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL, " +
                    "%s DOUBLE NOT NULL, " +
                    "%s TEXT TYPE)",
            TABLE_MARKET_NAME,
            TABLE_MARKET_FIELD_ID,
            TABLE_MARKET_FIELD_PLAYER,
            TABLE_PLAYER_NAME,
            TABLE_PLAYER_FIELD_ID,
            TABLE_MARKET_FIELD_ITEM,
            TABLE_ITEM_NAME,
            TABLE_ITEM_FIELD_ID,
            TABLE_MARKET_FIELD_UNITS,
            TABLE_MARKET_FIELD_PRICE_UNIT,
            TABLE_MARKET_FIELD_TYPE
    );
}
