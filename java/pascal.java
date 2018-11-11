import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class main {
    private static HashMap<Integer, Double> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        StreamTokenizer tf = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int scan;
        if ((scan = tf.nextToken()) != StreamTokenizer.TT_EOF) {
            int N = (int) tf.nval;
            if(checkPrime(N)) {
                System.out.println(N - 1);
                return;
            }
            //N--;
            int d = 1;
            for (int i = 2; i < N; i++) {
                if (N % i == 0) {
                    d = i;
                    break;
                }
            }

            int p = N / d;
            System.out.println((N) - p);
        }
    }

    private static int frane(int N){
        int counter = 0;
        for(int i = N-1; i >= 1; i--){
            counter += 1;
            if(N % i == 0)
                break;
        }
        return counter;
    }

    private static boolean checkPrime(int n){
        if(n == 2)
            return true;

        if(n % 2 == 0)
            return false;
        for(long i = 3; ; i+= 2)
        {
            long q = n/i;
            if(q <i)
                return true;
            if(n == q*i)
                return false;
        }
    }




}