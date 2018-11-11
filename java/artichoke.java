import static java.lang.Math.*;

public class artichoke {

    private static int p, a, b, c, d, n;

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        p = sc.getInt();
        a = sc.getInt();
        b = sc.getInt();
        c = sc.getInt();
        d = sc.getInt();
        n = sc.getInt();
        double highest_decline = 0;
        double current_highest_node = 0;
        boolean declining = false;
        double current_decline = 0;
        for (int i = 1; i < n; i++) {
            double pricei = p * (sin(a * i + b) + cos(c * i + d) + 2), pricei1 = p * (sin(a * (i+1) + b) + cos(c * (i+1) + d) + 2);
            if(pricei > pricei1) {
                if(!declining) {
                    current_highest_node = pricei;
                    declining = true;
                }
                current_decline += pricei-pricei1;
                if(current_decline > highest_decline) {
                    highest_decline = current_decline;
                }
            } else if(declining){
                if(current_highest_node > pricei1) {
                    current_decline -= pricei1 - pricei;
                } else {
                    declining = false;
                    if(current_decline > highest_decline) {
                        highest_decline = current_decline;
                    }
                    current_decline = 0;
                }
            } else {
                current_decline = 0;
            }
        }
        System.out.println(highest_decline);
    }

}
