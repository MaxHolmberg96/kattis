package se.smyto;

public class communication {

    public static void main(String[] args) {
        Kattio read = new Kattio(System.in);
        int[] arr1 = new int[1000];
        for (int i = 0; i <= 255; i++) {
            byte j = (byte)i;
            arr1[j^(j<<1)] = i;
        }
        int n = read.Int();
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[read.Int()] + " ");
        }
        System.out.println();

    }

}
