import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int b = scan.nextInt();
            if(b == 0)
                break;

            String[] split = scan.nextLine().split(" ");
            BigInteger p = new BigInteger(split[1], b);
            BigInteger m = new BigInteger(split[2], b);

            System.out.println(Integer.toString(p.mod(m).intValue(), b));
        }

    }
}

