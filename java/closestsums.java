import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    static int lowest = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int k;
        while(sc.hasNext()) {
            k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> sums = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    sums.add(arr[i] + arr[j]);
                }
            }
            int q = sc.nextInt();
            System.out.println("Case " + a + ":");
            for (int i = 0; i < q; i++) {
                int qu = sc.nextInt();
                int RANGE = Integer.MAX_VALUE;
                int closestSUM = 0;
                for (int j = 0; j < sums.size(); j++) {
                    if (Math.abs(qu - sums.get(j)) < RANGE) {
                        RANGE = Math.abs(qu - sums.get(j));
                        closestSUM = sums.get(j);
                    }
                }
                System.out.println("Closest sum to " + qu + " is " + closestSUM + ".");
            }
            a++;
        }
    }

    static void combinations2(I[] arr, int len, int startPosition, I[] result){
        if (len == 0){
            int soursum = 1, bittersum = 0;
            for (int i = 0; i < result.length; i++) {
                soursum*= result[i].S;
                bittersum += result[i].B;
            }
            if(Math.abs(soursum-bittersum) < lowest){
                lowest = Math.abs(soursum-bittersum);
            }
            //System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

    static class I{
        int S, B;
        public I(int S, int B){
            this.S=S; this.B=B;
        }
        @Override
        public String toString(){
            return "S: " + S + ", B: " + B + "";
        }
    }
}


