import java.util.HashMap;

public class cudeoviste {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int R = katt.getInt();
        int C = katt.getInt();
        char[][] parking = new char[R][C];
        for (int i = 0; i < R; i++) { parking[i] = katt.getLine().toCharArray(); }
        solve(parking);
    }

    private static void solve(char[][] parking){
        HashMap<Integer, Integer> map = new HashMap<>();
        /* iterate with car through the matrix searching for potential spaces */
        for (int i = 0; i < parking.length-1; i++) {
            for (int j = 0; j < parking[i].length-1; j++) {
                int nr = park(parking, i, j);
                map.put(nr, map.containsKey(nr) ? map.get(nr)+1 : 1);
            }
        }
        for (int i = 0; i <= 4; i++) {
            System.out.println(map.getOrDefault(i, 0));
        }
    }

    private static int park(char[][] parking, int r, int c){
        char[] arr = new char[4];
        arr[0] = parking[r][c];
        arr[1] = parking[r][c+1];
        arr[2] = parking[r+1][c];
        arr[3] = parking[r+1][c+1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '#'){
                return -1;
            } else if(arr[i] == 'X'){
                count++;
            }
        }
        return count;
    }
}
