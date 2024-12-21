package langfeatures.bits;

/**
 * Java uses 32-bit signed ints, so values in range: -2^31 through (2^31)-1
 *
 * In general, an n-bit signed int would have values in range: -2^(n-1) through (2^(n-1))-1      //(n-1) because of sign-bit, -1 on pos-side to include zero
 *
 * ex) assume n = 4, then we have an 4-bit number with range: -2^3 through (2^3)-1 = [-8, 7] = 16 values = 2^4
 *
 * dec bin
 * --- ----
 * -8  (1000) --invert--> (0111) --add 1--> 1000
 * -7  (0111) --invert--> (1000) --add 1--> 1001
 * -6  (0110) --invert--> (1001) --add 1--> 1010
 * -5  (0101) --invert--> (1010) --add 1--> 1011
 * -4  (0100) --invert--> (1011) --add 1--> 1100
 * -3  (0011) --invert--> (1100) --add 1--> 1101
 * -2  (0010) --invert--> (1101) --add 1--> 1110
 * -1  (0001) --invert--> (1110) --add 1--> 1111
 *  0  0000
 *  1  0001
 *  2  0010
 *  3  0011
 *  4  0100
 *  5  0101
 *  6  0110
 *  7  0111
 */
public class TwosCompliment {

    public static void main(String[] args) {
        testNumber_4bit();
    }

    /*
    4-bit number with range: -2^3 through (2^3)-1 = [-8, 7] = 16 values = 2^4
     */
    private static void testNumber_4bit() {
        final int n = 4;
        printNumValues(n);
        printRange(n);
        int[] range = getDecimalRange(n);
        for (int i = range[0]; i <= range[1]; i++) {
            String binaryString = Integer.toBinaryString(i);
            System.out.println(i + ": " + binaryString);
        }

    }

    private static int[] getDecimalRange(int n) {
        return new int[] {
                -(int) Math.pow(2, n-1),
                ((int) Math.pow(2, n-1)) - 1};
    }

    private static void printRange(int n) {
        int[] range = getDecimalRange(n);
        System.out.println("Range for " + n + "-bits: [" + range[0] + ", " + range[1] + "]");
    }

    private static void printNumValues(int n) {
        System.out.println("Num vals for " + n + "-bits: " + (int) Math.pow(2, n));
    }
}
