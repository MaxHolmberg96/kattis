import java.util.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int amount = scan.nextInt();
        scan.nextLine();
        String before = scan.nextLine();
        String after = scan.nextLine();

        String match = "";

        for(int i = 0; i < amount; i++){
            for(int j = 0; j < before.length(); j++){
                if(before.charAt(j) == '0')
                    match += "1";
                else
                    match += "0";
            }
            before = match;
            match = "";
        }
        if(before.equals(after))
            System.out.println("Deletion succeeded");
        else
            System.out.println("Deletion failed");
    }
}
