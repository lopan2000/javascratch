package interview;

/*
1,2,3,4,5,6,7,8     8-3=5
5,6,7
 */
public class ExigerIsArray2InArray1 {

    public static void main(String[] args) {
        int[] arrA = {1,2,3,4,5,6,7,8};    //len=n=8
        int[] arrB = {5,6,7};              //len=m=3
        System.out.println(isContiguousSubarray(arrA, arrB));
    }

    /*
    Determine if arr2 is a contiguous subarray of arr1.
    Run-time: O(n*m)
    Space: O(1)
     */
    public static boolean isContiguousSubarray(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        if (n == 0 || m == 0 || m > n) {
            return false;
        }
        for (int i = 0; i < n-m+1; i++) {
            for (int j = 0; j < m; j++) {
                if (arr2[j] != arr1[j+i]) {
                    break;
                } else if (j == m-1) {
                    return true;
                }
            }
        }
        return false;
    }
}

