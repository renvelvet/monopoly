public class PajakIstimewa extends Tile{
    public PajakIstimewa(Player player){
        super(player);
    }

    public void tileAction(Player player){
        System.out.println(player.getName()+" dikenai pajak istimewa");
        player.cost(200);
    }

    public void chooseAbleAction(Player player, int i){

    }

    public void askOption(){

    }
}