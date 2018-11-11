import java.util.*;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        for(int i = 0; i < 6; i++){
            if(i % 2 == 0)
                x.add(scan.nextInt());
            else
                y.add(scan.nextInt());
        }
        int ix = 0;
        int iy = 0;
        int xp = 0;
        int yp = 0;
        for(int i = 0; i < 6; i++){
            if(i % 2 == 0){
                if(Collections.frequency(x, x.get(ix)) == 1)
                    xp = x.get(ix);
                ix++;
            }
            else{
                if(Collections.frequency(y, y.get(iy)) == 1)
                    yp = y.get(iy);
                iy++;
            }
        }

        System.out.println(xp + " " + yp);


    }
}