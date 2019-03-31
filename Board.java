/* Board.java */

import java.util.ArrayList;

public class Board {
    public Tile[] tile = new Tile[BOARD_SIZE];
    public Player n;

    public static final int BOARD_SIZE = 40;

    public Board() {
        n = new Player("STATEBANKDEFAULT");
        System.out.println("created "+n.getId());

        // Space
        tile[0] = new Start(n);
        tile[2] = new DanaUmum(n);
        tile[4] = new PajakJalan(n);
        tile[7] = new Kesempatan(n, this);
        tile[10] = new Jail(n);
        tile[17] = new DanaUmum(n);
        tile[20] = new FreePark(n);
        tile[22] = new Kesempatan(n, this);
        tile[30] = new GoToJail(n);
        tile[33] = new DanaUmum(n);
        tile[36] = new Kesempatan(n, this);
        tile[38] = new PajakIstimewa(n);

        // Lot
        tile[1] = new Lot("Monas", true, 1, 60 , n);
        tile[3] = new Lot("Taman Mini", true, 1, 60, n);
        tile[6] = new Lot("Ragunan Pasar Minggu", true, 2, 100 , n);
        tile[8] = new Lot("Binaria", true, 2, 100, n);
        tile[9] = new Lot("Taman Pluit", true, 2, 120, n);
        tile[11] = new Lot("Kebun Raya Bogor", true, 3, 140, n);
        tile[13] = new Lot("Pelabuhan Ratu", true, 3, 140, n);
        tile[14] = new Lot("Tangkuban Perahu", true, 3, 160, n);
        tile[16] = new Lot("Gunung Batu", true, 4, 180, n);
        tile[18] = new Lot("Kopeng", true, 4, 180, n);
        tile[19] = new Lot("Borobudur", true, 4, 200, n);
        tile[21] = new Lot("Prambanan", true, 5, 220, n);
        tile[23] = new Lot("Kraton Yogya", true, 5, 220, n);
        tile[24] = new Lot("Bengawan Solo", true, 5, 240, n);
        tile[26] = new Lot("Sarangan", true, 6, 260, n);
        tile[27] = new Lot("Selecta", true, 6, 260, n);
        tile[29] = new Lot("Gunung Kiwi", true, 6, 280, n);
        tile[31] = new Lot("Pantai Sanur", true, 7, 300, n);
        tile[32] = new Lot("Tampak Siring", true, 7, 300, n);
        tile[34] = new Lot("Taman Laut Banda", true, 7, 320, n);
        tile[37] = new Lot("Danau Toba", true, 8, 350, n);
        tile[39] = new Lot("Brastagi", true, 8, 400, n);

        // Railroad
        tile[5] = new Railroad("Bandara Kemayoran", true, 9, 200, n);
        tile[15] = new Railroad("Terminal Bis Semarang", true, 9, 200, n);
        tile[25] = new Railroad("Stasiun Pasar Turi", true, 9, 200, n);
        tile[35] = new Railroad("Pelabuhan Belawan", true, 9, 200, n);

        // Utilities
        tile[12] = new Utilities("Perusahaan Listrik", true, 10, 150, n);
        tile[28] = new Utilities("Perusahaan Air", true, 10, 150, n);

    }

}
