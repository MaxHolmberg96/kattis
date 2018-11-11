import java.util.ArrayList;
import java.util.HashMap;

public class guessinggame {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        ArrayList<Integer> highs = new ArrayList<>();
        ArrayList<Integer> lows = new ArrayList<>();
        while (sc.hasMoreTokens()) {
            int guess = sc.getInt();
            if(guess == 0) {
                break;
            }
            String ans = sc.getLine().split(" ")[1];
            if(ans.equals("high")) {
                highs.add(guess);
            } else if(ans.equals("low")) {
                lows.add(guess);
            } else {
                boolean liar = false;
                for (Integer low : lows) {
                    if(guess <= low) {
                        liar = true;
                    }
                }
                for (Integer high : highs) {
                    if(guess >= high) {
                        liar = true;
                    }
                }
                System.out.println(liar ? "Stan is dishonest" : "Stan may be honest");
                highs.clear();
                lows.clear();
            }

        }
    }

}
