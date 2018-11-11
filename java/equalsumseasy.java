import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class equalsumseasy {

    private static ArrayList<Integer> set;
    private static HashMap<Integer, Integer[]> map;
    private static boolean found = false;
    private static Integer[] answer1;
    private static Integer[] answer2;

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int c = katt.getInt();
        for (int i = 0; i < c; i++) {
            int n = katt.getInt();
            set = new ArrayList<>(n);
            map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                set.add(katt.getInt());
            }
            for (int j = 1; j < set.size(); j++) {
                permutations(0, j, new Integer[j]);
            }
            System.out.println("Case #" + (i+1) + ":");
            if(answer1 == null || answer2 == null){
                System.out.println("Impossible");
            } else {
                for (int j = 0; j < answer1.length; j++) {
                    System.out.print(answer1[j] + " ");
                }
                System.out.println();
                for (int j = 0; j < answer2.length; j++) {
                    System.out.print(answer2[j] + " ");
                }
                System.out.println();
            }
            answer1 = null;
            answer2 = null;
            found = false;
        }
    }

    private static void permutations(int start, int length, Integer[] arr){
        //System.out.println(Arrays.toString(arr));
        if(length == 0){
            int sum = sum(arr);
            if(!found && map.containsKey(sum) && !equal(map.get(sum), arr)){
                answer1 = Arrays.copyOf(arr, arr.length);
                answer2 = map.get(sum);
                found = true;
            } else {
                map.put(sum, Arrays.copyOf(arr, arr.length));
            }
            return;
        }
        for (int i = start; i <= set.size() - length; i++) {
            arr[arr.length - length] =  set.get(i);
            permutations(i+1, length-1, arr);
        }
    }

    private static boolean equal(Integer[] arr1, Integer[] arr2) {
        if(arr1.length != arr2.length){
            return false;
        } else {
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            for (int i = 0; i < arr1.length; i++) {
                if(arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int sum(Integer[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { sum += arr[i]; }
        return sum;
    }

}
