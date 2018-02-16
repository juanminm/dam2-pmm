package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class Market {
    private long id;
    private Player player;
    private Item item;
    private int units;
    private double priceUnit;
    private String type;

    public Market(long id, Player player, Item item, int units, double price_unit,
                  String type) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
