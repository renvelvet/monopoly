public class PajakJalan extends Tile{
    public PajakJalan(){
        super();
    }

    public void tileAction(Player player){
        player.cost(100);
    }
}