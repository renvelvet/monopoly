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
        else if (TileNumber == 2) return createPropertyTile("Monas", 60, a, 1, 1);
        else if (TileNumber == 3) return createSpaceTile("Dana Umum", 
        else if (TileNumber == 4) return createPropertyTile("Taman Mini", 60, a, 2, 1);
        else if (TileNumber == 5) return createSpaceTile("Pajak Jalan", 200,
        else if (TileNumber == 6) return createPropertyTile("Bandara Kemayoran", 200, 9);
        else if (TileNumber == 7) return createPropertyTile("Ragunan Pasar Minggu", 100, b, 1, 2);
        else if (TileNumber == 8) return createSpaceTile("Kesempatan",
        else if (TileNumber == 9) return createPropertyTile("Binaria", 100, b, 2, 2);
        else if (TileNumber == 10) return createPropertyTile("Taman Pluit", 120, b, 3, 2);
        else if (TileNumber == 11) return createSpaceTile("Penjara",
        else if (TileNumber == 12) return createPropertyTile("Kebun Raya Bogor", 140, c, 1, 3);
        else if (TileNumber == 13) return createPropertyTile("Perusahaan Listrik", 150, PLN, 10);
        else if (TileNumber == 14) return createPropertyTile("Pelabuhan Ratu", 140, c, 2, 3);
        else if (TileNumber == 15) return createPropertyTile("Tangkuban Perahu", 160, c, 3, 3);
        else if (TileNumber == 16) return createPropertyTile("Terminal Bis Semarang", 200, 9);
        else if (TileNumber == 17) return createPropertyTile("Gedung Batu", 180, d, 1, 4);
        else if (TileNumber == 18) return createSpaceTile("Dana Umum", 
        else if (TileNumber == 19) return createPropertyTile("Kopeng", 180, d, 2, 4);
        else if (TileNumber == 20) return createPropertyTile("Borobudur", 200, d, 3, 4);
        else if (TileNumber == 21) return createSpaceTile("Parkir Bebas", 
        else if (TileNumber == 22) return createPropertyTile("Prambanan", 220, e, 1, 5);
        else if (TileNumber == 23) return createSpaceTile("Kesempatan",
        else if (TileNumber == 24) return createPropertyTile("Kraton Yogya", 220, e, 2, 5);
        else if (TileNumber == 25) return createPropertyTile("Bengawan Solo", 240, e, 3, 5);
        else if (TileNumber == 26) return createPropertyTile("Stasiun Pasar Turi", 200, 9);
        else if (TileNumber == 27) return createPropertyTile("Sarangan", 260, f,1, 6);
        else if (TileNumber == 28) return createPropertyTile("Selecta", 260, f, 2, 6);
        else if (TileNumber == 29) return createPropertyTile("Perusahaan Air", 150, PAM, 10);
        else if (TileNumber == 30) return createPropertyTile("Gunung Kiwi", 280, f, 3, 6);
        else if (TileNumber == 31) return createSpaceTile("Pergi ke Penjara",
        else if (TileNumber == 32) return createPropertyTile("Pantai Sanur", 300, g, 1, 7);
        else if (TileNumber == 33) return createPropertyTile("Tampak Siring", 300, g, 2, 7);
        else if (TileNumber == 34) return createSpaceTile("Dana Umum",
        else if (TileNumber == 35) return createPropertyTile("Taman Laut Banda", 320, g, 3, 7);
        else if (TileNumber == 36) return createPropertyTile("Pelabuhan Belawan", 200, 9);
        else if (TileNumber == 37) return createSpaceTile("Kesempatan", 
        else if (TileNumber == 38) return createPropertyTile("Danau Toba", 350, h, 1, 8);
        else if (TileNumber == 39) return createSpaceTile("Pajak Istimewa", 100,
        else if (TileNumber == 40) return createPropertyTile("Brastagi", 400, h, 2, 8);

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
