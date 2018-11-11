import java.io.*;
import java.util.*;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) throws IOException {
        String[] line = new Scanner(System.in).nextLine().split(" ");
        int i = 0;
        for(String s : line) line[i++] = new StringBuilder(s).reverse().toString();
        System.out.println(Integer.parseInt(line[0]) > Integer.parseInt(line[1]) ? line[0] : line[1]);
    }
}






