import java.util.*;
public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean impossibleFlag = false;
        while (scan.hasNextInt()) {
            int cases = scan.nextInt();
            PriorityQueue<Integer> prioQueue = new PriorityQueue<>(new maxComp());
            LinkedList<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            boolean possiblePrio = true;
            boolean possibleQueue = true;
            boolean possibleStack = true;
            int i = 0;
            int oneCount = 0;
            int twoCount = 0;
            loop:
            for (; i < cases; i++) {
                int command = scan.nextInt();
                if (command == 1) {
                    int value = scan.nextInt();
                    prioQueue.add(value);
                    stack.push(value);
                    queue.add(value);
                    oneCount++;
                }
                if (command == 2) {
                    int value = scan.nextInt();
                    if (twoCount < oneCount) {
                        if (prioQueue.poll() == value && possiblePrio)
                            possiblePrio = true;
                        else
                            possiblePrio = false;
                        if (queue.poll() == value && possibleQueue)
                            possibleQueue = true;
                        else
                            possibleQueue = false;
                        if (stack.pop() == value && possibleStack)
                            possibleStack = true;
                        else
                            possibleStack = false;
                        twoCount++;
                    } else {
                        impossibleFlag = true;
                    }

                }
                if (impossibleFlag && i == cases-1) {
                    System.out.println("impossible");
                } else if(i == cases-1){
                    if (!possiblePrio && !possibleQueue && !possibleStack)
                        System.out.println("impossible");
                    else if (possiblePrio && possibleQueue && possibleStack)
                        System.out.println("not sure");
                    else if (possiblePrio && possibleQueue && !possibleStack)
                        System.out.println("not sure");
                    else if (possiblePrio && !possibleQueue && possibleStack)
                        System.out.println("not sure");
                    else if (!possiblePrio && possibleQueue && possibleStack)
                        System.out.println("not sure");
                    else if (possiblePrio && !possibleQueue && !possibleStack)
                        System.out.println("priority queue");
                    else if (!possiblePrio && !possibleQueue && possibleStack)
                        System.out.println("stack");
                    else if (!possiblePrio && possibleQueue && !possibleStack)
                        System.out.println("queue");
                }
            }
        }
    }
}
class maxComp implements Comparator<Integer>{

    @Override
    public int compare(Integer integer, Integer t1) {
        return  t1.compareTo(integer);
    }
}