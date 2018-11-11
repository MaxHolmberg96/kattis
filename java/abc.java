
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();
        scan.nextLine();
        String string = scan.nextLine();

        int[] sortArr = new int[3];
        sortArr[0] = first;
        sortArr[1] = second;
        sortArr[2] = third;
        Arrays.sort(sortArr);


        for(int i = 0; i < 3; i++){
            if(string.charAt(i) == 'A')
                System.out.print(sortArr[0] + " ");
            else if(string.charAt(i) == 'B')
                System.out.print(sortArr[1] + " ");
            else if(string.charAt(i) == 'C')
                System.out.print(sortArr[2] + " ");
        }



    }
}
