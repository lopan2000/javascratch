package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PowerSet {

    public static void main(String[] args) {
        //System.out.println(getPowerSet2(new int[]{1,2,3}));
        System.out.println(getPowerSet(new int[]{1,2,3}));
    }

    public static List<List<Integer>> getPowerSet(int[] set) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(new ArrayList<Integer>(), 0, set, result);
        return result;
    }

    public static void dfs(List<Integer> path, int i,
                int[] set, List<List<Integer>> result) {

        result.add(new ArrayList<>(path));
        for (int j = i; j < set.length; j++) {
            path.add(set[j]);
            dfs(path, j+1, set, result);
            path.removeLast();
        }
    }

    /*
    Uncommon to use a Consumer to impl DFS recursion, but this was
    just a proof-of-concept b/c I wanted to use closures similar to
    Python.
     */
    public static List<List<Integer>> getPowerSet2(int[] set) {
        List<List<Integer>> result = new ArrayList<>();
        BiConsumer<List<Integer>, Integer> dfs = new BiConsumer<>() {
            @Override
            public void accept(List<Integer> path, Integer i) {
                result.add(new ArrayList<Integer>(path));
                for (int j = i; j < set.length; j++) {
                    path.add(set[j]);
                    this.accept(path, j+1);
                    path.removeLast();
                }
            }
        };
        dfs.accept(new ArrayList<>(), 0);
        return result;
    }
}
