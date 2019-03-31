/* Board.java */

import java.util.ArrayList;

public class Board {
    public Tile[] tile;

    public static final int BOARD_SIZE = 40;

    public Board() {
        // Space
        tile[0] = new START();
        tile[2] = new DN();
        tile[4] = new PJ();
        tile[7] = new KS();
        tile[10] = new JAIL();
        tile[17] = new DN();
        tile[20] = new FP();
        tile[22] = new KS();
        tile[30] = new JAIL();
        tile[33] = new DN();
        tile[36] = new KS();
        tile[38] = new PJ();

        // Lot
        tile[1] = new Lot("Monas", true, 1, );
        tile[3] = new Lot("Taman Mini", true, 1, );
        tile[6] = new Lot("Ragunan Pasar Minggu", true, 2, );
        tile[8] = new Lot("Binaria", true, 2, );
        tile[9] = new Lot("Taman Pluit", true, 2, );
        tile[11] = new Lot("Kebun Raya Bogor", true, 3, );
        tile[13] = new Lot("Pelabuhan Ratu", true, 3, );
        tile[14] = new Lot("Tangkuban Perahu", true, 3, );
        tile[16] = new Lot("Gunung Batu", true, 4, );
        tile[18] = new Lot("Kopeng", true, 4, );
        tile[21] = new Lot("Prambanan", true, 5, );
        tile[23] = new Lot("Kraton Yogya", true, 5, );
        tile[24] = new Lot("Bengawan Solo", true, 5, );
        tile[26] = new Lot("Sarangan", true, 6, );
        tile[27] = new Lot("Selecta", true, 6, );
        tile[29] = new Lot("Gunung Kiwi", true, 6, );
        tile[31] = new Lot("Pantai Sanur", true, 7, );
        tile[32] = new Lot("Tampak Siring", true, 7, );
        tile[34] = new Lot("Taman Laut Banda", true, 7, );
        tile[37] = new Lot("Danau Toba", true, 8, );
        tile[39] = new Lot("Brastagi", true, 8, );

        // Railroad
        tile[5] = new Railroad("Bandara Kemayoran", true, 9, );
        tile[15] = new Railroad("Terminal Bis Semarang", true, 9, );
        tile[25] = new Railroad("Stasiun Pasar Turi", true, 9, );
        tile[35] = new Railroad("Pelabuhan Belawan", true, 9, );

        // Utilities
        tile[12] = new Utilities("Perusahaan Listrik", true, 10, );
        tile[28] = new Utilities("Perusahaan Air", true, 10, );

    }

}
