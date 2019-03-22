/* Player.java */
/* Modified Player.java from github.com/spywhere */

public class Player {
    int id;
    String name;
    Money money = new Money(5000);

    int totalWalk = 0;
    int position = 0;

    boolean brokeout = money.isBrokeOut();

    // Constructor
    public Player(int id, String name)
    {
        this.id = id;
        this.name = name;
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
    public Money getMoney()
    {
        return money;
    }

    // info totalWalk
    public int getTotalWalk(Dadu d)
    {
        totalWalk = d.getSumFace();
        return totalWalk;
    }

    // info posisi
    public int getCurrentPosition()
    {
        return position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    // info brokeout
    public void setBrokeOut(boolean brokeout)
    {
        this.brokeout = brokeout;
    }

    public boolean getBrokout()
    {
        return this.brokeout;
    }

    // Player's turn
    public void tossDice (Dadu d)
    {
        System.out.print("Dadu yang diperoleh " + getName() + ":");
        d.printFace();
    }

    public void getStatus(Player p)
    {
        Status.print(p);
    }
}