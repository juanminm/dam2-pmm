package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */


public final class Globals {
    // Database settings
    public static final String DATABASE_NAME = "GameMarket.db";
    public static final int DATABASE_VERSION = 1;

    // Table Player
    public static final String TABLE_PLAYER_NAME = "player";
    public static final String TABLE_PLAYER_FIELD_ID = "id";
    public static final String TABLE_PLAYER_FIELD_NAME = "name";
    public static final String TABLE_PLAYER_FIELD_PASSWORD = "password";
    public static final String TABLE_PLAYER_FIELD_MONEY = "money";

    // Table Items
    public static final String TABLE_ITEM_NAME = "item";
    public static final String TABLE_ITEM_FIELD_ID = "id";
    public static final String TABLE_ITEM_FIELD_NAME = "name";

    // Table Inventory
    public static final String TABLE_INVENTORY_NAME = "inventory";
    public static final String TABLE_INVENTORY_FIELD_ID = "id";
    public static final String TABLE_INVENTORY_FIELD_PLAYER = "player_id";
    public static final String TABLE_INVENTORY_FIELD_ITEM = "item_id";
    public static final String TABLE_INVENTORY_FIELD_QUANTITY = "quantity";

    // Table Market
    public static final String TABLE_MARKET_NAME = "market";
    public static final String TABLE_MARKET_FIELD_ID = "id";
    public static final String TABLE_MARKET_FIELD_PLAYER = "player_id";
    public static final String TABLE_MARKET_FIELD_ITEM = "item_id";
    public static final String TABLE_MARKET_FIELD_UNITS = "units";
    public static final String TABLE_MARKET_FIELD_PRICE_UNIT = "price_unit";
    public static final String TABLE_MARKET_FIELD_TYPE = "type";

    // CREATE Queries
    public static final String CREATE_TABLE_PLAYER = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL, " +
                    "%s TEXT NOT NULL, " +
                    "%s DOUBLE NOT NULL)",
            TABLE_PLAYER_NAME,
            TABLE_PLAYER_FIELD_ID,
            TABLE_PLAYER_FIELD_NAME,
            TABLE_PLAYER_FIELD_PASSWORD,
            TABLE_PLAYER_FIELD_MONEY
    );

    public static final String CREATE_TABLE_ITEM = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s TEXT NOT NULL)",
            TABLE_ITEM_NAME,
            TABLE_ITEM_FIELD_ID,
            TABLE_ITEM_FIELD_NAME
    );

    public static final String CREATE_TABLE_INVENTORY = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL REFERENCES %s (%s), " +
                    "%s INTEGER NOT NULL)",
            TABLE_INVENTORY_NAME,
            TABLE_INVENTORY_FIELD_ID,
            TABLE_INVENTORY_FIELD_PLAYER,
            TABLE_PLAYER_NAME,
            TABLE_PLAYER_FIELD_ID,
            TABLE_INVENTORY_FIELD_ITEM,
            TABLE_ITEM_NAME,
            TABLE_ITEM_FIELD_ID,
            TABLE_INVENTORY_FIELD_QUANTITY

    );

    public static final String CREATE_TABLE_MARKET = String.format(
            "CREATE TABLE IF NOT EXISTS %s (" +
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

    public static final String FILL_TABLE_PLAYER =
            "INSERT INTO Player (name, password, money) VALUES" +
                    "('Player1', 'player1', 417623)," +
                    "('Player3', 'player3', 942387)," +
                    "('Player2', 'player2', 12293)," +
                    "('Player4', 'player4', 78912374)," +
                    "('Player5', 'player5', 32784692)," +
                    "('Player6', 'player6', 8923748)," +
                    "('Player7', 'player7', 564162)," +
                    "('Player8', 'player8', 21525412)," +
                    "('Player9', 'player9', 545641981)," +
                    "('Player10', 'player10', 5489481);";
}
