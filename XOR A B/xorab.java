import java.util.Scanner;
class xorab {
    static long a;
    static long b;
    static long c;
    static long i;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        a = Long.parseUnsignedLong(s);
        s = sc.next();
        b = Long.parseUnsignedLong(s);
        c = a;
        for (i = a+1; i <= b; i++) {
            c = c^i;
        }
        System.out.println(Long.toBinaryString(c));
    }
}