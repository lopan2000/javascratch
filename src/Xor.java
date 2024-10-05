import java.util.Arrays;

public class Xor {
    public static void main(String[] args) {
        /*
        boolean a = true;
        boolean b = false;
        System.out.println(a ^ b);
        */

        //Note: this is bitwise XOR, so result is 6
        //3 base 10 = 011
        //5 base 10 = 101
        //===============
        //    3 ^ 5 = 110
        //System.out.println(3 ^ 5);

        int result = 0;
        int[] arr = {1,2,3,2,1};
        for (int x : arr) {
            result ^= x;
            //System.out.println(result);
        }
        System.out.println("result: " + result);
        System.out.println("result: " + (1 ^ 2 ^ 3 ^ 2 ^ 1));
    }
}

/**
 * 000 0
 * 001 1
 * 010 2
 * 011 3
 * 100 4
 * 101 5
 * 110 6
 * 111 7
 */
