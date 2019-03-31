public class PajakJalan extends Tile{
    public PajakJalan(Player player){
        super(player);
    }

    public void tileAction(Player player){
        player.cost(100);
    }

    public void chooseAbleAction(Player player, int i){

    }

    public void askOption(){

    }
}