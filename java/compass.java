import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int one = scan.nextInt();
        int two = scan.nextInt();

        if(one > two){
            if(one - two < 360 - one + two){
                System.out.println("-" + (one-two));
            }
            else{
                System.out.println(360-one+two);
            }
        }
        if(two > one){
            if(two - one <= 360 - two + one){
                System.out.println(two - one);
            }
            else{
                System.out.println("-" + (360 - two + one));
            }
        }
        if(two == one){
            System.out.println(0);
        }
    }
}