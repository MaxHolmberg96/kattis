import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class jollyjumpers {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        String s;
        while((s = sc.getLine()) != null) {
            int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> absDiffs = new ArrayList<>();
            boolean jolly = true;
            for (int i = 1; i < arr.length-1; i++) {
                absDiffs.add(Math.abs(arr[i] - arr[i+1]));
            }
            Collections.sort(absDiffs);
            int index = 0;
            for (int i = 1; i < arr[0]; i++) {
                if(absDiffs.get(index++) != i) {
                    jolly = false;
                }
            }
            System.out.println(jolly ? "Jolly" : "Not jolly");

        }
    }

}
