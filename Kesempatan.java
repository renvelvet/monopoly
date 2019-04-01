import java.util.Random;
import java.util.Scanner;

public class Kesempatan extends Tile{
    Scanner sc = new Scanner(System.in);
    Board board;

    public Kesempatan(Player player, Board board) {
        super(player);
        this.board = board;
    }

    public void askOption(){
    }
    public void tileAction(Player player){
        System.out.println("Kesempatan "+player.getName());
        Random r = new Random();
        int act = r.nextInt(16);
        switch(act){
            case 0 :
                //advance to GoStart
                System.out.println("Advance to GoStart.");
                if(player.getPosition()!=0){
                    player.gain(200);
                }
                player.setPosition(0);
                break;
            case 1 :
                //advance to Bengawan Solo
                System.out.println("Advance to Bengawan Solo. If you pass Go, collect $200.");
                if(player.getPosition()>24){
                    player.gain(200);
                }
                player.setPosition(24);
                if(board.tile[24].ownedBy==null || board.tile[24].ownedBy.equals(player)){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else {
                    board.tile[24].tileAction(player);
                }
                break;
            case 2 :
                //advance to Kebun Raya Bogor
                System.out.println("Advance to Kebun Raya Bogor. If you pass Go, collect $200.");
                if(player.getPosition()>11){
                    player.gain(200);
                }
                player.setPosition(11);
                if(board.tile[11].ownedBy==null || board.tile[11].ownedBy.equals(player)){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else {
                    board.tile[11].tileAction(player);
                }
                break;
            case 3 :
                //advance to nearest Utility
                //if unowned, you may buy it from the bank
                //if owned, throw dice and pay owner a total 10 times the amount thrown
                System.out.println("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total 10 times the amount thrown.");
                if(player.getPosition()<12){
                    player.setPosition(12);
                }
                else if(player.getPosition()>12 && player.getPosition()<28){
                    player.setPosition(28);
                }
                else if(player.getPosition()>28){
                    player.gain(200);
                    player.setPosition(12);
                }
                else{
                    System.out.println("Already.");
                }
                if(ownedBy==null){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else{
                    player.getDice().roll();
                    player.cost(player.getDice().rollNumber() * 10);
                    board.tile[player.getPosition()].ownedBy.gain(player.getDice().rollNumber() * 10);
                }
                break;
            case 4 :
                //advance to nearest Railroad
                //if unowned, you may buy it from the bank
                //if owned, pay owner twice the rental
                System.out.println("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
                if(player.getPosition()<5){
                    player.setPosition(5);
                }
                else if(player.getPosition()>5 && player.getPosition()<15){
                    player.setPosition(15);
                }
                else if(player.getPosition()>15 && player.getPosition()<25){
                    player.setPosition(25);
                }
                else if(player.getPosition()>25 && player.getPosition()<35){
                    player.setPosition(35);
                }
                else if(player.getPosition()>35){
                    player.gain(200);
                    player.setPosition(5);
                }
                else{
                    System.out.println("Already.");
                }
                if(board.tile[player.getPosition()].ownedBy==null){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else{
                    //board.tile[player.getPosition()].rent(player);
                    //board.tile[player.getPosition()].rent(player);
                }
                break;
            case 5 :
                //collect 50
                System.out.println("Bank pays you dividend of $50.");
                player.gain(50);
                break;
            case 6 :
                //Jail Free card
                //may be kept, traded, or sold
                System.out.println("Get out of Jail Free. This card may be kept until needed, or traded/sold.");
                player.setJailfree(true);
                break;
            case 7 :
                //go back 3 spaces
                System.out.println("Go Back Three Spaces.");
                player.setPosition(player.getPosition() - 3);
                if(board.tile[player.getPosition()].ownedBy==null || board.tile[player.getPosition()].ownedBy.equals(player)){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else {
                    board.tile[player.getPosition()].tileAction(player);
                }
                break;
            case 8 :
                //go to jail
                //do not pass GoStart, do not collect 200
                System.out.println("Go to Jail. Go directly to Jail. Do not pass Go, do not collect $200.");
                player.setPosition(10);
                if(!player.isJailfree()){
                    player.setJailed(true);
                }
                else{
                    player.setJailfree(false);
                    player.setJailed(false);
                }
                break;
            case 9 :
                //for each house pay 25
                System.out.println("Make general repairs on all your property: For each house pay $25.");
                player.cost(player.getHousestats() * 25);
                break;
            case 10 :
                //pay tax 15
                System.out.println("Pay poor tax of $15.");
                player.cost(15);
                break;
            case 11 :
                //go to Bandara Kemayoran
                System.out.println("Take a trip to Bandara Kemayoran.");
                if(player.getPosition()>5){
                    player.gain(200);
                }
                player.setPosition(5);
                if(board.tile[5].ownedBy==null || board.tile[5].ownedBy.equals(player)){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else {
                    board.tile[5].tileAction(player);
                }
                break;
            case 12 :
                //go to Brastagi
                System.out.println("Take a walk on Brastagi. Advance token to Brastagi.");
                player.setPosition(39);
                if(board.tile[39].ownedBy==null || board.tile[39].ownedBy.equals(player)){
                    askOption();
                    int opt = sc.nextInt();
                    chooseAbleAction(player, opt);
                }
                else {
                    board.tile[39].tileAction(player);
                }
                break;
            case 13 :
                //pay each player 50
                System.out.println("You have been elected Chairman of the Board. Pay each player $50.");
                player.monify(-50);
                player.cost(50*(Player.playercount-1));
                break;
            case 14 :
                //collect 150
                System.out.println("Your building loan matures. Receive $150.");
                player.gain(150);
                break;
            case 15 :
                //collect 100
                System.out.println("You have won a crossword competition. Collect $100.");
                player.gain(100);
                break;
        }
    }
    public void chooseAbleAction(Player player, int i){
    }
}

