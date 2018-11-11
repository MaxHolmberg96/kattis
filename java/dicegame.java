import java.util.Arrays;

public class dicegame {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int[] gunnars = Arrays.stream(katt.getLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] emmas = Arrays.stream(katt.getLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (gunnars[0]+gunnars[1]+gunnars[2]+gunnars[3] > emmas[0]+emmas[1]+emmas[2]+emmas[3]){
            System.out.println ("Gunnar");
        } else if(gunnars[0]+gunnars[1]+gunnars[2]+gunnars[3] < emmas[0]+emmas[1]+emmas[2]+emmas[3]){
            System.out.println("Emma");
        } else {
            System.out.println ("Tie");
        }
    }
}


/**
 * Test 1:
 * Gunnar: 2-8
 * Emma: 2-12
 *
 * Test 2:
 * Gunnar: 2-16
 * Emma: 3-15
 *
 * Test 3:
 * Gunnar: 4-12
 * Emma: 3-10
 */