public class GoToJail extends Tile{
    public GoToJail(Player player){
        super(player);
    }

    public void tileAction(Player player){
        System.out.println(player.getName()+ " tertangkap tangan");
        System.out.println(player.getName()+ " dimasukkan ke dalam penjara");
        player.setPosition(11); //player pindah langsung ke penjara
        player.setJailed(true);
    }

    public void askOption(){

    }

    public void chooseAbleAction(Player player, int i){

    }
}