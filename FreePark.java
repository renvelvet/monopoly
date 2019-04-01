public class FreePark extends Tile {
    public FreePark(Player player){
        super(player);
    }

    public void askOption(){
        System.out.println("Silakan pilih nomor petak yang ingin dituju (1-40): ");
    }

    public void chooseAbleAction(Player player, int i){
        player.setPosition(i);
    }

    public void tileAction(Player player){
        System.out.println("Parkir bebas "+ player.getName());
    }

}