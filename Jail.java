//tile jail merupakan tile kosong yang tidak memunculkan aksi apa-apa
//jika player melewati atau tiba di tile jail
//
public class Jail extends Tile{
    public Jail(Player player){
        super(player);
    }


    public void tileAction(Player player){
        System.out.println(player.getName()+" melewati penjara");

    }

    public void chooseAbleAction(Player player, int i){

    }

    public void askOption(){

    }
}