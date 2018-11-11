import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int cases = scan.nextInt();
        ArrayList<String> cities = new ArrayList<>();
        for(int i = 0; i < cases; i++){
            cities.clear();
            int numberCities = scan.nextInt();
            scan.nextLine();
            for(int j = 0; j < numberCities; j++){
                String city = scan.nextLine();
                if(!cities.contains(city))
                    cities.add(city);
            }
            System.out.println(cities.size());
        }
    }
}