import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] a = new int[6];
        int[] perfect = new int[6];
        for(int i = 0; i < 6; i++){
            a[i] = scan.nextInt();
        }
        perfect[0] = 1;
        perfect[1] = 1;
        perfect[2] = 2;
        perfect[3] = 2;
        perfect[4] = 2;
        perfect[5] = 8;

        for(int i = 0; i < 6; i++){
            if(a[i] != perfect[i]){
                System.out.print(perfect[i] - a[i] + " ");
            }
            else
                System.out.print("0 ");
        }

    }
}
