/* Tile.java */

import java.util.ArrayList;

public abstract class Tile {
    protected String name;
    protected boolean isOwnable; // If isOwnable true maka dia Property, selain itu Space
    protected int groupNumber;
    protected Player ownedBy; // dimiliki oleh pemain dengan ID berapa
    protected int totalRent;
    protected int grupSize;
    protected boolean chooseAble;

    // Untuk Property
    public Tile(String name, boolean isOwnable, int groupNumber, int price) {
        this.name = name;
        this.isOwnable = isOwnable;
        this.groupNumber = groupNumber;
        this.ownedBy = null;
        this.price = price;
    }

    // Untuk Space
    public Tile() {
        this.name = null;
        this.isOwnable = false;
        this.groupNumber = 0;
        this.ownedBy = null;
        this.price = 0;
    }

    // Attribute for Property.java
    protected int price;

    public abstract void askOption();

    public abstract void tileAction(Player player); // Aksi yang didapat player

    public abstract void chooseAbleAction(Player player, int i); // Aksi yang dipilih player

    public abstract int getTotalTileInGroup();

}