package interview.combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InOrOut {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        dfs(3, 0, new ArrayList<Integer>(), result);
        System.out.println(result);
    }

    private static void dfs(int n, int depth,
                            List<Integer> path, List<String> result) {
        if (depth == n) {
            result.add(path.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining()));
            return;
        }
        for (int x : new int[]{0,1}) {
            path.add(x);
            dfs(n, depth+1, path, result);
            path.removeLast();
        }
    }
}
