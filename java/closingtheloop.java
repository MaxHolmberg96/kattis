import java.util.ArrayList;
import java.util.Collections;

public class closingtheloop {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int n = katt.getInt();
        for (int i = 0; i < n; i++) {
            int nr = katt.getInt();
            ArrayList<Integer> blues = new ArrayList<>();
            ArrayList<Integer> reds = new ArrayList<>();
            for (int j = 0; j < nr; j++) {
                String s = katt.getWord();
                switch (s.charAt(s.length()-1)){
                    case 'B':
                        blues.add(Integer.parseInt(s.substring(0, s.length() -1)));
                        break;
                    case 'R':
                        reds.add(Integer.parseInt(s.substring(0, s.length() -1)));
                        break;
                }
            }
            Collections.sort(blues);
            Collections.sort(reds);
            double total = 0;
            boolean red = reds.size() >= blues.size();
            int knots = 0;
            boolean startedWithRed = red;
            ArrayList<String> rope = new ArrayList<>();
            while(true){
                if((blues.size() > 0 && reds.size() > 0) || (red && reds.size() > 0 && rope.size() > 0 && rope.get(0).equals("blue")) || (!red && blues.size() > 0 && rope.size() > 0 && rope.get(0).equals("red"))) {
                    if (red) {
                        total += reds.get(reds.size() - 1);
                        reds.remove(reds.size() - 1);
                        red = false;
                        ++knots;
                        rope.add("red");
                    } else {
                        total += blues.get(blues.size() - 1);
                        blues.remove(blues.size() - 1);
                        red = true;
                        ++knots;
                        rope.add("blue");
                    }
                } else {
                    break;
                }
            }
            System.out.println("Case #" + (i+1) + ": " + ((int)total-knots));
        }
    }
}
