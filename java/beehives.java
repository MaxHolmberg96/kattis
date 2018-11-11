import java.util.ArrayList;

public class beehives {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        while(true) {
            double d = katt.getDouble();
            int N = katt.getInt();
            if(d == 0 && N == 0){
                break;
            }
            ArrayList<Beehive> beehives = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                beehives.add(new Beehive(new Point(katt.getDouble(), katt.getDouble
                        ())));
            }
            int sour = 0, sweet = 0;
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if(distance(beehives.get(i).p, beehives.get(j).p) <= d){
                        beehives.get(i).sweet = false;
                        beehives.get(j).sweet = false;
                    }
                }
            }
            for (int i = 0; i < beehives.size(); i++) {
                if(beehives.get(i).sweet){
                    sweet++;
                } else {
                    sour++;
                }
            }
            System.out.println(sour + " sour, " + sweet + " sweet");
        }
    }

    private static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(p2.x-p1.x, 2) + Math.pow(p2.y-p1.y, 2));
    }

    private static class Beehive{
        Point p;
        boolean sweet = true;

        public Beehive(Point p) {
            this.p = p;
        }
    }
}
