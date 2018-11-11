import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        for(int i = 0, p = scan.nextInt(); i < p; i++){
            ArrayList<Integer> b = new ArrayList<>();
            scan.nextInt();
            scan.nextLine();
            Arrays.asList(scan.nextLine().split(" ")).forEach(x -> b.add(Integer.parseInt(x)));
            Collections.sort(b);
            System.out.println((b.get(b.size()-1) - b.get(0))*2);
        }
    }
}
