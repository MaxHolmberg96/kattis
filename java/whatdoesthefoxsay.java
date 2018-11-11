import java.util.Scanner;

/**
 * Created by dv16mhg on 2017-04-09.
 */
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        scan.nextLine();
        boolean notFox = true;
        for(int i = 0; i < cases; i++) {
            String animals = scan.nextLine();
            String[] sounds = animals.split(" ");
            loop:
            while (notFox) {
                String line = scan.nextLine();
                if(line.equals("what does the fox say?")){
                    notFox = false;
                    break loop;
                }
                String[] splitLine = line.split(" ");
                for(int j = 0; j < sounds.length; j++){
                    if(splitLine[2].equals(sounds[j])){
                        sounds[j] = "";
                    }
                }
            }

            for(int j = 0; j < sounds.length; j++){
                if(!sounds[j].equals("")){
                    System.out.print(sounds[j] + " ");
                }
            }
            System.out.println();
            notFox = true;

        }
    }
}
