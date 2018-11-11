import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Math.*;

public class cetiri {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        Arrays.sort(arr);
        if(abs(arr[0]-arr[1]) == abs(arr[1]-arr[2])){
            System.out.println(arr[2]+abs(arr[1]-arr[2]));
        } else if(abs(arr[0]-arr[1]) < abs(arr[1]-arr[2])){
            System.out.println(arr[1]+abs(arr[0]-arr[1]));
        } else {
            System.out.println(arr[0]+abs(arr[1]-arr[2]));
        }
    }
}