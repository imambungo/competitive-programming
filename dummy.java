import java.util.Scanner;
class dummy {
    static String ubahCharKe(String word, int k) {
        String wordBaru = word.substring(0, k) + '#' + word.substring(k + 1, word.length());
        return wordBaru;
    }
    public static void main(String[] args) {
        String a = "jjjjjjjjjjjjjjj";
        a = ubahCharKe(a, 3);
        System.out.println(a);
    }
}