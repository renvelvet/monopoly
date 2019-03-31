import java.util.Scanner;

public class Player //implements Runnable
{

	//self mandratory
	private String name;
	private int money;
	private boolean alive;

	//for other purpose
	private int position;
	private int[] groupownage;
	public static int playercount = 0;
	private int number;

	//for turn based
	private Thread t;
	private Dadu dice;
	private Scanner sc;
	
	public Player (String nama){
		name = nama;
		money = 9000; //duit awal berapa?
		position = 0;
		alive = true;
		groupownage = new int[9];
		playercount++;
		number = playercount;

		dice = new Dadu();
	}

	public void trigger(){
		System.out.println();
		//dipake kalo perturnnya pake player
	}
	
	public void gain (int add){
		money += add;
		System.out.println("Mendapat uang "+ add);
	}
	
	
	public void cost(int loss){
		money =- loss;
		System.out.println("Membayar "+ loss);
		
		if (money <=0){
			//try hypotic
			alive = false;
			System.out.println("Mati");
		}
	}
	
	public void move (int step){
		System.out.println("Berjalan "+step+" petak");
		for (int i = 1; i <= step; i++){
			if (position == 40){
				position = 0;
				gain(2000);
			} else {
				position++;
			}
		}
	}


	//what happen in every turn
    public void turn() {
        do {
            System.out.println("Giliran "+ name);

            //roll and move
            dice.roll();
            move(dice.rollNumber());

            //trigger
            //tile[position].trigger();

            //choose
            String choice = sc.next();
            //tile.choose(String);

        } while (dice.isDouble());
    }
/*
	@Override //what happen in every turn
	public void run() {
		do {
			System.out.println("Giliran "+ name);

			//roll and move
			dice.roll();
			move(dice.rollNumber());

			//trigger
			//tile[position].trigger();

			//choose
			String choice = sc.next();
			//tile.choose(String);

		} while (dice.isDouble());
	}

	public void start(){
		System.out.println();
		if (t == null) {
			t = new Thread(this, name);
			t.start();
		}
	}
*/





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int[] getGroupownage() {
		return groupownage;
	}

	public void setGroupownage(int[] groupownage) {
		this.groupownage = groupownage;
	}

	public static int getPlayercount() {
		return playercount;
	}

	public static void setPlayercount(int playercount) {
		Player.playercount = playercount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
}
