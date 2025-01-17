package interview.combinatorics;

import java.util.Arrays;

public class Knapsack01BruteForce {

    public static void main(String[] args) {



    }

    private static int dfs(int depth, int[] weights,
                            int[] values, int remainingWeight, int n) {
        if (n == 0 || remainingWeight == 0) {
            return 0;
        }
        return -1;
    }
}
