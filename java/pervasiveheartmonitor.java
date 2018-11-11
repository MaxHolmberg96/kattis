import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = "";
        float average = 0;
        while(scan.hasNextLine()){
            int counter = 0;
            String string = scan.nextLine();
            String[] s = string.split(" ");
            for(int i = 0; i < s.length; i++){
                if(s[i].charAt(0) > 47 && s[i].charAt(0) < 58){
                    average = average + Float.parseFloat(s[i]);
                }
                else{
                    name = name + " " + s[i];
                    counter++;
                }
            }
            average = average/(s.length - counter);
            System.out.println(average + " " + name);
            name = "";
            average = 0;
        }


    }
}
