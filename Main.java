import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Main{



    public static void main (String[] args){
        //initiate
        Scanner sc = new Scanner(System.in);
        int currentPlayer = 0;
        int maxPlayer = 0;
        //List players = new ArrayList<Turn>(); (cancelled)
        //Turn[] players = new Turn[x]; (set at startgame)


        //start game
        System.out.println();
        System.out.println("Masukkan jumlah pemain");
        int n = sc.nextInt();

        Player[] players = new Player[n];
        for (int i = 1; i <= n; i++){
            System.out.println("Masukkan nama pemain");
            String nama = sc.next();
            players[i-1] = new Player(nama);
        }
/*
        for (int i = 0; i < n; i++){
            System.out.print("start"+i);
            players[i].start();
        }
*/
        maxPlayer = n - 1;

        //the game
        do{
            printField();
            System.out.println(players[currentPlayer].getName()+"'s turn");
            if(players[currentPlayer].isAlive()) {
                players[currentPlayer].turn();
            } else {
                System.out.println(players[currentPlayer].getName()+" bankrupted");
            }
            currentPlayer = next(currentPlayer, maxPlayer);
        } while (Player.playercount > 1);




        //end game




    }

    public static int next(int current, int max){
        if (current >= max){
            return 0;
        } else {
            return current + 1;
        }
    }

    public static void printField(){

    }

}
