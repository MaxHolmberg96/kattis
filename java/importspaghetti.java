import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class importspaghetti {

    private static int INF = Integer.MAX_VALUE/5;

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int nrNodes = Integer.parseInt(sc.readLine());
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        ArrayList<String> names = new ArrayList<>();
        String[] nodes = sc.readLine().split(" ");
        for (int i = 0; i < nrNodes; i++) {
            graph.put(nodes[i], new HashSet<>());
            names.add(nodes[i]);
        }

        for (int i = 0; i < nrNodes; i++) {
            String[] line = sc.readLine().split(" ");
            String name = line[0];
            int n = Integer.parseInt(line[1]);
            for (int j = 0; j < n; j++) {
                line = sc.readLine().split(" ");
                for (int k = 1; k < line.length; k++) {
                    graph.get(name).add(line[k].replace(",", ""));
                }
            }
        }

        // construct Floyd-Warshall matrix for dp search
        int[][] dist = new int[nrNodes][nrNodes];
        int[][] next = new int[nrNodes][nrNodes];

        for (int i = 0; i < nrNodes; i++) {
            for (int j = 0; j < nrNodes; j++) {
                if(i == j) {
                    if(graph.get(names.get(i)).contains(names.get(j))) {
                        dist[i][j] = 0;
                        next[i][j] = j;
                    } else {
                        dist[i][j] = INF;
                        next[i][j] = INF;
                    }
                } else if(graph.get(names.get(i)).contains(names.get(j))) {
                    // There is a way from i to j
                    dist[i][j] = 1;
                    next[i][j] = j;
                } else {
                    dist[i][j] = INF;
                    next[i][j] = INF;
                }
            }
        }

        FW x = floydWarshall(dist, next);
        dist = x.dist;
        next = x.next;



        int lowest = INF, index = 0;
        for (int i = 0; i < dist.length; i++) {
            if(dist[i][i] < lowest) {
                lowest = dist[i][i];
                index = i;
            }
        }

        if(lowest == INF) {
            System.out.println("SHIP IT");
        } else {
            // Get cycle from i to i
            int a = index, b = index;
            for (int i = 0; i < lowest; i++) {
                System.out.print(names.get(next[a][b]));
                if(i < lowest - 1) {
                    System.out.print(" ");
                }
                a = next[a][b];
            }
            if(lowest == 0) {
                System.out.println(names.get(next[a][b]));
            }
        }


    }



    static class FW {
        int[][] dist;
        int[][] next;

        public FW(int[][] dist, int[][] next) {
            this.dist = dist;
            this.next = next;
        }

    }

    private static FW floydWarshall(int[][] dist, int[][] next) {
        for (int k = 0; k < dist.length; k++) {
            for (int i = 0; i < dist.length; i++) {
                for (int j = 0; j < dist.length; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        return new FW(dist, next);
    }

    private static void printMatrix(int[][] d) {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                if(d[i][j] >= INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(d[i][j] +"   ");
                }
            }
            System.out.println();
        }
    }


}

/*
// construct Floyd-Warshall matrix for dp search
    int[][] d = new int[nrNodes][nrNodes];
    for (int i = 0; i < nrNodes; i++) {
        for (int j = 0; j < nrNodes; j++) {
            if(i == j) {
                d[i][j] = Integer.MAX_VALUE;
            } else if(graph.get(names.get(i)).contains(names.get(j))) {
                // There is a way from i to j
                d[i][j] = 1;
            } else {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    d = floydWarshall(d);

    for (int i = 0; i < nrNodes; i++) {
        for (int j = 0; j < nrNodes; j++) {
            if(d[i][j] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(d[i][j] +"   ");
            }
        }
        System.out.println();
    }
*/
