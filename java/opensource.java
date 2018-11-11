
import java.io.*;
import java.util.*;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        ArrayList<Project> set = new ArrayList<>();
        ArrayList<String> blacklist = new ArrayList<>();
        Project current = null;
        while(!(s = sc.nextLine()).equals("0")){
            if(s.equals("1")){
                Collections.sort(set, new Comparator<Project>() {
                    @Override
                    public int compare(Project o1, Project o2) {
                        if(o1.size() < o2.size()){
                            return 1;
                        }
                        else if(o2.size() < o1.size()){
                            return -1;
                        }
                        else if(o1.getName().compareTo(o2.getName()) < 0){
                            return -1;
                        }
                        else
                            return 1;
                        }
                });

                for (int i = 0; i < set.size(); i++) {
                    System.out.println(set.get(i).getName() + " " + set.get(i).size());
                }
                set.clear();
                current = null;
            }

            else if(Character.isUpperCase(s.charAt(0))) {
                current = new Project(s);
                set.add(current);
            }
            else if(Character.isLowerCase(s.charAt(0))){
                boolean mark = false;
                for(Project p : set){
                    if(!p.equals(current)) {
                        if (p.contains(s)) {
                            mark = true;
                            blacklist.add(s);
                            p.remove(s);
                        }
                    }
                }
                if(!mark && !blacklist.contains(s))
                    current.add(s);
            }
        }
    }

    static class Project{
        String name;
        int n;
        HashSet<String> users = new HashSet<>();

        public Project(String name){
            this.name=name;
            n=0;
        }

        public void add(String userID){
            users.add(userID);
        }

        public void remove(String userID){
            users.remove(userID);
        }

        public int size(){
            return users.size();
        }

        public String getName() {
            return name;
        }

        public int getN(){
            return n;
        }

        public boolean contains(String userID){
            return users.contains(userID);
        }

        public int compareTo(Project p){
            if(n > p.getN()){
                return 1;
            }
            else if(p.getN() > n){
                return -1;
            }
            else if(name.compareTo(p.getName()) > 0){
                return -1;
            }
            else
                return 1;
        }

        public boolean equals(Project p){
            return name.equals(p.getName());
        }
    }
}




class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader(InputStreamReader inputStreamReader)
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}