import java.util.HashSet;

public class boatparts {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int P = katt.getInt();
        int N = katt.getInt();
        HashSet<String> parts = new HashSet<>();
        int diff = 0;
        for (int i = 0; i < N; i++) {
            String part = katt.getWord();
            if(!parts.contains(part)){
                diff++;
                if(diff == P){
                    System.out.println(i+1);
                    return;
                }
                parts.add(part);
            }
        }
        System.out.println("paradox avoided");
    }
}
