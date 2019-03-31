public class PajakIstimewa extends Tile{
    public PajakIstimewa(){
        super();
    }

    public void tileAction(Player player){
        player.gain(200);
    }
}