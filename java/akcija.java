import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class akcija {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            ArrayList<Integer> books = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                books.add(sc.nextInt());
            }
            Collections.sort(books);
            int g = 0;
            int minimumCost = 0;
            for (int i = books.size()-1; i >= 0; i--) {
                g++;
                if(g != 3){
                    minimumCost += books.get(i);
                } else {
                    g = 0;
                }
            }
            System.out.println(minimumCost);
        }
    }
}