import java.io.*;
import java.util.*;

public class main {
    private static HashMap<Integer, Integer> songCount = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int numberVillagers = scan.nextInt();
        int numberEvenings = scan.nextInt();
        boolean bard = false;
        for(int i = 1; i <= numberVillagers; i++)
            songCount.put(i, 0);

        scan.nextLine();

        for(int i = 0; i < numberEvenings; i++){
            String[] line = scan.nextLine().split(" ");
            if(stringArrContains(line, "1")){
                bard = true;
                for(int j = 1; j < line.length; j++){
                    int villager = Integer.parseInt(line[j]);
                    int songs = songCount.get(villager)+1;
                    songCount.remove(villager);
                    songCount.put(villager, songs);
                }
            }
            if(!bard){
                for(int j = 1; j < line.length; j++){
                    int villager = Integer.parseInt(line[j]);
                    int songs = getHighest();
                    songCount.remove(villager);
                    songCount.put(villager, songs);
                }
            }
            bard = false;
        }
        ArrayList<Integer> output = new ArrayList<>();
        for(int villager : songCount.keySet())
            if(songCount.get(villager) == bardSongCount())
                output.add(villager);

        Collections.sort(output);
        for(int i = 0; i < output.size(); i++){
            System.out.println(output.get(i));
        }

    }

    public static boolean stringArrContains(String[] arr, String s){
        for(int i = 0; i < arr.length; i++){
            if(s.equals(arr[i]))
                return true;
        }
        return false;
    }

    public static int getHighest(){
        int highest = 0;
        for(int villager : songCount.keySet())
            if(songCount.get(villager) > highest)
                highest = songCount.get(villager);

        return highest;
    }

    public static int bardSongCount(){
        return songCount.get(1);
    }


}
