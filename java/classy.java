import java.util.*;

public class classy {

    private static ArrayList<String> list = new ArrayList<>();
    private static HashMap<String, Integer> wordMap = new HashMap<>();
    private static HashMap<Long, ArrayList<String>> getName = new HashMap<>();

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        wordMap.put("upper", 3);
        wordMap.put("middle", 2);
        wordMap.put("lower", 1);
        int c = katt.getInt();
        for (int i = 0; i < c; i++) {
            int n = katt.getInt();
            for (int j = 0; j < n; j++) {
                String s = katt.getLine();
                String[] split = s.split("[\\s-:]");
                int amntAdd = 10-(split.length-3);
                StringBuilder builder = new StringBuilder();
                for (int k = split.length-2; k >= 2; k--) {
                    builder.append(wordMap.get(split[k]));
                }
                for (int k = 0; k < amntAdd; k++) {
                    builder.append(wordMap.get("middle"));
                }
                if(!list.contains(builder.toString())) {
                    list.add(builder.toString());
                }
                Long l = Long.parseLong(builder.toString());
                if(getName.containsKey(l)){
                    getName.get(l).add(split[0]);
                } else {
                    List<String> aux = Arrays.asList(split[0]);
                    getName.put(l, new ArrayList<>(aux));
                }
            }
            Collections.sort(list);
            for (int j = list.size()-1; j >= 0; j--) {
                ArrayList<String> aux = getName.get(Long.parseLong(list.get(j)));
                Collections.sort(aux);
                for (int k = 0; k < aux.size(); k++) {
                    System.out.println(aux.get(k));
                }
            }
            System.out.println("==============================");
            getName.clear();
            list.clear();
        }
    }
}
