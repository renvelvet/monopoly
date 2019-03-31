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
    public Tile(String name, boolean isOwnable, int groupNumber, int price, Player player) {
        this.name = name;
        this.isOwnable = isOwnable;
        this.groupNumber = groupNumber;
        this.ownedBy = player;
        this.price = price;
    }

    // Untuk Space
    public Tile(Player player) {
        this.name = "";
        this.isOwnable = false;
        this.groupNumber = 0;
        this.ownedBy = player;
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwnable() {
        return isOwnable;
    }

    public void setOwnable(boolean ownable) {
        isOwnable = ownable;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Player getOwnedBy() {
        return ownedBy;
    }

    public void setOwnedBy(Player ownedBy) {
        this.ownedBy = ownedBy;
    }

    public int getTotalRent() {
        return totalRent;
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

    public int getGrupSize() {
        return grupSize;
    }

    public void setGrupSize(int grupSize) {
        this.grupSize = grupSize;
    }

    public boolean isChooseAble() {
        return chooseAble;
    }

    public void setChooseAble(boolean chooseAble) {
        this.chooseAble = chooseAble;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Attribute for Property.java
    protected int price;

    public abstract void askOption();

    public abstract void tileAction(Player player); // Aksi yang didapat player

    public abstract void chooseAbleAction(Player player, int i); // Aksi yang dipilih player

}