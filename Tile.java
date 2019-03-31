/* Tile.java */

import java.util.ArrayList;

public abstract class Tile {
    protected String name;
    protected boolean isOwnable; // If isOwnable true maka dia Property, selain itu Space
    protected int groupNumber;
    protected int ownedBy; // dimiliki oleh pemain dengan ID berapa

    public Tile(String name, boolean isOwnable, int groupNumber, int price) {
        this.name = name;
        this.isOwnable = isOwnable;
        this.groupNumber = groupNumber;
        this.ownedBy = 0;
        this.price = price;
    }

    // Attribute for Property.java
    protected int price;

    public abstract void tileAction(Player player, int i);

    int getTotalTileInGroup();

}