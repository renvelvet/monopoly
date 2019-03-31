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
        if(ownedBy == 0)
        {
            buy(player);
        } else if (ownedBy == player.getId())
        {

        }else
        {
            rent(player);
        }
    }

    // abstract method untuk rent
    void rent(Player player)
    {
        if (player.getGroupownage()[groupNumber] == getTotalTileInGroup()) {
            if (homeBuilt == 0) {
                setTotalRent(price / 4);
            }
            if (homeBuilt == 1) {
                setTotalRent(price / 2);
            }
            if (homeBuilt == 2) {
                setTotalRent(price);
            }
            if (homeBuilt == 3) {
                setTotalRent(price * 2);
            }
            if (homeBuilt == 4) {
                setTotalRent(price * 4);
            }
        } else
        {
            setTotalRent(price / 8);
        }

        ownedBy.gain(totalRent);
        player.cost(totalRent);
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

}
