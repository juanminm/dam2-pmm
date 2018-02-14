package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class Inventory {
    private long id;
    private long playerId;
    private long itemId;
    private int quantity;

    public Inventory(long id, long playerId, long itemId) {
        this(id, playerId, itemId, 1);
    }

    public Inventory(long id, long playerId, long itemId, int quantity) {
        this.id = id;
        this.playerId = playerId;
        this.itemId = itemId;
        this.quantity= quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
