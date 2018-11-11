import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> animals = new HashMap<>();
        int listCount = 0;
        while(scan.hasNextLine()){
            int cases = scan.nextInt();
            if(cases == 0)
                break;
            for(int i = 0; i <= cases; i++){
                String[] split = scan.nextLine().split(" ");
                if(!(animals.containsKey(split[split.length-1].toLowerCase()))){
                    int value = 1;
                    animals.put(split[split.length-1].toLowerCase(), value);
                }
                else if(animals.containsKey(split[split.length-1].toLowerCase())){
                    int value = animals.get(split[split.length-1].toLowerCase());
                    animals.remove(split[split.length-1].toLowerCase());
                    animals.put(split[split.length-1].toLowerCase(), value+1);
                }
            }
            listCount++;
            System.out.println("List " + listCount + ":");
            ArrayList<String> sorting = new ArrayList<>();
            for(String key : animals.keySet()){
                sorting.add(key);
            }
            Collections.sort(sorting);
            for(int i = 1; i < animals.size(); i++){
                System.out.println(sorting.get(i) + " | " + animals.get(sorting.get(i)));
            }
            animals.clear();
        }
    }
}

// totalBottles / cost > 0