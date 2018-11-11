import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int one;
        int two;
        int three;

        one = scan.nextInt();
        two = scan.nextInt();
        three = scan.nextInt();

        if(one == (two + three))
            System.out.println(one + "=" + two + "+" + three);
        else if(one == (two - three))
            System.out.println(one + "=" + two + "-" + three);
        else if(one == (two * three))
            System.out.println(one + "=" + two + "*" + three);


        else if((one + two) == three)
            System.out.println(one + "+" + two + "=" + three);
        else if((one - two) == three)
            System.out.println(one + "-" + two + "=" + three);
        else if((one * two) == three)
            System.out.println(one + "*" + two + "=" + three);

        else if(three != 0 && two % three == 0)
            if(one == (two / three))
                System.out.println(one + "=" + two + "/" + three);

        else if(two != 0 && one % two == 0)
             if((one / two) == three)
                 System.out.println(one + "/" + two + "=" + three);
    }

}