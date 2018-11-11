import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        FastReader s = new FastReader(new InputStreamReader(System.in));
        String number = s.nextLine();
        int stringLength = number.length();
        while(number.length() % 4 != 0){
            number = "0" + number;
        }
        int res, padLength;
        String sub = number.substring(0, 4);
        res = Integer.parseInt(sub, 8);
        System.out.print(Integer.toString(res, 16).toUpperCase());


        for(int i = 4; i < stringLength; i+=4){
            sub = number.substring(i, i+4);
            res = Integer.parseInt(sub, 8);
            sub = Integer.toString(res, 16);
            padLength = 3 - (sub.length() % 3);
            if(padLength == 3)
                padLength = 0;
            for (int j = 0; j < padLength; j++) {
                sub = "0" + sub;
            }
            System.out.print(sub.toUpperCase());
        }
    }


    public static BigInteger base8to10(BigInteger n){
        String s = n.toString();
        int l = s.length() - 1;
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < s.length(); i++) {
            sum = sum.add((new BigInteger("8").pow(l)).multiply(BigInteger.valueOf(Integer.parseInt(s.substring(i, i+1)))));
            l--;
        }
        return sum;
    }

    public static String toUpperString(String pString) {
        if (pString != null) {
            char[] retChar = pString.toCharArray();
            for (int idx = 0; idx < pString.length(); idx++) {
                char c = retChar[idx];
                if (c >= 'a' && c <= 'z') {
                    retChar[idx] = (char) (c & -33);
                }
            }
            return new String(retChar);
        } else {
            return null;
        }
    }


    private static String toUpperCase(String str)
    {
        StringBuffer strBuf = new StringBuffer(str);
        char c;
        for(int i = 0; i < strBuf.length(); ++i)
        {
            c = Character.toUpperCase(strBuf.charAt(i));
            strBuf.setCharAt(i, c);
        }

        return strBuf.toString();
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