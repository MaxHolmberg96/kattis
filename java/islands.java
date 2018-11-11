import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Scanner sc = new Scanner( new BufferedReader(new InputStreamReader(System.in)));
//        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc = new Scanner(new BufferedReader(new FileReader(new File("C:\\Users\\Pontus Eriksson\\Desktop\\new.txt"))));
        Kattio sc = new Kattio(System.in, System.out);
//        PrintWriter fs = new PrintWriter(new BufferedOutputStream(System.out));


//        NumberFormat nf = new DecimalFormat("###.#############");  //nf.format();
//        IntStream.range(0, sc.nextInt()).forEach(i -> f(i)); // short for loop

        int n = sc.getInt();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            sc.getInt();
    
            for (int j = 0; j < 12; j++) {
                list.add(sc.getInt());
            }
    
            int count = 0;
            while (true) {
                int index = arrayMaxIndex(list);
                int maxVal = list.get(index);
                if (maxVal == 0) {
                    break;
                }
                while (list.get(index) == maxVal) {
                    list.remove(index);
                }
                ++count;
            }
            sc.println(i+1 + " " + count);
        }
        sc.flush();
//        fs.flush();
        
        
    
    
    }
    
    static int arrayMaxIndex(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            if (list.get(i) >= max) {
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
    
    
    static int nrOfNeihgbours (char[][] arr, long search, int x, int y, int radius) {
        int total = 0;
        for (int k = radius*-1; k < radius+1; k++) {
            for (int l = radius*-1; l < radius+1; l++) {
                try {
                    if ((k != 0 || l != 0) && arr[y+k][x+l] == search){
                        total++;
                    }
                }
                catch (Exception e){

                }
            }
        }
        return total;
    }

    public static String convert(int number, int base)
    {
        int quotient = number / base;
        int remainder = number % base;

        if (quotient == 0)
            return Integer.toString(remainder);
        else
            return convert(quotient, base) + Integer.toString(remainder);
    }

    static double logX(long x, long base)
    {
        return (Math.log(x) / Math.log(base));
    }

    static Integer[] factorsOf(int val) {
        List<Integer> numArray = new ArrayList<Integer>();

        for (int i = 2; i <= Math.ceil(Math.sqrt(val)); i++) {
            if (val % i == 0) {
                numArray.add(i);
                val /= i;
            }
        }
        numArray.add(val);
        return numArray.toArray(new Integer[numArray.size()]);
    }

    public static long digitsum(long a){
        long sum = 0;
        int count = (int)Math.ceil(Math.log10(a));
        while (count-- >= 0){
            sum += a%10;
            a /= 10;
        }
        return sum;
    }

    public static double distBetLatLong(double oneLat, double oneLong, double twoLat, double twoLong){
        double earthRad = 6371.0088;
        double o1 = Math.toRadians(oneLat);
        double o2 = Math.toRadians(twoLat);
        double deltO = Math.toRadians(oneLat-twoLat);
        double deltL = Math.toRadians(oneLong-twoLong);

        double a = Math.pow(Math.sin(deltO/2), 2) + Math.cos(o1) * Math.cos(o2) * Math.pow(Math.sin(deltL/2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return earthRad * c;
    }

    public static boolean isPalindrome(final String s){
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) return false;
        }
        return true;
    }

    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }

    public static boolean isVowel(final char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }

    public static long lcd(long n, long m){
        return (Math.abs(n*m))/gcd(n, m);
    }

    public static BigInteger lcd(BigInteger n, BigInteger m){
        return n.multiply(m).abs().divide(gcd(n, m));
    }

    public static long gcd(long n, long m){
        return m != 0 ? gcd(m, n%m) : n;
    }

    public static BigInteger gcd(BigInteger n, BigInteger m){
        return !m.equals(BigInteger.valueOf(0)) ? gcd(m, n.mod(m)) : n;
    }

    public static long fact(long i){
        if(i < 2) return 1;
        else return i*fact(i-1);
    }

    public static BigInteger fact(BigInteger n){
        BigInteger result = BigInteger.ONE;
        while(!n.equals(BigInteger.ZERO)){
            result = result.multiply(n);
            n = n.subtract(BigInteger.ONE);
        }
        return result;
    }

    public static long nchooseX(long n, long x){
        return fact(n)/(fact(x)*fact(n-x));
    }

    public static BigInteger nchooseX(BigInteger n, BigInteger x){
        return fact(n).divide(fact(x).multiply(fact(n.subtract(x))));
    }
}

class BinaryTree {
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private long p;
    private long q;
    private long id;

    BinaryTree(long id, long p, long q){
        this.p = p;
        this.q = q;
        this.id = id;
    }

    public BinaryTree getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTree leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTree getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTree rightChild) {
        this.rightChild = rightChild;
    }
    public long getP() {
        return p;
    }

    public void setP(long p) {
        this.p = p;
    }

    public long getQ() {
        return q;
    }

    public void setQ(long q) {
        this.q = q;
    }

    public long getId() {
        return id;
    }
}

class StopWatch{
    private double startTime;

    StopWatch(){
        startTime = System.nanoTime();
    }

    public double lap(int i){
        return (System.nanoTime()-startTime)/1000000;
    }

    public void lap(){
        System.out.println((System.nanoTime()-startTime)/1000000);
    }
}

class FenwickTree {

    long[] array; // 1-indexed array, In this array We save cumulative information to perform efficient range queries and updates

    public FenwickTree(int size) {
        array = new long[size + 1];
    }

    /**
     * Range Sum query from 1 to ind
     * ind is 1-indexed
     * <p>
     * Time-Complexity:    O(log(n))
     *
     * @param  ind index
     * @return sum
     */
    public long rsq(int ind) {
        assert ind > 0;
        long sum = 0;
        while (ind > 0) {
            sum += array[ind];
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and decrementing ind by that number
            ind -= ind & (-ind);
        }

        return sum;
    }

    /**
     * Range Sum Query from a to b.
     * Search for the sum from array index from a to b
     * a and b are 1-indexed
     * <p>
     * Time-Complexity:    O(log(n))
     *
     * @param  a left index
     * @param  b right index
     * @return sum
     */
    public long rsq(int a, int b) {
        assert b >= a && a > 0 && b > 0;

        return rsq(b) - rsq(a - 1);
    }

    /**
     * Update the array at ind and all the affected regions above ind.
     * ind is 1-indexed
     * <p>
     * Time-Complexity:    O(log(n))
     *
     * @param  ind   index
     * @param  value value
     */
    public void update(int ind, int value) {
        assert ind > 0;
        while (ind < array.length) {
            array[ind] += value;
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
            ind += ind & (-ind);
        }
    }

    public long size() {
        return array.length - 1;
    }
}

class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }

    public String getLine() {
        return line;
    }

    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}

class Circle {
    public double x;
    public double y;
    public double radius;
    public String color;

    public Circle(double x, double y, double radius, String color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean withinBounds(double x, double y){
        return Math.hypot(this.x - x, this.y - y) <= this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.x, x) != 0) return false;
        if (Double.compare(circle.y, y) != 0) return false;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}