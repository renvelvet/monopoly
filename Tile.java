/* Tile.java */
/* Modified Space.java from github.com/zachcannon */

public interface Tile {

    void setNextTile(Tile nextTile);

    Tile getNextTile();

    void interactWithTileAction(Player player);

}