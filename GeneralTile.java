/* GeneralTile.java */
/* Modified GeneralSpace.java from github.com/zachcannon */

public class GeneralTile implements Tile {
    private Tile nextTile;

    public GeneralTile()
    {}

    public void setNextTile(Tile nextTile)
    {
        this.nextTile = nextTile;
    }

    public Tile getNextTile()
    {
        return nextTile;
    }

    public void interactWithTileAction(Player player)
    {}

}
