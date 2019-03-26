/* Board.java */
/* Modified Board.java from github.com/zachcannon */

import java.util.ArrayList;

public class Board {
    private Tile startTile;
    private ArrayList<Space> spaceTiles = new ArrayList<Space>();
    private ArrayList<ArrayList<Property>> propertyGroups = new ArrayList<ArrayList<Property>>();

    public static final int BOARD_SIZE = 40;

    public Board() {
        initializePropertyArrayList();
        createBoard();
        setTileGroupOfTiles();
    }

    private void createBoard() {
        startTile = createNextTile(1);
        Tile currentTile = startTile;

        for(int i=2; i<=BOARD_SIZE; i++) {
        currentTile.setNextTile(createNextTile(i));
        currentTile = currentTile.getNextTile();
        }

        currentTile.setNextTile(startTile);
    }

    private Tile createNextTile(int TileNumber) {
        if (TileNumber == 1) return new GoStart();
        else if (TileNumber == 2) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 3) return
        else if (TileNumber == 4) return
        else if (TileNumber == 5) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 6) return
        else if (TileNumber == 7) return
        else if (TileNumber == 8) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 9) return
        else if (TileNumber == 10) return
        else if (TileNumber == 11) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 12) return
        else if (TileNumber == 13) return
        else if (TileNumber == 14) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 15) return
        else if (TileNumber == 16) return
        else if (TileNumber == 17) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 18) return
        else if (TileNumber == 19) return
        else if (TileNumber == 20) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 21) return
        else if (TileNumber == 22) return
        else if (TileNumber == 23) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 24) return
        else if (TileNumber == 25) return
        else if (TileNumber == 26) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 27) return
        else if (TileNumber == 28) return
        else if (TileNumber == 29) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 30) return
        else if (TileNumber == 31) return
        else if (TileNumber == 32) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 33) return
        else if (TileNumber == 34) return
        else if (TileNumber == 35) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 36) return
        else if (TileNumber == 37) return
        else if (TileNumber == 38) return createPropertyTile("Monas", 60, 2 ,0);
        else if (TileNumber == 39) return
        else if (TileNumber == 40) return

        else return new GeneralTile();
        }

    // Menciptakan Lot
    private Tile createPropertyTile(String name, int price, char area, int numHouse, int groupNumber) {
        Property propertyTile = new Lot(name, price, area, numHouse);
        propertyGroups.get(groupNumber).add(propertyTile);
        return propertyTile;
        }
    // Menciptakan Railroad
    // groupNumber
    private Tile createPropertyTile(String name, int price, int groupNumber) {
        Property propertyTile = new Railroad(name, price);
        propertyGroups.get(groupNumber).add(propertyTile);
        return propertyTile;
    }
    // Menciptakan Utilites
    private Tile createPropertyTile(String name, int price, String p, int groupNumber) {
        Property propertyTile = new Utilities(name, price, p);
        propertyGroups.get(groupNumber).add(propertyTile);
        return propertyTile;
    }

    // Menciptakan Space
    private Tile createSpaceTile(String TileName) {
        Space sTile = new Space(TileName);
        spaceTiles.add(sTile);
        return sTile;
        }

    private void setTileGroupOfTiles() {
        for(Property Tile : spaceTiles)
        {
            Tile.setGroup(spaceTiles);
        }

        for(ArrayList<Property> groupList : propertyGroups)
        {
            for(Property Tile : groupList)
            {
                Tile.setGroup(groupList);
            }
        }

    }

    private void initializePropertyArrayList() {
        for (int i=0; i<8; i++)
        {
            propertyGroups.add(new ArrayList<Property>());
        }
    }

    public Tile getInitialTile() {return startTile;}

}
