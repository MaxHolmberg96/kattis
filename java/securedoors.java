import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        ArrayList<String> building = new ArrayList<>();
        for(int i = 0; i <= cases; i++){
            String[] split = scan.nextLine().split(" ");
            if(split[0].equals("entry")){
                if(building.contains(split[1])){
                    System.out.println(split[1] + " entered" + " (ANOMALY)");
                }
                else{
                    System.out.println(split[1] + " entered");
                    building.add(split[1]);
                }
            }
            else if(split[0].equals("exit")){
                if(!(building.contains(split[1]))){
                    System.out.println(split[1] + " exited" + " (ANOMALY)");
                }
                else{
                    System.out.println(split[1] + " exited");
                    building.remove(split[1]);
                }
            }
        }
    }
}

