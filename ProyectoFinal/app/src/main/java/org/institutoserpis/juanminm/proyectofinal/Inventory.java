package org.institutoserpis.juanminm.proyectofinal;

/**
 * Created by juamar on 2/02/18.
 */

public class Inventory {
    private long playerId;
    private long itemId;
    private int quantity;

    public Inventory(long playerId, long itemId) {
        this(playerId, itemId, 1);
    }

    public Inventory(long playerId, long itemId, int quantity) {
        this.playerId = playerId;
        this.itemId = itemId;
        this.quantity= quantity;
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
