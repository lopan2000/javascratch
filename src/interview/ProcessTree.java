package interview;

import java.util.ArrayDeque;
import java.util.stream.IntStream;

public class ProcessTree {

    public static void main(String[] args) {
        //System.out.println(linearSolution(10));
    }

    private static record Node(int val, Integer parent) {}

    private static Integer linearSolution(int n) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int i = 1;
        queue.add(new Node(i, null));
        while (!queue.isEmpty()) {
            for (int j = 0; j < queue.size(); j++) {
                Node node = queue.removeFirst();
                if (node.val == n) {
                    return node.parent;
                }
                for (int k = 0; k < node.val; k++) {
                    queue.add(new Node(++i, node.val));
                }
            }
        }
        throw new IllegalStateException();
    }

    private static Integer logSolution(int n) {
        return null;
    }
}
