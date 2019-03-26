/* Player.java */
/* Modified Player.java from github.com/spywhere */

import java.util.Random;

public class Player implements Dadu {
    private int totalFace; // Total face dari dadu yang dilempar
    private int rollValue = 0;
    static Random r = new r(System.nanoTime());

    private Tile currentPosition;
    private int money;

    private int id;
    private String name;

    // Constructor
    public Player(Tile currentPosition)
    {
        this.currentPosition = currentPosition;
        this.money = 20000;
    }

    // Implementasi interface Dadu
    public void rollDice()
    {

        rollValue = r.nextInt(6) + 1;
    }
    public int getLastRollValue()
    {
        return rollValue;
    }

    // Player's turn
    public void playerTurn()
    {
        // Melempar dadu
        rollDice();

        // Player melangkah sejumlah totalFace
        this.movePosition();
    }
    private void rollTheDice()
    {
        totalFace = 0;
        rollDice();
        totalFace += getLastRollValue();
        rollDice();
        totalFace += getLastRollValue();
    }
    private int getTotalFace()
    {
        return totalFace;
    }

    // Player ID
    public int getID()
    {
        return id;
    }

    // Player Name
    public String getName()
    {
        return name;
    }

    // info Money
    public int getMoney()
    {
        return money;
    }
    public void changeMoney(int amount)
    {
        money += amount;
    }

    // Position in tile
    public Tile getCurrentPosition()
    {
        return currentPosition;
    }
    public void performTileAction()
    {
        currentPosition.interactWithTileAction(this);
    }
    public void movePosition()
    {
        currentPosition = currentPosition.getNextTile();
    }
}
