package interview.slidingwindow;

public class FixedWindow {

    public static void main(String[] args) {
        System.out.println(maxSubarraySumLengthK(new int[]{1,1,1,5,2,90,1}, 3));
    }

    /*
    1 <= k <= n
     */
    private static int maxSubarraySumLengthK(int[] nums, int k) {
        int winSum = 0;
        for (int i = 0; i < k; i++) {
            winSum += nums[i];
        }
        int maxSum = winSum;
        for (int r = k; r < nums.length; r++) {
            int l = r-k+1;
            winSum -= nums[l-1];
            winSum += nums[r];
            maxSum = Math.max(maxSum, winSum);
        }
        return maxSum;
    }
}