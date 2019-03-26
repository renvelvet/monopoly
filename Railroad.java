public class Railroad extends Property {
    int totalRent;

    public Railroad(String name, int price) {
        super(name, 20000);
    }

    protected void rent(Player player) {
        if(this.getTotalGroupTileOwned() == 1)
        {
            totalRent = price/8;
        } else if(this.getTotalGroupTileOwned() == 2)
        {
            totalRent = price/4;
        } else if(this.getTotalGroupTileOwned() == 3)
        {
            totalRent = price/2;
        } else if(this.getTotalGroupTileOwned() == 4)
        {
            totalRent = price;
        }
        player.changeMoney(-1*totalRent);
        owner.changeMoney(totalRent);
    }
}
