import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt(), P = sc.nextInt(), l = 0;
        ArrayList<Integer> a = new ArrayList<>();
        int[] p = new int[P+2];
        p[0] = 0;
        for (int i = 1; i < P+1; i++) {
            p[i] = sc.nextInt();
        }
        p[P+1] = W;
        for (int i = 0; i < P+1; i++) {
            for (int j = 1; j < P+2-l; j++) {
                a.add(p[j+l]-p[j-1]);
            }
            l++;
        }
        Collections.sort(a);
        for (int i = 0; i < a.size()-1; i++) {
            if(a.get(i).equals(a.get(i+1))){
                a.remove(i);
                i--;
            }
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if(i == a.size()-1)
                System.out.print(a.get(i));
            else
                System.out.print(a.get(i) + " ");
        }

    }

}