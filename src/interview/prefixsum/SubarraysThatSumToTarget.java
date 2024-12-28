package interview.prefixsum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * from ChatGPT
 * TODO understand this
 * see: bottom problem at https://algo.monster/problems/subarray_sum
 */
public class SubarraysThatSumToTarget {

    public static void main(String[] args) {

        List<Integer> l1 = List.of(1,0,2,1,2);
        System.out.println("num subarrays: " + numSubarraysThatSumUpToTarget(l1, 3));
        subarraysThatSumUpToTarget(l1, 3)
                .forEach(System.out::println);
    }

    public static int numSubarraysThatSumUpToTarget(List<Integer> arr, int target) {
        HashMap<Integer, Integer> psumMap = new HashMap<>(); //psum : freq
        psumMap.put(0, 1); //since empty array's sum is 0
        int currSum = 0, result = 0;
        for (int val : arr) {
            currSum += val;
            //target = currSum - complement
            int complement = currSum - target;
            if (psumMap.containsKey(complement)) {
                result += psumMap.get(complement);
            }
            psumMap.merge(currSum, 1, Integer::sum);
        }
        return result;
    }

    public static List<List<Integer>> subarraysThatSumUpToTarget(List<Integer> arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> psumMap = new HashMap<>(); //psum : j-indices
        psumMap.computeIfAbsent(0, k -> new ArrayList<>()).add(-1);
        int currSum = 0;
        for (int j = 0; j < arr.size(); j++) {
            currSum += arr.get(j);
            //target = currSum - complement
            int complement = currSum - target;
            if (psumMap.containsKey(complement)) {
                for (int i : psumMap.get(complement)) {
                    result.add(arr.subList(i+1, j+1)); //subList upperbound is exclusive, so need j+1
                }
            }
            psumMap.computeIfAbsent(currSum, k -> new ArrayList<>()).add(j);
        }
        return result;
    }

    /*
    public static int numSubarraysThatSumUpToTargetDebug(List<Integer> arr, int target) {
        HashMap<Integer, Integer> psumMap = new HashMap<>(); //psum : freq
        psumMap.put(0, 1); //since empty array's sum is 0
        System.out.println("init map:" + psumMap);
        int currSum = 0, result = 0;
        for (int val : arr) {
            currSum += val;
            System.out.println("---------\ncurrSum: " + currSum);
            //target = currSum - complement
            int complement = currSum - target;
            System.out.println("complement: " + complement);
            if (psumMap.containsKey(complement)) {
                System.out.println("complement found, incr result by: " + psumMap.get(complement));
                result += psumMap.get(complement);
            }
            psumMap.merge(currSum, 1, Integer::sum);
            System.out.println("map:" + psumMap);
        }
        return result;
    }
    */
}
