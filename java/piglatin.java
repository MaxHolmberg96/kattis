import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       String s;
       while(sc.hasNextLine() && ((s = sc.nextLine()) != "golf")){
           for(String st : s.split(" ")) {
               if (st.substring(0, 1).matches("[^aeiouy]")) {
                   System.out.print(st.replaceAll("([^aeiouy]+)([aeiouy])([a-z]*)", "$2$3$1ay "));
               } else {
                   System.out.print(st.replaceAll("([a-z]+)", "$1yay "));

               }
           }
           System.out.println();
       }
    }
}




