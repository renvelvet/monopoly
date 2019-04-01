import java.util.Scanner;

public class Turn implements Runnable{ //DEPRECATED

    //THIS CLASS ISN'T USED AT ALL
    
    private Thread t;
    private Player player;
    private Dadu dice;
    private Scanner sc;

    public Turn(Player player) {
        this.player = player;
        dice = new Dadu();
        sc = new Scanner(System.in);
    }


    @Override //what happen in every turn
    public void run() {
        do {
            //roll and move
            dice.roll();
            player.move(dice.rollNumber());

            //trigger
            //tile.trigger();

            //choose
            String choice = sc.next();
            //tile.choose(String);

        } while (dice.isDouble());
    }

    public void start(){
        System.out.println();
        if (t == null) {
            t = new Thread(this, player.getName());
            t.start();
        }
    }
}
