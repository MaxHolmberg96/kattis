import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        int counter = 0;
        int value;
        int length;
        String integerString;
        String tmpIntString = "";
        int tmpInt;
        int biggest = 0;
        for(int i = 0; i < cases; i++){
            biggest = 0;
            value = scan.nextInt();
            length = Integer.toString(value).length();
            integerString = Integer.toString(value);
            for(int j = 0; j < length; j++){
                counter = 0;
                tmpIntString = tmpIntString + integerString.charAt(j);
                tmpInt = Integer.parseInt(tmpIntString);
                for(int b = 0; b < Integer.toBinaryString(tmpInt).length(); b++){
                    if(Integer.toBinaryString(tmpInt).charAt(b) == '1')
                        counter++;
                }
                if(biggest < counter)
                    biggest = counter;
            }
            tmpIntString = "";
            System.out.println(biggest);
        }
    }
}
