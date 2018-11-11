import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            BigInteger n = new BigInteger(s);
            BigInteger a = n;
            BigDecimal b = new BigDecimal(n);
            while ((a.pow(3)).compareTo(n) == 1) {
                a = ((a.multiply(BigInteger.valueOf(2))).add((n).divide(a.pow(2)))).divide(BigInteger.valueOf(3));
                if(!((a.pow(3)).compareTo(n) == 1) || a.pow(3).compareTo(n) == 0) {
                    b = new BigDecimal(a);
                    BigDecimal t1 = b.pow(2);
                    b = ((b.multiply(BigDecimal.valueOf(2))).add((new BigDecimal(n)).divide(new BigDecimal(t1.toString()), BigDecimal.ROUND_HALF_UP))).divide(BigDecimal.valueOf(3), BigDecimal.ROUND_HALF_UP);
                    break;
                }
            }

            System.out.println(b.toString());
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStreamReader inputStreamReader) {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }


}