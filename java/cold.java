import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int cases = scan.nextInt();
       int counter = 0;
       for(int i = 0; i < cases; i++){
           int temp = scan.nextInt();
           if(temp < 0){
               counter++;
           }
       }
        System.out.println(counter);
    }
}
