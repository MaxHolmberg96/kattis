import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int r = Integer.parseInt(s.split(" ")[0]), n = Integer.parseInt(s.split(" ")[1]);
        ArrayList<Integer> hotel = new ArrayList<>(r);
        for (int i = 1; i <= r; i++) {
            hotel.add(i);
        }
        int p = r;
        for (int i = 0; i < n; i++) {
            int nr = sc.nextInt();
            for (int j = 1; j <= p; j++) {
                if(hotel.get(j-1) == nr){
                    hotel.remove(j-1);
                    p--;
                }
            }

        }
        if(hotel.size() == 0)
            System.out.println("too late");
        else
            System.out.println(hotel.get(0));
    }
}

