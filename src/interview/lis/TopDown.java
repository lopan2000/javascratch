package interview.lis;

public class TopDown {

    private int lis = 0;

    public static void main(String[] args) {
        TopDown td = new TopDown();
        System.out.println(td.lengthOfLIS(new int[]{1,2,0,3}));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+1]; //why n+1 not n?
        f(n, nums, memo);
        return lis;
    }

    /*
        simplified:
            -Think of i as the parent, j's as children, where
             a parent i always has [1..i-1] children.

        f(i) {                              //init: i = n
            if (i == 0) { return 0; }       //base case
            for (int j = 1; j < i; j++) {   //j = 1..i-1
                len = f(j);                 //recurse
            }
            return len;
     */
    private int f(int i, int[] nums, int[] memo) { //init(n)
        if (memo[i] != 0) {
            return memo[i];
        }
        int len = 1; //originally: 'int len = f(0, nums, memo) + 1';
        int ni = nums[i-1];
        for (int j = 1; j < i; j++) {
            int nj = nums[j-1];
            int fOfJ = f(j, nums, memo); //f(j)
            if (nj < ni) { //is increasing subseq?
                len = Math.max(len, fOfJ+1);
            }
        }
        lis = Math.max(lis, len);
        memo[i] = len;
        return len;
    }
}