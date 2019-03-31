public class Start extends Tile {
    public Start(){
        super();
    }

    public void tileAction(Player player){
        player.gain(200);
    }
}