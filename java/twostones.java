import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int stones = scan.nextInt();
        int alice = 0;
        int bob = 0;
        loop:
        for(int i = stones; i > 0; i = i - 2){
            if(i == 1){
                alice = 1;
                break loop;
            }
            if(i == 2){
                bob = 1;
                break loop;
            }
        }

        if(alice == 1)
            System.out.println("Alice");
        else if(bob == 1)
            System.out.println("Bob");

    }
}
