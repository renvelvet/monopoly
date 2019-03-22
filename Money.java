/* Money.java */
/* Modified Money.java from github.com/spywhere */

public class Money {
    int money;

    public Money()
    {
        this.money = 0;
    }

    public Money(int money)
    {
        this.money = money;
    }

    public int getMoney()
    {
        return money;
    }

    public void addMoney(int amount)
    {
        money += amount;
    }

    public void substractMoney(int amount)
    {
        money -= amount;
    }

    public boolean isBrokeOut()
    {
        return money < 0;
    }
}