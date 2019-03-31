public class GoToJail extends Tile{
    public GoToJail(){
        super();
    }

    public void tileAction(Player player){
        player.setPosition(11); //player pindah langsung ke penjara
        player.setJailed(true);
    }

    public void askOption(){

    }

    public void chooseAbleAction(Player player, int i){

    }
}