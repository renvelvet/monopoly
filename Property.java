/* Property.java
Modified OwnableSpace from github.com/zachcannon
 */

import java.util.ArrayList;

public abstract class Property extends GeneralTile{
    private String name; // name dari property
    protected ArrayList<Property> myTileGroup;
    protected int price; // harga property
    protected Player owner;
    protected boolean isBought; // status apakah property sudah dibeli

    protected Property(String name, int price)
    {
        this.name = name;
        this.price = price;
        this.isBought = false;
        this.owner = null;
    }

    // getter
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public boolean getBoughtStatus(){
        return this.isBought;
    }
    public Player getOwner()
    {
        return owner;
    }

    // setter
    public void setGroup(ArrayList<Property> mySpaceGroup)
    {
        this.myTileGroup = myTileGroup;
    }
    public void setOwner(Player owner)
    {
        this.owner = owner;
    }

    // abstract method untuk rent
    protected abstract void rent(Player player);

    // method untuk membeli
    private final void buy(Player player)
    {
        player.changeMoney(-1 * price);
        owner = player;
    }

    public final void interactWithTileAction(Player player) {
        if (owner != null) {
            rent(player);
        } else {
            if(player.getMoney() >= price) {
                this.buy(player);
            }
        }
    }
    // Menghitung jumlah tile yang dimiliki
    public final int getTotalGroupTileOwned()
    {
        // Atribut total tile owned
        int total = 0;
        for(Property sTile : myTileGroup)
        {
            if (sTile.getOwner() == owner)
            {
                total++;
            }
        }

        return total;
    }

}