class main{
    public static void main(String[] args){
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextShort();
        if(n < 4) System.out.println("1");
        else System.out.println(n-2);
    }
}