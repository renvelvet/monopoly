public class Utilities extends Tile implements Property {

    public Utilities (String name, boolean isOwnable, int groupNumber, int price, Player player)
    {
        super(name, true, 10, price, player);
    }

    public void setTotalRent(int totalRent) {
        this.totalRent = totalRent;
    }

    public void askOption() {
        System.out.println("1. Beli");
        System.out.println("2. Lewati");
        System.out.print("Opsi yang dipilih: ");
    }

    public void tileAction(Player player){
        System.out.println(player.getName()+ " telah tiba di "+ name);
        if (ownedBy.getId() == 0 || ownedBy.getId() == player.getId() ){

        } else {
            rent(player);
        }
    }

    public void chooseAbleAction(Player player, int i)
    {
        if (ownedBy == null && i == 1)
        {
            buy(player);
        } else if (ownedBy == null && i == 2)
        {
            // change turn
        }
    }

    public int getTotalTileInGroup()
    {
        return 2;
    }

    // implementasi abstract method untuk rent
    public void rent(Player player)
    {
        if (ownedBy.getGroupownage()[groupNumber] == getTotalTileInGroup())
        { // Punya kedua perusahaan
            setTotalRent(price/2);
        } else
        { // Hanya punya 1 perusahaan
            setTotalRent(price/8);
        }

        ownedBy.gain(totalRent);
        player.cost(totalRent);

        System.out.println(player.getName()+ " membayar denda kepada " + ownedBy.getName() + " sebesar " + totalRent + " rupiah");
    }

    // implementasi method untuk membeli
    public void buy(Player player)
    {
        player.cost(price);
        ownedBy = player;

        System.out.println(player.getName()+ " membeli " +name);

        int[] a = player.getGroupownage();
        a[groupNumber] = a[groupNumber] + 1;
        player.setGroupownage(a);
    }

}
