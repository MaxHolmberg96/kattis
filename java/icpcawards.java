import java.io.*;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    private static ArrayList<Team> output;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        HashMap<String, Team> teams = new HashMap<>();
        HashMap<Integer, Team> ranks = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String university = sc.next();
            String teamName = sc.next();
            Team team = new Team(teamName, university, i+1);
            teams.put(teamName,  team);
            ranks.put(i+1, team);
        }

        int added = 0;
        output = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Team team = ranks.get(i+1);
            if(!containUniv(team)){
                output.add(team);
                added++;
                if(added == 12){
                    break;
                }
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i).university + " " + output.get(i).teamName);
        }

    }

    private static boolean containUniv(Team team){
        for (Team anOutput : output) {
            if (anOutput.university.equals(team.university)) {
                return true;
            }
        }
        return false;
    }

}


class Team{
    String teamName;
    String university;
    int rank;

    public Team(String teamName, String university, int rank) {
        this.teamName = teamName;
        this.university = university;
        this.rank = rank;
    }
}


class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String getLine() throws IOException { return r.readLine(); }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

