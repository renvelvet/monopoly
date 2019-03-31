import java.util.ArrayList;

public class Lot extends Tile implements Property {
    private int totalRent;
    private int grupSize;
    private int homeBuilt = 0;

    public Lot(String name, int price) {
        this.name = name;
        this.price = price;
        }

    public void setGrupSize(int grupSize) {
        this.grupSize = grupSize;
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

    public void tileAction(Player player, int ownedBy)
    {
        if(ownedBy == player.getId())
        {
            buy(player);
        } else
        {
            rent(player);
        }
    }

    // abstract method untuk rent
    void rent(Player player)
    {
        if (player.getGroupownage()[groupNumber] == getTotalTileInGroup())
        {
            if
                setTotalRent(price/4);
            if
                setTotalRent();
        }

    }

    // method untuk membeli
    void buy(Player player)
    {

    }

    public void builtHome(Player player)
    {
        if (player.getGroupownage()[groupNumber] == getTotalTileInGroup() && homeBuilt <= 4) {
                this.homeBuilt++;
        }
    }

    // Menghitung jumlah tile yang dimiliki dalam satu grup
    int getTotalTileInGroup()
    {
        if (groupNumber == 1 || groupNumber == 8)
        {
            setGrupSize(2);
        } else if (groupNumber >= 2 && groupNumber <= 7)
        {
            setGrupSize(3);
        }
        return grupSize;
    }

    protected void rent(Player player) {
        if (getTotalGroupTileOwned() == this.myTileGroup.size())
        {
            totalRent = totalRent/4;
        } else
        {
            totalRent = totalRent/8;
        }

        player.changeMoney(-1*totalRent);
        owner.changeMoney(totalRent);
    }

}
