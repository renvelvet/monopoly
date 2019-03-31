public class PajakIstimewa extends Tile{
    public PajakIstimewa(Player player){
        super(player);
    }

    public void tileAction(Player player){
        player.gain(200);
    }

    public void chooseAbleAction(Player player, int i){

    }

    public void askOption(){

    }
}