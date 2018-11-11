import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(reader.readLine());
        int clean = 0;
        ArrayList<Integer> list = new ArrayList<>();
        String[] b = reader.readLine().split(" ");
        for (String s : b) {
            list.add(Integer.parseInt(s));
        }
        HashSet<Integer> c = new HashSet<>();
        for (int i = 1; i <= 365; i++) {
            if(list.contains(i)) {
                c.add(i);
            }

            int d = 0;
            for (Integer integer : c) {
                d += (i + 1) - integer;
            }

            if(d > 19) {
                clean++;
                c.clear();
            }
        }

        if(!c.isEmpty())
            clean++;
        System.out.println(clean);

    }
}