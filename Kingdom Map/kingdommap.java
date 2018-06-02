import java.util.Scanner;
import java.util.Arrays;

class kingdommap{
    static String armiesInRegion = "";
    static String sortStringByChar(String lastArmyStanding){
        char[] tempArray = lastArmyStanding.toCharArray();
        Arrays.sort(tempArray);
        String sorted = new String(tempArray);
        return sorted;
    }
    static String ubahCharKe(String word, int k){
        String wordBaru = word.substring(0, k) + '#' + word.substring(k+1, word.length());
        return wordBaru;
    }
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
    static void checkAt(words[] words,int i, int j, int k){
        if(words[i].word[j].charAt(k) != '#'){
            if(words[i].word[j].charAt(k) != '.'){
                armiesInRegion += words[i].word[j].charAt(k);
            }
            words[i].word[j] = ubahCharKe(words[i].word[j], k);
            if(j > 0){
                checkAt(words, i, j-1, k);
            }
            if(k > 0){
                checkAt(words, i, j, k-1);
            }
            if(j < words[i].word.length-1){
                checkAt(words, i, j+1, k);
            }
            if(k < words[i].word[j].length()-1){
                checkAt(words, i, j, k+1);
            }
        }
        // System.out.println(words[i].word[j].charAt(k));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i,j,k;
        words[] words = new words[T];
        for (i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            words[i] = new words();
            words[i].word = new String[N];
            for (j = 0; j < N; j++) {
                words[i].word[j] = sc.next();
            }
        }
        for (i = 0; i < T; i++) {
            int contested = 0;
            String lastArmyStanding = "";
            System.out.println("Case "+(i+1)+":");
            for (j = 0; j < words[i].word.length; j++) {
                for (k = 0; k < words[i].word[j].length(); k++) {
                    checkAt(words,i,j,k);
                    if(cekContested()){
                        contested++;
                    }else if(armiesInRegion.length() != 0){
                        lastArmyStanding += armiesInRegion.charAt(0);
                    }
                    armiesInRegion = "";
                }
            }
            lastArmyStanding = sortStringByChar(lastArmyStanding);
            System.out.println("Contested "+contested);
        }
    }
}

class words {
    String[] word;
}