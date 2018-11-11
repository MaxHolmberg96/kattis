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
        int b = sc.nextInt(), k = sc.nextInt(), safe_k = sc.nextInt();
        int nr_grps = k/safe_k;
        int rem_b = b;
        int days = 0;
        while(rem_b > 1){
            for (int i = 0; i < nr_grps; i++) {
                rem_b -= 1;
            }
            days++;
        }
        System.out.println(days);
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


