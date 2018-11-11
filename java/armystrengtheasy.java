import java.util.*;

public class main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();


        for (int c = 0; c < cases; c++) {
            int Godzilla = scan.nextInt();
            int MechaGodzilla = scan.nextInt();
            scan.nextLine();
            String a = scan.nextLine();
            String h = scan.nextLine();
            boolean armyIsDead = false;
            String[] alliance = a.split(" ");
            String[] horde = h.split(" ");


            ArrayList<Integer> strengthAlly = new ArrayList<>();
            ArrayList<Integer> strengthHorde = new ArrayList<>();


            for (int i = 0; i < alliance.length; i++)
                strengthAlly.add(Integer.parseInt(alliance[i]));
            for (int i = 0; i < horde.length; i++)
                strengthHorde.add(Integer.parseInt(horde[i]));

            Collections.sort(strengthAlly);
            Collections.sort(strengthHorde);

            if(strengthAlly.get(strengthAlly.size()-1) >= strengthHorde.get(strengthHorde.size()-1))
                System.out.println("Godzilla");
            else if(strengthAlly.get(strengthAlly.size()-1) < strengthHorde.get(strengthHorde.size()-1))
                System.out.println("MechaGodzilla");
            else
                System.out.println("uncertain");

        }
    }
}
