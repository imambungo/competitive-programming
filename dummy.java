import java.util.Scanner;
import java.util.Arrays;
class dummy {
    static String sortStringByChar(String lastArmyStanding) {
        char[] tempArray = lastArmyStanding.toCharArray();
        Arrays.sort(tempArray);
        String sorted = new String(tempArray);
        return sorted;
    }
    public static void main(String[] args) {
        String a = "dcba";
        a = sortStringByChar(a);
        System.out.println(a);
    }
}