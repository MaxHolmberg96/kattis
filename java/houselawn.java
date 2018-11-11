import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class houselawn {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int l = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        ArrayList<String> names = new ArrayList<>();
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            line = sc.readLine().split(",");
            String name = line[0];
            int p = Integer.parseInt(line[1]);
            double c = Double.parseDouble(line[2]);
            double t = Double.parseDouble(line[3]);
            double r = Double.parseDouble(line[4]);

            double sm = c * t * 10080 / (t + r);
            if(sm >= l) {
                if(p == lowest) {
                    names.add(name);
                } else if(p < lowest) {
                    lowest = p;
                    names.clear();
                    names.add(name);
                }
            }
        }

        if(names.size() == 0) {
            System.out.println("no such mower");
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}
