import java.util.Scanner;
import java.util.Arrays;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.File;

class kingdommap{
	public static void main(String[] args) {
        // to avoid stack overflow:
        // javac kingdommap.java
        // java -Xss4m kingdommap
		// for linux user, to copy content of input.in, run:    xclip -sel clip < input.in

		// Untuk ngeprint output ke file output.txt
		/////////////////////////////////////////////////////////
        try {                                                  //
            File file = new File("output.txt");                //
            FileOutputStream fos = new FileOutputStream(file); //
            PrintStream ps = new PrintStream(fos);             //
            System.setOut(ps);                                 //
        } catch (FileNotFoundException e) {                    //
            e.printStackTrace();                               //
        }                                                      //

        Scanner sc = new Scanner(System.in);
        int banyakTestCase = sc.nextInt();
        int i, j, k;


        Map[] arrayOfMap = new Map[banyakTestCase];// Bikin array of Map
        for (i = 0; i < banyakTestCase; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            arrayOfMap[i] = new Map();
            arrayOfMap[i].baris = new String[N];
            for (j = 0; j < N; j++)
			{
				// Nerima String baris ke-j dari map testCase ke-j
                arrayOfMap[i].baris[j] = sc.next();
            }
        }
        for (i = 0; i < banyakTestCase; i++) {
            int contested = 0;// Jumlah region di map i yg punya 2 atau lebih huruf yg berbeda
            String lastArmyStanding = "";
            System.out.println("Case "+(i+1)+":");

			// Looping sebanyak baris Map testCase ke-i
            for (j = 0; j < arrayOfMap[i].baris.length; j++)
			{
				// Looping sebanyak jumlah karakter dari baris ke-j Map ke-i
                for (k = 0; k < arrayOfMap[i].baris[j].length(); k++)
				{
                    kirimTimPencari(arrayOfMap, i, j, k);
                    if(checkContested()){
                        contested++;
                    }else if(armiesInRegion.length() != 0){
                        lastArmyStanding += armiesInRegion.charAt(0);
                    }
                    armiesInRegion = "";
                }
            }
            lastArmyStanding = sortStringByChar(lastArmyStanding);
            if(lastArmyStanding.length() != 0){
                printArmies(lastArmyStanding);
            }
            System.out.println("contested "+contested);
        }
    }

    static String armiesInRegion = "";

    static void printArmies(String lastArmyStanding){
        char patokan = lastArmyStanding.charAt(0);
        int count = 0;
        for (int i = 0; i < lastArmyStanding.length(); i++) {
            if(lastArmyStanding.charAt(i) == patokan){
                count++;
            }else{
                System.out.println(patokan+" "+count);
                count = 1;
                patokan = lastArmyStanding.charAt(i);
            }
            if(i == lastArmyStanding.length()-1){
                System.out.println(patokan + " " + count);
            }
        }
    }

    static String sortStringByChar(String lastArmyStanding){
        char[] tempArray = lastArmyStanding.toCharArray();
        Arrays.sort(tempArray);
        String sorted = new String(tempArray);
        return sorted;
    }

	// Ini adalah fungsi untuk merubah karakter ke-k dari sebuah String menjadi '#'
    static String ubahCharKe(String baris, int k){
        String barisBaru = baris.substring(0, k) + '#' + baris.substring(k+1);
		// Read about substring:	https://www.javatpoint.com/substring
        return barisBaru;
    }

	// Cek apakah region di map punya 2 atau lebih huruf yg berbeda
    static boolean checkContested(){
        if(armiesInRegion.length() == 0){
            return false;
        }
        char patokan = armiesInRegion.charAt(0);
        for (int i = 1; i < armiesInRegion.length(); i++) {
            if(armiesInRegion.charAt(i) != patokan){
                return true;
            }
        }
        return false;
    }

	// Adalah method untuk mengecek karakter pada suatu koordinat (j,k) di map ke-i.
		// Tidak hanya itu, setelah mengecek suatu koordinat, tim pencari akan berpencar
		// ke segala penjuru dan menandai daerah yg sudah dicek oleh mereka
		// sehingga daerah yg sudah dicek tidak perlu dicek ulang oleh tim pencari lain
		// Keterangan: j -> baris; k -> kolom.
    static void kirimTimPencari(Map[] arrayOfMap,int i, int j, int k)
	{
		// Kalau '#', itu berarti gunung atau jalan yg sudah ditempuh/dicek sebelumnya,
			// jidak perlu disusuri lagi.
        if(arrayOfMap[i].baris[j].charAt(k) != '#')
		{
			// Tapi kalau bukan,

            if(arrayOfMap[i].baris[j].charAt(k) != '.'){
				// Kalau bukan '.', pasti salah satu faction
				// Masukkan karakter faction tersebut ke dalam static String daftar tim pencari
                armiesInRegion += arrayOfMap[i].baris[j].charAt(k);
            }

			// Tandai koordinat ini sudah dicek dengan merubah karakter ke-k pada String baris ke-j
            arrayOfMap[i].baris[j] = ubahCharKe(arrayOfMap[i].baris[j], k);

			// Lanjutkan perjalanan, berpencar.

			// Selagi belum di perbatasan sebelah utara,
            if(j > 0){
				// Kirim tim pencari ke arah utara
                kirimTimPencari(arrayOfMap, i, j-1, k);
            }

			// Selagi belum di perbatasan sebelah barat,
            if(k > 0){
				// Kirim tim pencari ke arah barat
                kirimTimPencari(arrayOfMap, i, j, k-1);
            }

			// Selagi belum di perbatasan sebelah selatan,
            if(j < arrayOfMap[i].baris.length-1){
				// Kirim tim pencari ke arah selatan
                kirimTimPencari(arrayOfMap, i, j+1, k);
            }

			// Selagi belum di perbatasan sebelah timur,
            if(k < arrayOfMap[i].baris[j].length()-1){
				// Kirim tim pencari ke arah timur
                kirimTimPencari(arrayOfMap, i, j, k+1);
            }
        }
    }
}

class Map {
    String[] baris;// Setiap Map punya array of baris, mulai dari baris[0] (baris pertama) dst.
}
