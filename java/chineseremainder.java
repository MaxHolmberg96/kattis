import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    private static int a;
    private static int n;
    private static int b;
    private static int m;
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        FastReader s = new FastReader(new InputStreamReader(System.in));
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            String[] number = s.nextLine().split(" ");
            a = Integer.parseInt(number[0]);
            n = Integer.parseInt(number[1]);
            b = Integer.parseInt(number[2]);
            m = Integer.parseInt(number[3]);
            BigInteger K = new BigInteger(Integer.toString(n)).multiply(new BigInteger(Integer.toString(m)));

            System.out.println((BigInteger.valueOf(a).multiply(BigInteger.valueOf(m)).multiply(BigInteger.valueOf(m).modInverse(BigInteger.valueOf(n))).add(BigInteger.valueOf(b).multiply(BigInteger.valueOf(n)).multiply(BigInteger.valueOf(n).modInverse(BigInteger.valueOf(m))))).mod((BigInteger.valueOf(n).multiply(BigInteger.valueOf(m)))) + " " + K);
            //(a*m*inv(m,n) + b*n*inv(n,m)) % (n*m)
        }

    }


    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStreamReader inputStreamReader)
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }


}