import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class intergalacticbidding {

    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] line = sc.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        BigInteger s = new BigInteger(line[1]);
        ArrayList<Bidder> bidders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            line = sc.readLine().split(" ");
            BigInteger bid = new BigInteger(line[1]);
            if(bid.compareTo(s) > 0) {
                continue;
            }
            bidders.add(new Bidder(line[0], bid));
        }

        bidders.sort((x,y) -> x.bid.compareTo(y.bid) * -1);

        search(bidders, s, new ArrayList<>());

        out.println(0);
        out.flush();
    }

    private static boolean search(List<Bidder> bidders, BigInteger sum, ArrayList<String> names) {
        if(sum.compareTo(BigInteger.ZERO) == 0) {
            out.println(names.size());
            for (String name : names) {
                out.println(name);
            }
            out.flush();
            System.exit(0);
        }

        if(bidders.size() == 0 || sum.compareTo(BigInteger.ZERO) < 0 || sum.compareTo(bidders.get(0).bid.multiply(BigInteger.valueOf(2))) >= 0) {
            return false;
        }

        search(bidders.subList(1, bidders.size()), sum.subtract(bidders.get(0).bid), Stream.concat(names.stream(), new ArrayList<>(Collections.singletonList(bidders.get(0).name)).stream()).collect(Collectors.toCollection(ArrayList::new)));
        search(bidders.subList(1, bidders.size()), sum, names);

        return false;
    }

    static class Bidder {

        String name;
        BigInteger bid;

        Bidder(String name, BigInteger bid) {
            this.name = name;
            this.bid = bid;
        }

    }

}
