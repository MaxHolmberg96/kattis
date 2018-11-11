import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s;
        ArrayList<Integer> m = new ArrayList<>();
        int longest = 0;
        while(sc.hasNextLine()){
            s = sc.nextLine();
            m.add(s.length());
            if(s.length() > longest)
                longest = s.length();
        }
        int sum = 0;
        for (int j = 0; j < m.size()-1; j++) {
            sum += Math.pow(longest - m.get(j), 2);
        }
        System.out.println(sum);
    }
}

