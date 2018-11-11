

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            String string = scan.nextLine();
            long length = string.length();


            BigInteger output = fac(BigInteger.valueOf(length));

            int[] alphabet = new int[52];

            for(int i = 0; i < length; i++){
                if(string.charAt(i) >= 65 && string.charAt(i) <= 90){
                    alphabet[string.charAt(i)-65]++;
                }
                if(string.charAt(i) >= 97 && string.charAt(i) <= 122){
                    alphabet[string.charAt(i)-71]++;
                }
            }

            for(int i = 0; i < 52; i++){
                if(alphabet[i] > 1){
                    output = output.divide(fac(BigInteger.valueOf(alphabet[i])));
                }
            }

            System.out.println(output);

        }

    }


    public static BigInteger fac(BigInteger n){
        BigInteger fact = BigInteger.valueOf(1);
        boolean stop = false;
        while(n.compareTo(BigInteger.ONE) == 1) {
            fact = new BigInteger(fact.toString()).multiply(new BigInteger(n.toString()));
            n = n.subtract(BigInteger.valueOf(1));
        }
        return fact;
    }
}
