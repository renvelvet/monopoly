import java.util.Random;
import java.util.Scanner;

public class DanaUmum extends Tile{
    Random r = new Random();
    int act = r.nextInt(17);
    Scanner s = new Scanner(System.in);
    int c; // choice

    public void askOption(){
        switch(act) {
            case 4 :
                // Kept, sold, traded card
                System.out.println("Do you want to: ");
                System.out.println("1. Keep it");
                System.out.println("2. Sell it");
                System.out.print("My choice: ");
        }
    }

    public void tileAction(Player player){
        switch(act){
            case 0 :
                //advance to GoStart
                System.out.println("Advance to GoStart.");
                player.setPosition(0);
                player.gain(200);
                break;
            case 1 :
                //collect 200
                System.out.println("Bank error in your favor. Collect $200.");
                player.gain(200);
                break;
            case 2 :
                //pay 50
                System.out.println("Doctor's fees. Pay $50.");
                player.cost(50);
                break;
            case 3 :
                //collect 50
                System.out.println("From sale of stock you get $50.");
                player.gain(50);
                break;
            case 4 :
                //Jail Free card
                //may be kept or sold
                System.out.println("Get Out of Jail Free.");
                askOption();

                do {
                    c = s.nextInt();
                    if (c<1 || c>2)
                    {
                        System.out.println("You must be choose 1 or 2");
                    }
                } while (c<1 || c>2);

                chooseAbleAction(player, c);
                break;
            case 5 :
                //go to Jail
                System.out.println("Go to Jail.");
                player.setPosition(10);
                break;
            case 6 :
                //collect 50 from every player
                System.out.println("Grand Opera Night. Collect $50 from every player for opening night seats.");
                //player.gain();
                break;
            case 7 :
                //collect 100
                System.out.println("Holiday Fund matures. Receive $100.");
                player.gain(100);
                break;
            case 8 :
                //collect 20
                System.out.println("Income tax refund. Collect $20.");
                player.gain(20);
                break;
            case 9 :
                //collect 10 from every player
                System.out.println("It is your birthday. Collect $10 from every player.");
                //player.gain();
                player.gain(10*Player.playercount);
                player.monify(-10);
                break;
            case 10 :
                //collect 100
                System.out.println("Life insurance matures. Collect $100.");
                player.gain(100);
                break;
            case 11 :
                //pay 50
                System.out.println("Hospital Fees. Pay $50.");
                player.cost(50);
                break;
            case 12 :
                //pay 50
                System.out.println("School fees. Pay $50.");
                player.cost(50);
                break;
            case 13 :
                //collect 25
                System.out.println("Receive $25 consultancy fee.");
                player.gain(25);
                break;
            case 14 :
                //pay 40 per house
                System.out.println("You are assessed for street repairs: Pay $40 per house you own.");
                player.cost(player.getHousestats() * 40);
                break;
            case 15 :
                //collect 10
                System.out.println("You have won second prize in a beauty contest. Collect $10.");
                player.gain(10);
                break;
            case 16 :
                //collect 100
                System.out.println("You inherit $100.");
                player.gain(100);
                break;
        }
    }
    public void chooseAbleAction(Player player, int i){
        if (i == 1)
        {
            player.setJailfree(true);
        } else if (i == 2)
        {
            player.gain(15);
        }
    }

}
