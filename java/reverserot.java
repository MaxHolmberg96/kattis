

import java.util.*;


/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            if(Integer.parseInt(line[0]) == 0)
                break;
            String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
            int shift = Integer.parseInt(line[0]);
            String reverse = new StringBuilder(line[1]).reverse().toString();
            char[] arr = reverse.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 'A' && arr[i] <= 'Z' || arr[i] >= 'a' && arr[i] <= 'z')
                    arr[i] = abc.charAt(((arr[i] % 65) + shift) % abc.length());
                else if(arr[i] == '_')
                    arr[i] = abc.charAt(((91 % 65) + shift) % abc.length());
                else if(arr[i] == '.')
                    arr[i] = abc.charAt(((92 % 65) + shift) % abc.length());
            }
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}  