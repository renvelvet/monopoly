public class Lot extends Property {
    private int numHouse;
    private char area;
    private int totalRent;

    public Lot(String name, int price, char area, int numHouse) {
            super(name, price);
            this.totalRent = price;
            this.area = area;
            this.numHouse = numHouse;
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
