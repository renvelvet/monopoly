import java.util.Scanner;
import java.util.Timer;
import java.util.concurrent.*;

public class Player //implements Runnable
{

	//self mandratory
	private String name;
	private int money;
	private boolean alive;
	public static int moneys = 0;
	private int housestats;

	//for other purpose
	private int position;
	private int[] groupownage;
	public static int playercount = 0;
	private int id;
	private boolean jailed;
	private boolean jailfree;
	private static Board board = new Board();

	//for turn based
	private Thread t;
	private Dadu dice;
	private Scanner sc = new Scanner(System.in);
	private ExecutorService service = Executors.newSingleThreadExecutor();

	public Player (String nama){
		name = nama;
		money = 1500; //duit awal berapa?
		housestats = 0;
		position = 0;
		alive = true;
		groupownage = new int[13];
		id = playercount;
		playercount++;
		jailed = false;
		jailfree = false;

		dice = new Dadu();
	}

	public void trigger(){
		System.out.println();
		//dipake kalo perturnnya pake player
	}

	public void gain (int add){
		money = money + add;
		System.out.println("Mendapat uang "+ add +" rupiah");
	}


	public void cost(int loss){
		money = money - loss;
		System.out.println("Membayar "+ loss+ " rupiah");

		if (money + moneys <=0){
			System.out.println(money +" "+moneys +" "+ money+moneys);
			//try hypotic
			alive = false;
			playercount--;
			System.out.println(name + " Mati");
		}
	}

	public void monify(int modifier){
		money += modifier;
		moneys -= modifier;
	}


	public void move (int step){
		if (jailed && !dice.isDouble()){
			System.out.println("Dipenjara, tidak bisa bergerak turn ini");
			jailed = false;
		} else {
			System.out.println("Berjalan " + step + " petak");
			jailed = false;
			for (int i = 1; i <= step; i++) {
				if (position == 40) {
					position = 0;
					gain(200);
				} else {
					position++;
				}
			}
		}
	}


	//what happen in every turn
	public void turn() { //uncompleted
		do {
			System.out.println("Giliran "+ name);

			//preemptive
			if (jailed){
				System.out.println("Ingin membayar 50 atau pakai tiket untuk langsung bebas?");
				System.out.println("1. Ya angka lain untuk Tidak");
				int jailedChoice = sc.nextInt();
				if (jailedChoice == 1){
					if (jailfree){
						jailfree = false;
					} else {
						cost(50);
					}
					jailed = false;
				}
			}

			//roll and move
			dice.roll();
			move(dice.rollNumber());

			//trigger
			board.tile[position].tileAction(this);

			//choose
			//if (board.tile[position].isChooseAble()) {
				try {
					Runnable r = new Runnable() {
						@Override
						public void run() {
							//choose code utama
							board.tile[position].askOption();
							int choice = sc.nextInt();
							board.tile[position].chooseAbleAction(Player.this, choice);
						}

					};

					Future<?> f = service.submit(r);

					f.get(30000, TimeUnit.MILLISECONDS);     // attempt the task for 30 secs
				} catch (final InterruptedException e) {
					System.out.println("interrupted, you are unlucky");
					e.getCause().printStackTrace();
				} catch (final TimeoutException e) {
					System.out.println("Waktu habis");
				} catch (final ExecutionException e) {
					System.out.println("(bug detected)");
					e.getCause().printStackTrace();
				} finally {
					service.shutdown();
					try {
						Thread.sleep(3000);
						service.awaitTermination(1, TimeUnit.MINUTES);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			//}


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

	public int getId() {
		return id;
	}

	public void setId(int number) {
		this.id = number;
	}

	public boolean isJailed() {
		return jailed;
	}

	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}

	public Dadu getDice() {
		return dice;
	}

	public void setDice(Dadu dice) {
		this.dice = dice;
	}

	public boolean isJailfree() {
		return jailfree;
	}

	public void setJailfree(boolean jailfree) {
		this.jailfree = jailfree;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getHousestats() {
		return housestats;
	}

	public void setHousestats(int housestats) {
		this.housestats = housestats;
	}
}
