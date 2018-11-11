import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int length;
        String firstString = "";
        int counter = 1;
        boolean second = false;
        scan.nextLine();
        for(int i = 0; i < cases; i++){


                firstString = scan.nextLine();

                String secondString = scan.nextLine();
                if (firstString.length() > secondString.length())
                    length = secondString.length();
                else
                    length = firstString.length();
                int j = 0;
                System.out.println(firstString);
                System.out.println(secondString);
                for (; j < length; j++) {
                    if (firstString.charAt(j) == secondString.charAt(j))
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                if (firstString.length() > secondString.length())
                    for (; j < firstString.length(); j++)
                        System.out.print("*");
                else
                    for (; j < secondString.length(); j++)
                        System.out.print("*");


            System.out.println();
            System.out.println();
        }
    }
}
