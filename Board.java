/* Board.java */

import java.util.ArrayList;

public class Board {
    public Tile[] tile;

    public static final int BOARD_SIZE = 40;

    public Board() {
        // Space
        tile[0] = new Start();
        tile[2] = new DanaUmum();
        tile[4] = new PajakJalan();
        tile[7] = new Kesempatan();
        tile[10] = new Jail();
        tile[17] = new DanaUmum();
        tile[20] = new FreePark();
        tile[22] = new Kesempatan();
        tile[30] = new GoToJail();
        tile[33] = new DanaUmum();
        tile[36] = new Kesempatan();
        tile[38] = new PajakIstimewa();

        // Lot
        tile[1] = new Lot("Monas", true, 1, 60);
        tile[3] = new Lot("Taman Mini", true, 1, 60);
        tile[6] = new Lot("Ragunan Pasar Minggu", true, 2, 100 );
        tile[8] = new Lot("Binaria", true, 2, 100);
        tile[9] = new Lot("Taman Pluit", true, 2, 120);
        tile[11] = new Lot("Kebun Raya Bogor", true, 3, 140);
        tile[13] = new Lot("Pelabuhan Ratu", true, 3, 140);
        tile[14] = new Lot("Tangkuban Perahu", true, 3, 160);
        tile[16] = new Lot("Gunung Batu", true, 4, 180);
        tile[18] = new Lot("Kopeng", true, 4, 180);
        tile[19] = new Lot("Borobudur", true, 4, 200);
        tile[21] = new Lot("Prambanan", true, 5, 220);
        tile[23] = new Lot("Kraton Yogya", true, 5, 220);
        tile[24] = new Lot("Bengawan Solo", true, 5, 240);
        tile[26] = new Lot("Sarangan", true, 6, 260);
        tile[27] = new Lot("Selecta", true, 6, 260);
        tile[29] = new Lot("Gunung Kiwi", true, 6, 280);
        tile[31] = new Lot("Pantai Sanur", true, 7, 300);
        tile[32] = new Lot("Tampak Siring", true, 7, 300);
        tile[34] = new Lot("Taman Laut Banda", true, 7, 320);
        tile[37] = new Lot("Danau Toba", true, 8, 350);
        tile[39] = new Lot("Brastagi", true, 8, 400);

        // Railroad
        tile[5] = new Railroad("Bandara Kemayoran", true, 9, 200);
        tile[15] = new Railroad("Terminal Bis Semarang", true, 9, 200);
        tile[25] = new Railroad("Stasiun Pasar Turi", true, 9, 200);
        tile[35] = new Railroad("Pelabuhan Belawan", true, 9, 200);

        // Utilities
        tile[12] = new Utilities("Perusahaan Listrik", true, 10, 150);
        tile[28] = new Utilities("Perusahaan Air", true, 10, 150);

    }

}
