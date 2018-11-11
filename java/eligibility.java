package se.smyto;

public class eligibility {

    public static void main(String[] args) {
        Kattio read = new Kattio(System.in);
        int n = read.Int();
        for (int i = 0; i < n; i++) {
            String[] input = read.Line().split(" ");
            System.out.print(input[0] + " ");
            if(Integer.parseInt(input[1].split("/")[0]) >= 2010){
                System.out.println("eligible");
            } else if(Integer.parseInt(input[2].split("/")[0]) >= 1991){
                System.out.println("eligible");
            } else if(Integer.parseInt(input[3]) >= 41){
                System.out.println("ineligible");
            } else {
                System.out.println("coach petitions");
            }

        }

    }

}
