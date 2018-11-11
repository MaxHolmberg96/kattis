import java.util.ArrayList;
import java.util.Arrays;

public class busnumbers {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        sc.getInt();
        int[] arr = Arrays.stream(sc.getLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        SuperList sp = new SuperList();
        for (int i = 0; i < arr.length; i++) {
            sp.add(arr[i]);
        }
        sp.analyze();
        System.out.println(sp);
    }

    private static class SuperList {
        ArrayList<String> list;

        public SuperList() {
            list = new ArrayList<>();
        }

        public void add(Integer a) {
            if (list.size() > 0) {
                String lastEntry = list.get(list.size() - 1);
                if (lastEntry.contains("-")) {
                    if (Integer.parseInt(lastEntry.split("-")[1]) == a - 1) {
                        list.remove(list.size() - 1);
                        list.add(Integer.parseInt(lastEntry.split("-")[0]) + "-" + Integer.toString(a));
                    } else {
                        list.add(Integer.toString(a));
                    }
                } else if (Integer.parseInt(lastEntry) == a - 1) {
                    list.remove(list.size() - 1);
                    list.add(lastEntry + "-" + Integer.toString(a));
                } else {
                    list.add(Integer.toString(a));
                }
            } else {
                list.add(Integer.toString(a));
            }
        }

        public void analyze(){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).contains("-")){
                    String[] entry = list.get(i).split("-");
                    if(Integer.parseInt(entry[0]) == Integer.parseInt(entry[1])-1) {
                        list.remove(i);
                        list.add(i, entry[1]);
                        list.add(i, entry[0]);
                    }
                }
            }
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (String s : list) {
                builder.append(s).append(" ");
            }
            return builder.toString();
        }
    }

}
