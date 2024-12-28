package threads.challenges;

import java.util.Arrays;

/**
Is this anything?  -delete?
 */
public class SumOfArraySegments {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int numSubArrays = 4;
        int n = arr.length / numSubArrays;

        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            r = l+n-1;
            if (i == n-1 && r < arr.length-1) {
                r = arr.length-1;
            }
            System.out.println(arr[l] + "," + arr[r]);
            l = r+1;
        }
    }
}


