public class bishops {

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        while(sc.hasMoreTokens()) {
            int e = 2*sc.getInt();
            if(e == 2){
                System.out.println(1);
            } else if(e > 2){
                System.out.println(e - 2);
            } else {
                System.out.println(0);
            }
        }
    }

}
