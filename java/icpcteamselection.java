import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class icpcteamselection {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int datasets = sc.getInt();
        for (int i = 0; i < datasets; i++) {
            int teams = sc.getInt();
            ArrayList<Integer> list;
            int[][] team = new int[teams][3];
            int[] listStudents = Arrays.stream(sc.getLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(listStudents);
            list = new ArrayList<>();
            for (int j = 0; j < listStudents.length; j++) {
                list.add(listStudents[j]);
            }
            int teamIndex = 0;
            while (!list.isEmpty()) {
                team[teamIndex][0] = list.get(list.size()-1); list.remove(list.size()-1);
                team[teamIndex][1] = list.get(list.size()-1); list.remove(list.size()-1);
                team[teamIndex][2] = list.get(0); list.remove(0);
                teamIndex++;
            }
            int sum = 0;
            for (int j = 0; j < teams; j++) {
                sum += team[j][1];
            }
            System.out.println(sum);
        }
    }

}
