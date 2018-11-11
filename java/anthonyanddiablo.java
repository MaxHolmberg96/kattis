public class anthonyanddiablo {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        double A = katt.getDouble();
        double N = katt.getDouble();
        double r = N/(2*Math.PI);
        double maxArea = Math.PI*r*r;
        if(maxArea >= A){
            System.out.println("Diablo is happy!");
        } else {
            System.out.println("Need more materials!");
        }
    }
}
