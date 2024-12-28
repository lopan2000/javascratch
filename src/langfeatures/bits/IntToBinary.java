package langfeatures.bits;

public class IntToBinary {

    public static void main(String[] args) {
        testDecToBin();
        Integer.toBinaryString(8);
    }

    private static void testDecToBin() {
        for (int i = 0; i < 16; i++) {
            String b = decToBin(i);
            System.out.println(i + ": " + b + ", " + binToDec(b));
        }
    }

    private static String decToBin(int x) {
        if (x == 0) {
            return "0";
        }
        StringBuilder binBuilder = new StringBuilder();
        while (x != 0) {
            int bit = x & 0b1; //isolate LSB
            binBuilder.append(bit);
            x >>>= 1;
        }
        return binBuilder.reverse().toString();
    }

    private static int binToDec(String b) {
        int x = 0, n = 0;
        char[] arr = b.toCharArray();
        for (int i = arr.length-1; i > -1; i--) {
            int decVal = arr[i] - '0'; //either 48-48=0, 49-48=1
            x += decVal * (int) Math.pow(2, n);
            n++;
        }
        return x;
    }
}
