import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        FastReader s = new FastReader(new InputStreamReader(System.in));
        String st;
        while((st = s.nextLine()) != null){
            String[] split = st.split(" ");
            int first = Integer.parseInt(split[0]);
            int last = Integer.parseInt(split[1]);
            if(first + last == 13){
                System.out.println("Never speak again.");
            }
            else if(first > last){
                System.out.println("To the convention.");
            }
            else if(first < last){
                System.out.println("Left beehind.");
            }
            else if(first == last && (first != 0 && last != 0)){
                System.out.println("Undecided.");
            }
            else{
                break;
            }

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

