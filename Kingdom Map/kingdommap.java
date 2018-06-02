import java.util.Scanner;

class kingdommap{
    static String armiesInRegion = "";
    static String ubahCharKe(String word, int k){
        String wordBaru = word.substring(0, k) + '#' + word.substring(k+1, word.length());
        return wordBaru;
    }
    static void checkAt(words[] words,int i, int j, int k){
        if(words[i].word[j].charAt(k) != '#'){
            if(words[i].word[j].charAt(k) != '.'){
                armiesInRegion += words[i].word[j].charAt(k);
            }
            words[i].word[j] = ubahCharKe(words[i].word[j], k);
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
            for (j = 0; j < words[i].word.length; j++) {
                for (k = 0; k < words[i].word[j].length(); k++) {
                    checkAt(words,i,j,k);
                    armiesInRegion = "";
                }
            }
        }
    }
}

class words {
    String[] word;
}