public class batterup {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        int n = katt.getInt();
        double sum = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int k = katt.getInt();
            if(k != -1){
                sum += k;
                c++;
            }
        }
        System.out.println(sum/c);
    }
}
