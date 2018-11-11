import java.util.ArrayList;
import java.util.HashMap;

public class blackfriday {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int n = katt.getInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nr = katt.getInt();
            map.put(nr, map.getOrDefault(nr, 0)+1);
            indices.put(nr, i+1);
        }
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        arr.sort(Integer::compare);
        boolean t = false;
        for (int i = arr.size()-1; i >= 0; i--) {
            if(map.get(arr.get(i)) == 1){
                System.out.println(indices.get(arr.get(i)));
                t = true;
                return;
            }
        }
        if(!t){
            System.out.println("none");
        }
    }
}