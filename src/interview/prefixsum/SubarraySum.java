package interview.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {

        System.out.println("test 1: " + Arrays.toString(
                getSubArraySumIndices(new int[]{1,2,3}, 5)));

        System.out.println("test 2: " + Arrays.toString(
                getSubArraySumIndices(new int[]{1,0,5,2,-4,3,11,-4,1}, 14)));

        //demonstrates need for: psumMap.put(0, -1), else result is null instead of [0,0]
        System.out.println("test 3: " + Arrays.toString(
                getSubArraySumIndices(new int[]{0,5,2,-4,3,11,-4,1}, 0)));
    }

    /*
        The Prefix Sum equation to know:
        sum(arr, i, j) = sum(arr, 0, j) - sum(arr, 0, i-1)
                       = psum[j] - psum[i-1]

        psum - psumComplment = trg
        ...in other words:
            psum[j] - psum[i-1] = trg
     */
    private static int[] getSubArraySumIndices(int[] arr, int trg) {
        Map<Integer, Integer> psumMap = new HashMap<>();
        psumMap.put(0, -1);
        int psum = 0;
        for (int j = 0; j < arr.length; j++) {
            psum += arr[j];
            int psumComplment = psum - trg;
            if (psumMap.containsKey(psumComplment)) {
                int i = psumMap.get(psumComplment) + 1;
                return new int[]{i, j};
            }
            psumMap.put(psum, j);
        }
        return null;
    }

}