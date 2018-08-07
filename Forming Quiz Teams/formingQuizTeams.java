import java.util.Scanner;
import java.text.DecimalFormat;

class formingQuizTeams {
    static boolean[] H;
    static int[] x;
    static int[] y;
    static int caseCounter = 0;
    static String output = "";
    static double minimumSementara = 0;
    static double minimumSebenarnya = -1;
    static Scanner sc = new Scanner(System.in);

    // untuk hitung jarak antara 2 rumah
    static double hitungJarak(int x1, int y1, int x2, int y2) {
        int x = x2 - x1;
        int y = y2 - y1;
        double hasil = Math.sqrt((x * x) + (y * y));
        return hasil;
    }

    // rekursi utk mencari kombinasi pengecekan rumah
    static void findEm(int houses) {
        if (!belumFull()) {
            if (minimumSebenarnya == -1) {
                minimumSebenarnya = minimumSementara;
                return;
            }
            if (minimumSementara < minimumSebenarnya) {
                minimumSebenarnya = minimumSementara;
            }
            return;
        }
        int rumah1 = cariRumah();
        for (int i = rumah1 + 1; i < H.length; i++) {
            if (H[i] == false) {
                double save = minimumSementara;
                minimumSementara += hitungJarak(x[rumah1], y[rumah1], x[i], y[i]);
                H[i] = true;
                findEm(houses - 2);
                minimumSementara = save;
                H[i] = false;
            }
        }
        H[rumah1] = false;
    }

    // untuk ngecek jika masih ada rumah yg belum dicek utk suatu kombinasi
    static boolean belumFull() {
        for (int i = 0; i < H.length; i++) {
            if (H[i] == false) {
                return true;
            }
        }
        return false;
    }

    // untuk cari 1 rumah yg belum dicek, (paling kiri)
    static int cariRumah() {
        for (int i = 0; i < H.length; i++) {
            if (H[i] == false) {
                H[i] = true;
                return i;
            }
        }
        return -1;
    }

    // untuk bbrp kali testcase
    static void virtualMain(int N){
        // Scanner sc = new Scanner(System.in);
        H = new boolean[2 * N];
        x = new int[2 * N];
        y = new int[2 * N];
        for (int i = 0; i < H.length; i++) {
            sc.next();
            // System.out.println("sc.next() >>> done");
            x[i] = sc.nextInt();
            // System.out.println("x[i] = sc.nextInt(); >>> done");
            y[i] = sc.nextInt();
            // System.out.println("y[i] = sc.nextInt(); >>> done");
            // sc.nextLine();
        }
        findEm(2 * N);
        DecimalFormat df = new DecimalFormat("0.00");
        caseCounter++;
        output += "Case "+caseCounter+": "+df.format(minimumSebenarnya)+"\n";
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int N = 1;
        while (N > 0) {
            N = sc.nextInt();
            // System.out.println("N = sc.nextInt();");
            if (N > 0) {
                // sc.nextLine();
                virtualMain(N);
                minimumSementara = 0;
                minimumSebenarnya = -1;
            }
        }
        System.out.print(output);
        sc.close();
    }

}