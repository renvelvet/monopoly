public class Utilities extends Property{
//Utilities merupakan turunan dari kelas Property
//Utilities meliputi PAM dan PLN
    private int totalRent
    private String p;
    public Utilities(String name, int price, String p) {
        super(name, price);
        this.totalRent = price;
        this.p = p;
    }

    protected void rent(Player player) {
        if (getTotalGroupTileOwned() == this.myTileGroup.size())
        {
            // punya kedua perusahaan
            totalRent = totalRent/2;
        } else
        {
            // hanya punya salah 1
            totalRent = totalRent/8;
        }

        player.changeMoney(-1*totalRent);
        owner.changeMoney(totalRent);
    }

}
