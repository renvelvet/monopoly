import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main{



    public static void main (String[] args){
        //initiate
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 1;
        int maxPlayer = 0;
        //List players = new ArrayList<Turn>(); (cancelled)
        //Turn[] players = new Turn[x]; (set at startgame)


        //start game
        System.out.println();
        System.out.println("Masukkan jumlah pemain");
        int n = sc.nextInt();

        Player[] players = new Player[n+1];
        for (int i = 1; i <= n; i++){
            System.out.println("Masukkan nama pemain");
            String nama = sc.next();
            players[i] = new Player(nama);
        }
/*
        for (int i = 0; i < n; i++){
            System.out.print("start"+i);
            players[i].start();
        }
*/
        maxPlayer = n;

        //the game
        do{
            printField();
            System.out.println(players[currentPlayer].getName()+"'s turn");
            if(players[currentPlayer].isAlive()) {
                try {
                    Thread.sleep(2000);
                    players[currentPlayer].turn();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(players[currentPlayer].getName()+" bankrupted");
            }
            currentPlayer = next(currentPlayer, maxPlayer);
        } while (Player.playercount > 1);




        //end game
        Player winner = new Player("AAAAAAA");
        for (int i = 0; i < n; i++){
            if (players[i].isAlive()) {
                winner = players[i];
            }
        }

        for (int i = 1; i <= n; i++){
            players[i].service.shutdown();
        }
        System.out.println("Pemenangnya adalah"+ winner.getName());




    }

    public static int next(int current, int max){
        if (current == max){
            return 1;
        } else {
            return current + 1;
        }
    }

    public static void printField(){
        System.out.println("S L C L L R L L U L J");
        System.out.println("L - - - - - - - - - L");
        System.out.println("L - - - - - - - - - L");
        System.out.println("O - - - - - - - - - O");
        System.out.println("L - - - - - - - - - L");
        System.out.println("R - - - - - - - - - R");
        System.out.println("L - - - - - - - - - C");
        System.out.println("L - - - - - - - - - L");
        System.out.println("U - - - - - - - - - T");
        System.out.println("L - - - - - - - - - L");
        System.out.println("J L L C L R T L O L S");

    }

}
