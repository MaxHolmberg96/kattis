import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String output = "";
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == 'a' || line.charAt(i) == 'e' || line.charAt(i) == 'i' || line.charAt(i) == 'o' || line.charAt(i) == 'u'){
                output += line.charAt(i);
                i = i+2;
            }
            else
                output += line.charAt(i);


        }
        System.out.println(output);

    }
}