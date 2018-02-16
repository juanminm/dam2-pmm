package org.institutoserpis.juanminm.proyectofinal;

/**
 * @author Juan Miguel Navarro Martínez
 */

public class Inventory {
    private long id;
    private Player player;
    private Item item;
    private int quantity;

    public Inventory(long id, Player player, Item item) {
        this(id, player, item, 1);
    }

    public Inventory(long id, Player player, Item item, int quantity) {
        this.id = id;
        this.player = player;
        this.item = item;
        this.quantity= quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
