import java.util.ArrayList;

public class Lot extends Tile implements Property {

    private int homeBuilt;
    private boolean wantToBuiltHome;


    public Lot(String name, boolean isOwnable, int groupNumber, int price, Player player) {

        super(name, true, groupNumber, price, player);
        this.wantToBuiltHome = false;
        this.homeBuilt = 0;
        }

    public void setGrupSize(int grupSize) {
        this.grupSize = grupSize;
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

    public void askOption() {
        System.out.println("1. Beli Lot");
        System.out.println("2. Bangung Rumah");
        System.out.println("3. Lewati");
        System.out.print("Opsi yang dipilih: ");
    }

    public void tileAction(Player player)
    {
        if (ownedBy.getId() == 0 || ownedBy.getId() == player.getId() ){

        } else {
            rent(player);
        }
    }

    public void chooseAbleAction(Player player, int i) {

        if (ownedBy.getId() == 0 && i == 1) {
            buy(player);
            System.out.println(name+" terbeli");
        } else if (ownedBy.getId() == 0 && i == 3){
            // change turn
        } else if ((ownedBy.equals(player) && ownedBy.getGroupownage()[groupNumber] == getTotalTileInGroup()) && i == 2) {
            builtHome(player);
        } else if ((ownedBy.equals(player) && ownedBy.getGroupownage()[groupNumber] == getTotalTileInGroup()) && i == 3) {
            // change turn
        }
    }
    // abstract method untuk rent
    public void rent(Player player)
    {
        if (ownedBy.getGroupownage()[groupNumber] == getTotalTileInGroup()) {
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
    public void buy(Player player)
    {
        player.cost(price);
        ownedBy = player;

        int[] a = player.getGroupownage();
        a[groupNumber] = a[groupNumber] + 1;
        player.setGroupownage(a);
    }

    public void builtHome(Player player)
    {
        if (player.getGroupownage()[groupNumber] == getTotalTileInGroup() && homeBuilt <= 4) {
                this.homeBuilt++; // Total rumah yang dimiliki player dalam 1 group
                player.setHousestats(player.getHousestats() + 1); // Total rumah yang dimiliki player
        }
        else
        {
            System.out.println("Total lot yang dibeli belum sekompleks");
        }
    }

    // Menghitung jumlah tile yang dimiliki dalam satu grup
    public int getTotalTileInGroup()
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