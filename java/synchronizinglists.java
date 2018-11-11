import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.nextLine()).equals("0")){
            int n = Integer.parseInt(s);
            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            ArrayList<Integer> l3 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l1.add(Integer.parseInt(sc.nextLine()));
            }
            for (int i = 0; i < n; i++) {
                l2.add(Integer.parseInt(sc.nextLine()));
            }
            for (int i = 0; i < n; i++) {
                l3.add(l1.get(i));
            }
            Collections.sort(l1);
            Collections.sort(l2);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(l1.get(i), l2.get(i));
            }
            for (int i = 0; i < n; i++) {
                System.out.println(map.get(l3.get(i)));
            }
            System.out.println();
        }
    }
}

