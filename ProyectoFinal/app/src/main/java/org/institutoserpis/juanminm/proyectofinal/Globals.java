package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */


public final class Globals {
    // Database settings
    public static final String DATABASE_NAME = "GameMarket.db";
    public static final int DATABASE_VERSION = 4;

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
            "INSERT INTO player (name, password, money) VALUES " +
                    "('Player1', 'player1', 417623), ('Player3', 'player3', 942387), " +
                    "('Player2', 'player2', 12293), ('Player4', 'player4', 78912374), " +
                    "('Player5', 'player5', 32784692), ('Player6', 'player6', 8923748), " +
                    "('Player7', 'player7', 564162), ('Player8', 'player8', 21525412), " +
                    "('Player9', 'player9', 545641981), ('Player10', 'player10', 5489481);";

    public static final String FILL_TABLE_ITEM =
            "INSERT INTO item (name) VALUES " +
                    "('Item 1'), ('Item 2'), ('Item 3'), ('Item 4'), ('Item 5'), ('Item 6'), " +
                    "('Item 7'), ('Item 8');";

    public static final String FILL_TABLE_INVENTORY =
            "INSERT INTO inventory (player_id, item_id, quantity) VALUES " +
                    "(1, 1, 245), (1, 1, 465), (1, 2, 389), (1, 2, 980), (1, 3, 581)," +
                    "(1, 6, 667), (1, 6, 771), (2, 1, 187), (2, 3, 780), (3, 6, 236), " +
                    "(3, 8, 217), (4, 4, 118), (4, 5, 673), (4, 8, 849), (5, 3, 768), " +
                    "(5, 3, 984), (5, 5, 154), (5, 5, 671), (5, 6, 95), (5, 6, 488), " +
                    "(5, 6, 878), (6, 2, 760), (6, 4, 982), (6, 5, 123), (6, 5, 670), " +
                    "(6, 5, 966), (7, 1, 48), (7, 1, 193), (7, 3, 60), (8, 1, 536), " +
                    "(8, 4, 172), (9, 1, 537), (9, 1, 816), (9, 5, 394), (9, 6, 294), " +
                    "(9, 7, 176), (10, 4, 748);";
}
