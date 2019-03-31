import java.util.Random;

public class DanaUmum extends Tile{
    public void askOption(){
    }
    public void tileAction(Player player){
		Random r = new Random();
		int act = r.nextInt(17);
		switch(act){
			case 0 :
				//advance to GoStart
				System.out.println("Advance to GoStart.");
				break;
			case 1 :
				//collect 200
				System.out.println("Bank error in your favor. Collect $200.");
				break;
			case 2 :
				//pay 50
				System.out.println("Doctor's fees. Pay $50.");
				break;
			case 3 :
				//collect 50
				System.out.println("From sale of stock you get $50.");
				break;
			case 4 :
				//Jail Free card
				//may be kept, sold, or traded
				System.out.println("Get Out of Jail Free.");
				break;
			case 5 :
				//go to Jail
				System.out.println("Go to Jail.");
				break;
			case 6 :
				//collect 50 from every player
				System.out.println("Grand Opera Night. Collect $50 from every player for opening night seats.");
				break;
			case 7 :
				//collect 100
				System.out.println("Holiday Fund matures. Receive $100.");
				break;
			case 8 :
				//collect 20
				System.out.println("Income tax refund. Collect $20.");
				break;
			case 9 :
				//collect 10 from every player
				System.out.println("It is your birthday. Collect $10 from every player.");
				break;
			case 10 :
				//collect 100
				System.out.println("Life insurance matures. Collect $100.");
				break;
			case 11 :
				//pay 50
				System.out.println("Hospital Fees. Pay $50.");
				break;
			case 12 :
				//pay 50
				System.out.println("School fees. Pay $50.");
				break;
			case 13 :
				//collect 25
				System.out.println("Receive $25 consultancy fee.");
				break;
			case 14 :
				//pay 40 per house, 115 per hotel owned
				System.out.println("You are assessed for street repairs: Pay $40 per house and $115 per hotel you own.");
				break;
			case 15 :
				//collect 10
				System.out.println("You have won second prize in a beauty contest. Collect $10.");
				break;
			case 16 :
				//collect 100
				System.out.println("You inherit $100.");
				break;
		}
    }
    public void chooseAbleAction(Player player, int i){
    }
    public int getTotalTileInGroup(){
    }
}
