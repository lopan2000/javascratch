package interview.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VariableWindow {

    public static void main(String[] args) {

        int[] arr1 = new int[]{10, 11, 12, 13, 14, 15};
        //int[] arr1 = new int[]{1,2,5,50,2,3};
        //int[] arr1 = new int[]{0,0,0};

        //System.out.println(longestSubArrayLengthLessEqualToTarget(arr1, -1));
        //System.out.println(Arrays.toString(longestSubArrayLessEqualToTarget(arr1, 5)));
        System.out.println(shortestSubArrayLengthGreaterEqualToTarget(arr1, 40));
        System.out.println(Arrays.toString(shortestSubArrayGreaterEqualToTarget(arr1, 40)));

    }

    private static int longestSubArrayLengthLessEqualToTarget(int[] arr, int trg) {
        int winSum = 0, maxLen = 0, l = 0, n = arr.length;
        for (int r = 0; r < n; r++) {
            winSum += arr[r];
            while (winSum > trg && l < n) {         //while win invalid... until we empty the window if necessary
                winSum -= arr[l];
                l++;
            }
            //now win is valid
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    //(TODO) test impl
    private static int[] longestSubArrayLessEqualToTarget(int[] arr, int trg) {
        int winSum = 0, maxLen = 0, l = 0, n = arr.length;
        int[] maxWinIndices = null;
        for (int r = 0; r < n; r++) {
            winSum += arr[r];
            while (winSum > trg) {
                winSum -= arr[l];
                l++;
            }
            int winLen = r - l + 1;
            if (winLen > maxLen) {
                maxLen = winLen;
                maxWinIndices = new int[]{l, r};
            }
        }
        return maxWinIndices != null ?
                Arrays.copyOfRange(arr, maxWinIndices[0], maxWinIndices[1] + 1) : new int[0];
    }

    private static List<int[]> longestSubArraysLessEqualToTarget(int[] arr, int trg) {
        int winSum = 0, maxLen = 0, l = 0, n = arr.length;
        //...
        return null;
    }

    private static int shortestSubArrayLengthGreaterEqualToTarget(int[] arr, int trg) {
        int n = arr.length, winSum = 0, minLen = n + 1, l = 0;
        for (int r = 0; r < n; r++) {
            winSum += arr[r];
            while (winSum >= trg && l < n) {        //while valid, see how much we could shorten by bringing L in
                minLen = Math.min(minLen, r - l + 1);
                winSum -= arr[l];
                l++;
            }
        }
        return minLen <= n && minLen > -1 ? minLen : 0;
    }

    private static int[] shortestSubArrayGreaterEqualToTarget(int[] arr, int trg) {
        int n = arr.length, winSum = 0, minLen = n + 1, l = 0;
        int[] minWinIndices = null;
        for (int r = 0; r < n; r++) {
            winSum += arr[r];
            while (winSum >= trg && l < n) {
                int winLen = r - l + 1;
                if (winLen < minLen) {
                    minLen = winLen;
                    minWinIndices = new int[]{l, r};
                }
                winSum -= arr[l];
                l++;
            }
        }
        return minLen <= n && minLen > -1 ?
                Arrays.copyOfRange(arr, minWinIndices[0], minWinIndices[1]+1) : new int[0];
    }
}
