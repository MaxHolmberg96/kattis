import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        while(scan.hasNextLine()) {

            int number = scan.nextInt();
            boolean artihmetic = false;
            boolean perartihmetic = false;
            boolean notArithmetic = true;
            int[] arr = new int[number];
            for (int i = 0; i < number; i++){
                arr[i] = scan.nextInt();
            }
            int findBiggest = 0;
            int place = 0;
            for(int i = 0; i < number; i++){
                if(findBiggest < arr[i]) {
                    findBiggest = arr[i];
                    place = i;
                }
            }
            int tal = arr[0];
            int i = 0;
            loop:
            for(; i < number; i++){
                if(tal > arr[i]);
                else
                    break loop;

            }
            int difference = 0;
            if(i == number){
                int lastdifference = arr[0] - arr[1];
                loop:
                for(i = 0; i < number-1; i++){
                    difference = arr[i] - arr[i+1];
                    if(difference != lastdifference){
                        notArithmetic = true;
                        break loop;
                    }
                    lastdifference = difference;
                    notArithmetic = false;
                }
            }
            if(notArithmetic){
                tal = arr[number-1];
                i = 0;
                loop:
                for(; i > 0; i--){
                    if(tal > arr[i]);
                    else
                        break loop;

                }
                if(i == 0){
                    int lastdifference = arr[number-1] - arr[number-2];
                    loop:
                    for(i = number-1; i > 0; i--){
                        difference = arr[i] - arr[i-1];
                        if(difference != lastdifference){
                            notArithmetic = true;
                            break loop;
                        }
                        lastdifference = difference;
                        notArithmetic = false;
                    }
                }
            }
            if(notArithmetic) {
                Arrays.sort(arr);
                int lastdifference = arr[0] - arr[1];
                loop:
                for (i = 0; i < number - 1; i++) {
                    difference = arr[i] - arr[i + 1];
                    if (difference != lastdifference) {
                        perartihmetic = false;
                        break loop;
                    }
                    lastdifference = difference;
                    perartihmetic = true;
                }
            }

            if(!notArithmetic){
                System.out.println("arithmetic");
            }
            else if(perartihmetic){
                System.out.println("permuted arithmetic");
            }
            else{
                System.out.println("non-arithmetic");
            }

            scan.nextLine();
        }
    }
}
