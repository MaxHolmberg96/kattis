import java.io.*;
import java.util.*;
public class main {
    private static HashMap<Integer, Double> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        facDigitsSTORE(1000000);
        StreamTokenizer tf = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int scan;
        while ((scan = tf.nextToken()) != StreamTokenizer.TT_EOF) {
            if((int)tf.nval == 0 || (int)tf.nval == 1)
                System.out.println(1);
            else
                System.out.println((int)Math.floor(map.get((int)tf.nval)));
        }
    }

    private static long facDigitsSTORE(long n){
        double digits = 0;
        for(int i = 2; i <= n; i++){
            digits += Math.log10(i);
            map.put(i, digits+1);
        }
        return (long)digits+1;
    }
}
