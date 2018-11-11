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
    private static double n;
    public static void main(String[] args) throws IOException {
        //Scanner scan = new Scanner(System.in);
        FastReader s = new FastReader(new InputStreamReader(System.in));

        String number = s.nextLine();
        n = number.length();

        if(n > 158){
            double current;
            double previous = 2;

            double h = 1e-8;
            double error;
            int i = 0;
            double relError = 0.00001;
            while (true) {
                current = previous - func(previous) / ((func(previous) - func(previous - h)) / h);
                error = Math.abs((current - previous) / previous);
                if (error < relError || i >= 100)
                    break;
                i++;
                previous = current;
            }
            System.out.println((int)current);
        }
        else{
            BigInteger bi = new BigInteger(number);
            BigInteger result = BigInteger.valueOf(0);
            boolean finished = false;
            int i = 1;
            while(!finished) {
                BigInteger divisor = BigInteger.valueOf(i);
                result = bi.divide(divisor);
                if (i == bi.intValue()) {
                    System.out.println(i);
                    finished = true;
                }
                i++;
                bi = new BigInteger(result.toString());
            }
        }



    }


    private static double func(double x){
        return (((x*Math.log(x)-x)/Math.log(10)) - n);
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