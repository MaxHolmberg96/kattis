//import Algorithms.FenwickTree;
//import Math.*;


import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while(sc.hasNextLine()){
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                if(map.containsKey(s[i].toLowerCase())){
                    System.out.print(". ");
                }
                else{
                    System.out.print(s[i] + " ");
                    map.put(s[i].toLowerCase(), 1);
                }
            }
            System.out.println();
        }
    }
}


class FastReader
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