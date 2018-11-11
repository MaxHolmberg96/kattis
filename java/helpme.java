import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class helpme {

    private static String letterPos = "abcdefgh";
    private static String digitPos = "87654321";
    private static ArrayList<Gubbe> gubbar = new ArrayList<>();

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        char[][] m = new char[17][33];
        for (int i = 0; i < 17; i++) { m[i] = katt.getLine().toCharArray(); }
        solve(m);
    }

    private static void solve(char[][] m){
        for (int i = 0; i < 17; i++) {
            for (int j = 0; j < 33; j++) {
                if(isGubbe(m[i][j])){
                    gubbar.add(new Gubbe(m[i][j], i, j));
                }
            }
        }

        ArrayList<Gubbe> white = new ArrayList<>();
        ArrayList<Gubbe> black = new ArrayList<>();
        for (int i = 0; i < gubbar.size(); i++) {
            if(Character.isUpperCase(gubbar.get(i).gubbe)){
                white.add(gubbar.get(i));
            } else {
                black.add(gubbar.get(i));
            }
        }
        String s1 = "NBRQK";
        String s2 = "nbrqk";
        Comparator cmp = (o1, o2) -> {
            Gubbe g1 = (Gubbe)o1;
            Gubbe g2 = (Gubbe)o2;
            int ind1; int ind2;
            if(Character.isUpperCase(g1.gubbe)) {
                ind1 = s1.indexOf(g1.gubbe);
                ind2 = s1.indexOf(g2.gubbe);
            } else {
                ind1 = s2.indexOf(g1.gubbe);
                ind2 = s2.indexOf(g2.gubbe);
            }
            if(ind1 > ind2){
                return -1;
            } else if(ind1 < ind2){
                return 1;
            } else {
                if(Character.isUpperCase(g1.gubbe)){
                    /* ITS THE WHITE LIST */
                    int rnr1 = g1.pos.charAt(g1.pos.length()-1);
                    int rnr2 = g2.pos.charAt(g2.pos.length()-1);
                    return Integer.compare(rnr1, rnr2);
                } else {
                    /* ITS THE BLACK LIST */
                    int rnr1 = g1.pos.charAt(g1.pos.length()-1);
                    int rnr2 = g2.pos.charAt(g2.pos.length()-1);
                    if(rnr1 > rnr2){
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        };
        white.sort(cmp);
        black.sort(cmp);
        System.out.print("White: ");
        for (int i = 0; i < white.size()-1; i++) {
            if(white.get(i).gubbe == 'P'){
                System.out.print(white.get(i).pos + ",");
            } else {
                System.out.print(white.get(i).gubbe + "" + white.get(i).pos + ",");
            }
        }
        if(!white.isEmpty() && white.get(white.size()-1).gubbe == 'P') {
            System.out.println("" + white.get(white.size() - 1).pos);
        } else if(!white.isEmpty()){
            System.out.println(white.get(white.size() - 1).gubbe + "" + white.get(white.size() - 1).pos);
        } else {
            System.out.println();
        }
        System.out.print("Black: ");
        for (int i = 0; i < black.size()-1; i++) {
            if(black.get(i).gubbe == 'p'){
                System.out.print(black.get(i).pos + ",");
            } else {
                System.out.print(Character.toUpperCase(black.get(i).gubbe) +
                        "" + black.get(i).pos + ",");
            }
        }
        if(!black.isEmpty() && black.get(black.size()-1).gubbe == 'p'){
            System.out.println(black.get(black.size()-1).pos + "");
        } else if(!black.isEmpty()){
            System.out.println(black.get(black.size() - 1).gubbe + "" + black.get(black.size() - 1).pos);
        }
    }

    private static boolean isGubbe(char c){
        return (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }

    private static String convertPosition(int r, int c){
        int l = (c/4)+1;
        int d = (r/2)+1;
        return letterPos.charAt(l-1) + "" + digitPos.charAt(d-1);
    }

    private static class Gubbe {
        char gubbe;
        String pos;

        public Gubbe(char gubbe, int r, int c) {
            this.gubbe = gubbe;
            pos = convertPosition(r, c);
        }
    }
}
