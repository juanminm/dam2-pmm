package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class Market {
    public static final int MARKET_TYPE_BUY = 0;
    public static final int MARKET_TYPE_SELL = 1;

    private long id;
    private Player player;
    private Item item;
    private int units;
    private double priceUnit;
    private int type;

    public Market(long id, Player player, Item item, int units, double price_unit,
                  int type) {
        this.id = id;
        this.player = player;
        this.item = item;
        this.units = units;
        this.priceUnit = price_unit;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Item getItem() {
        return item;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
