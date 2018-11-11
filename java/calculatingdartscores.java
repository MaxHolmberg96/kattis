public class calculatingdartscores {

    private static boolean output;

    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        while(katt.hasMoreTokens()) {
            int target = katt.getInt();
            output = false;
            int[][] mul1 = new int[3][];
            int index = 0;
            for (int i = 1; i <= 3; i++) {
                mul1[index] = new int[]{i};
                index++;
            }
            int[][] mul2 = new int[9][];
            index = 0;
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    mul2[index] = new int[]{i, j};
                    index++;
                }
            }
            int[][] mul3 = new int[27][];
            index = 0;
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    for (int k = 1; k <= 3; k++) {
                        mul3[index] = new int[]{i, j, k};
                        index++;
                    }
                }
            }
            int[][] scores3 = new int[8000][];
            index = 0;
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    for (int k = 1; k <= 20; k++) {
                        scores3[index] = new int[]{i, j, k};
                        index++;
                    }
                }
            }
            int[][] scores2 = new int[400][];
            index = 0;
            for (int i = 1; i <= 20; i++) {
                for (int j = 1; j <= 20; j++) {
                    scores2[index] = new int[]{i, j};
                    index++;
                }
            }
            int[][] scores1 = new int[20][];
            index = 0;
            for (int i = 1; i <= 20; i++) {
                scores1[index] = new int[]{i};
                index++;
            }
            loops:
            for (int i = 0; i < 8000; i++) {
                for (int j = 0; j < 27; j++) {
                    int sum = scores3[i][0]*mul3[j][0]+scores3[i][1]*mul3[j][1
                            ]+scores3[i][2]*mul3[j][2];
                    if(sum == target){
                        String s1 = convert(mul3[j][0]) + " " + scores3[i][0];
                        String s2 = convert(mul3[j][1]) + " " + scores3[i][1];
                        String s3 = convert(mul3[j][2]) + " " + scores3[i][2];
                        System.out.println(s1);
                        System.out.println(s2);
                        System.out.println(s3);
                        output = true;
                        break loops;
                    }
                }
            }
            if(!output) {
                loops:
                for (int i = 0; i < 400; i++) {
                    for (int j = 0; j < 9; j++) {
                        int sum = scores2[i][0] * mul2[j][0] + scores2[i][1] * mul2[j][1];
                        if (sum == target) {
                            String s1 = convert(mul2[j][0]) + " " + scores2[i][0];
                            String s2 = convert(mul2[j][1]) + " " + scores2[i][1];
                            System.out.println(s1);
                            System.out.println(s2);
                            output = true;
                            break loops;
                        }
                    }
                }
            }
            if(!output) {
                loops:
                for (int i = 0; i < 20; i++) {
                    for (int j = 0; j < 3; j++) {
                        int sum = scores1[j][0] * mul1[j][0];
                        if (sum == target) {
                            String s1 = convert(mul1[j][0]) + " " + scores1[i][0];
                            System.out.println(s1);
                            output = true;
                            break loops;
                        }
                    }
                }
            }
            if(!output)System.out.println("impossible");
        }
    }

    private static String convert(int k){
        switch (k){
            case 1: return "single";
            case 2: return "double";
            case 3: return "triple";
        }
        return null;
    }
}
