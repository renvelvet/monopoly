/* Dadu.java */
/* Modified Die.java from github.com/zachcannon */

public interface Dadu {

    public void rollDice();

    public int getLastRollValue();

/*
    int[] face = new int[2];
    int sumFace;

    // Face dadu yang didapatkan pemain
    public void printFace()
    {
        Random rand = new Random();

        face[0] = 1+rand.nextInt(6);
        face[1] = 1+rand.nextInt(6);

        System.out.println(this.face[0] + " " + this.face[1]);
    }

    // TotalWalk pemain
    public int getSumFace()
    {
        sumFace = face[0] + face[1];
        return sumFace;
    }
*/
    /* Test
    public static void main(String[] args)
    {
        Dadu d = new Dadu();
        d.printFace();
        System.out.println(d.getSumFace());
    }
    */
}