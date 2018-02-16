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
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
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
            String.format("INSERT INTO %s (%s, %s, %s) VALUES " +
                            "('Player1', 'player1', 417623), ('Player3', 'player3', 942387), " +
                            "('Player2', 'player2', 12293), ('Player4', 'player4', 78912374), " +
                            "('Player5', 'player5', 32784692), ('Player6', 'player6', 8923748), " +
                            "('Player7', 'player7', 564162), ('Player8', 'player8', 21525412), " +
                            "('Player9', 'player9', 545641981), ('Player10', 'player10', 5489481);",
                    TABLE_PLAYER_NAME,
                    TABLE_PLAYER_FIELD_NAME,
                    TABLE_PLAYER_FIELD_PASSWORD,
                    TABLE_PLAYER_FIELD_MONEY
            );

    public static final String FILL_TABLE_ITEM =
            String.format("INSERT INTO %s (%s) VALUES " +
                            "('Item 1'), ('Item 2'), ('Item 3'), ('Item 4'), ('Item 5')," +
                            "('Item 6'), ('Item 7'), ('Item 8');",
                    TABLE_ITEM_NAME,
                    TABLE_ITEM_FIELD_NAME
            );

    public static final String FILL_TABLE_INVENTORY =
            String.format("INSERT INTO %s (%s, %s, %s) VALUES " +
                            "(1, 1, 245), (1, 1, 465), (1, 2, 389), (1, 2, 980), (1, 3, 581)," +
                            "(1, 6, 667), (1, 6, 771), (2, 1, 187), (2, 3, 780), (3, 6, 236), " +
                            "(3, 8, 217), (4, 4, 118), (4, 5, 673), (4, 8, 849), (5, 3, 768), " +
                            "(5, 3, 984), (5, 5, 154), (5, 5, 671), (5, 6, 95), (5, 6, 488), " +
                            "(5, 6, 878), (6, 2, 760), (6, 4, 982), (6, 5, 123), (6, 5, 670), " +
                            "(6, 5, 966), (7, 1, 48), (7, 1, 193), (7, 3, 60), (8, 1, 536), " +
                            "(8, 4, 172), (9, 1, 537), (9, 1, 816), (9, 5, 394), (9, 6, 294), " +
                            "(9, 7, 176), (10, 4, 748);",
                    TABLE_INVENTORY_NAME,
                    TABLE_INVENTORY_FIELD_PLAYER,
                    TABLE_INVENTORY_FIELD_ITEM,
                    TABLE_INVENTORY_FIELD_QUANTITY
            );

    public static final String FILL_TABLE_MARKET =
            String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES " +
                            "(7, 4, 4, 5042.48, 1), (8, 7, 18, 9533.24, 0), " +
                            "(1, 6, 7, 7732.85, 0), (6, 8, 5, 109.53, 1), " +
                            "(4, 1, 13, 7059.12, 0), (5, 5, 12, 5225.81, 0), " +
                            "(7, 8, 11, 1523.18, 0), (9, 6, 17, 1345.98, 1), " +
                            "(6, 7, 19, 7277.59, 0), (6, 7, 11, 2438.48, 1), " +
                            "(2, 3, 18, 9080.86, 1), (8, 6, 19, 2123.23, 1), " +
                            "(6, 6, 3, 544.68, 0), (2, 7, 8, 8232.12, 0), " +
                            "(8, 2, 17, 2829.43, 0), (4, 5, 6, 2695.06, 1), " +
                            "(10, 7, 15, 4109.38, 1), (9, 7, 6, 3634.79, 0), " +
                            "(5, 8, 19, 401.82, 1), (5, 7, 4, 6422.37, 0), " +
                            "(1, 8, 16, 9249.21, 1), (9, 2, 15, 2861.3, 0), " +
                            "(5, 7, 20, 6857.95, 1), (6, 3, 8, 3545, 0), " +
                            "(6, 6, 2, 3638.21, 0), (6, 5, 10, 7656.42, 1), " +
                            "(5, 7, 15, 8567.93, 1), (4, 2, 12, 6591.31, 0), " +
                            "(2, 2, 6, 8248.34, 1), (4, 6, 20, 3274.13, 0), " +
                            "(3, 7, 15, 4059.76, 0), (2, 2, 7, 8766.53, 1), " +
                            "(3, 6, 1, 664.1, 0), (10, 4, 2, 3472.37, 0), " +
                            "(2, 5, 13, 1875.92, 0), (3, 2, 2, 7187, 1), " +
                            "(8, 8, 14, 5114.36, 1), (10, 7, 17, 1045.21, 1), " +
                            "(8, 4, 19, 1047.76, 1)",
                    TABLE_MARKET_NAME,
                    TABLE_MARKET_FIELD_PLAYER,
                    TABLE_MARKET_FIELD_ITEM,
                    TABLE_MARKET_FIELD_UNITS,
                    TABLE_MARKET_FIELD_PRICE_UNIT,
                    TABLE_MARKET_FIELD_TYPE);
}
