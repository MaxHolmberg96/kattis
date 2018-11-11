import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Max Holmberg on 2017-08-08.
 */
public class main {

    public static void main(String[] args) {
        /*Matrix m = new Matrix(4, 4);
        m.matrix[0][0] = -1.;
        m.matrix[0][1] = 1.;
        m.matrix[0][2] = 5.;
        m.matrix[0][3] = -4.;

        m.matrix[1][0] = 1.;
        m.matrix[1][1] = 4.;
        m.matrix[1][2] = 2.;
        m.matrix[1][3] = 3.;

        m.matrix[2][0] = 3.;
        m.matrix[2][1] = 7.;
        m.matrix[2][2] = -4.;
        m.matrix[2][3] = 3.;

        m.matrix[3][0] = 5.;
        m.matrix[3][1] = 10.;
        m.matrix[3][2] = -10.;
        m.matrix[3][3] = 5.;

        m.luFactorization();

        System.out.println(m);*/

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < 10E6; i++) {
            HashSet<Integer> map = new HashSet<>();
            int j = 0;
            for (; j < arr.length; j++) {
                if(map.contains(arr[j]%i)){
                    break;
                } else{
                    map.add(arr[j]%i);
                }
            }
            if(j == arr.length) {
                System.out.println(i);
                return;
            }
        }

    }

}


/**
 * Class to represent a Matrix.
 */
class Matrix{

    Double[][] matrix;
    private int n, m;

    /**
     * Creates a new instance of Matrix with dimensions n x m.
     *
     * @param n - rows
     * @param m - colums
     */
    public Matrix(int n, int m){
        matrix = new Double[n][m];
        this.n = n;
        this.m = m;
    }

    /**
     * Performs LU-factorization on the Matrix, matrix will be
     * a lower triangular matrix and an upper triangluar matrix after.
     */
    public void luFactorization() {
        if (n != m) {
            throw new IllegalArgumentException("n x n matrix");
        }
        /* create auxiliary array for row swaps */
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = i;
        }

        /* loop over columns in matrix */
        for (int c = 0; c < n-1; c++) {

            /* find largets pivot too swap current row with (curr row = c) */
            int largetsPivotRow = largetsPivot(c);
            System.out.println("largest row is now: " + largetsPivotRow);
            System.out.println("PRINTING MATRIX: ");
            System.out.println(toString());
            System.out.println();
            swap(matrix, largetsPivotRow, c);
            System.out.println("AFTER SWAP: ");
            System.out.println(toString());
            System.out.println();
            aux[largetsPivotRow] = c;
            aux[c] = largetsPivotRow;
            for (int i = 0; i < aux.length; i++) {
                System.out.print(aux[i]+1 + " ");
            }
            System.out.println();

            /* loop through and fill the column under pivot with auxiliary
               information */
            for (int r = c + 1; r < n; r++) {
                matrix[r][c] = matrix[r][c] / matrix[c][c];
            }

            /* loop through */
            for (int k = c + 1; k < n; k++) {
                for (int i = c + 1; i < n; i++) {
                    matrix[i][k] = matrix[i][k] - matrix[i][c] * matrix[c][k];
                }
            }
            System.out.println("AFTER DIVIDING: ");
            System.out.println(toString());
            System.out.println();
        }
    }

    /**
     *
     *
     * @param x
     * @param r1
     * @param r2
     * @param <T>
     */
    private <T> void swap(T[][] x, int r1, int r2){
        T[] aux = x[r1];
        x[r1] = x[r2];
        x[r2] = aux;
    }

    /**
     *
     * @param column
     * @return
     */
    private int largetsPivot(int column){
        double a = 0;
        int i = 0;
        for (int row = column; row < n; row++) {
            if(matrix[row][column] > a){
                a = matrix[row][column];
                i = row;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        String a = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a += matrix[i][j] + " ";
            }
            a += "\n";
        }
        return a;
    }
}
