import java.util.Scanner;
import java.math.*;
class xorab {
    static boolean lessEqualBigInteger(BigInteger i, BigInteger b){
      int res = i.compareTo(b);
      if (res==0) {
          return true;
      } else if(res==1) {
          return false;
      } else if ( res == -1){
          return true;
      }
      return false;
    }

    public static void main(String[] args) {
        BigInteger a,b,c,i,d;
        Scanner sc = new Scanner(System.in);
        a = new BigInteger(sc.next());
        b = new BigInteger(sc.next());
        c = a;
        d = a.add(BigInteger.valueOf(1));
        for (i = d; lessEqualBigInteger(i,b); i=i.add(BigInteger.valueOf(1))) {
            c = c.xor(i);
        }
        System.out.println(c.toString(2));
    }
}