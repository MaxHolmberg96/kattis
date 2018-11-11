import java.util.HashSet;
import java.util.Scanner;

public class nodup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int allowed = sc.nextInt();
        int count = 0;
        int events = sc.nextInt();
        int deniedGroups = 0;
        sc.nextLine();
        for (int i = 0; i < events; i++) {
            String[] s = sc.nextLine().split(" ");
            if(s[0].equals("enter")){
                if(Integer.parseInt(s[1])+count <= allowed){
                    count += Integer.parseInt(s[1]);
                } else {
                    deniedGroups++;
                }
            } else {
                count -= Integer.parseInt(s[1]);
            }
        }
        System.out.println(deniedGroups);
    }
}
