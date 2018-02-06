package org.institutoserpis.juanminm.proyectofinal;

/**
 * Created by juamar on 2/02/18.
 */

public class Market {
    private long id;
    private long playerId;
    private long itemId;
    private int units;
    private double priceUnit;
    private String type;

    public Market(long id, long playerId, long itemId, int units, double price_unit,
                  String type) {
        this.id = id;
        this.playerId = playerId;
        this.itemId = itemId;
        this.units = units;
        this.priceUnit = price_unit;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public long getPlayerId() {
        return playerId;
    }

    public long getItemId() {
        return itemId;
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
