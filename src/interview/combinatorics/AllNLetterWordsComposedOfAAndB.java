package interview.combinatorics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllNLetterWordsComposedOfAAndB {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        dfs(2, 0, new ArrayList<Character>(), result);
        System.out.println(result);
    }

    private static void dfs(int n, int depth,
                            List<Character> path, List<String> result) {
        if (depth == n) {
            result.add(path.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining()));
            return;
        }
        for (char c : new char[]{'a','b'}) {
            path.add(c);
            dfs(n, depth+1, path, result);
            path.removeLast();
        }
    }
}