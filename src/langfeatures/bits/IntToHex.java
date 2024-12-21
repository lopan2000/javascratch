package langfeatures.bits;

public class IntToHex {

    public static void main(String[] args) {
        //testCharArithmetic01();
        //generateASCIIChart();
        //testDecToHexPositive();
        //testDecToHexNegavite();
        //testHexToDecPositive();
        testHexToDecNegative();
    }

    private static void testDecToHexPositive() {
        for (int i = 0; i < 100; i++) {
            System.out.println(decToHex(i));
        }
    }

    private static void testDecToHexNegavite() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(decToHex(-i));
        }
    }

    private static void testHexToDecPositive() {
        for (int i = 0; i < 100; i++) {
            String h = decToHex(i);
            System.out.println(i + " -> " + h +
                    " -> " + hexToDec(h));
        }
    }

    private static void testHexToDecNegative() {
        for (int i = 1; i <= 100; i++) {
            String h = decToHex(-i);
            System.out.println(-i + " -> " + h +
                    " -> " + hexToDec(h));
        }
    }

    private static String decToHex(int x) {
        if (x == 0) {
            return "0";
        }
        StringBuilder hexBuilder = new StringBuilder();
        while (x != 0) {
            //extract least-significant nibble (4-bits)
            int lsNibble = x & 0xF; //0b1111
            if (lsNibble < 10) {
                hexBuilder.append(lsNibble);
            } else {
                //10-15 dec -> A-F hex
                hexBuilder.append((char) ('a' + lsNibble - 10));
            }
            x >>>= 4;
        }
        return hexBuilder.reverse().toString();
    }

    private static int hexToDec(String h) {
        char[] arr = h.toCharArray();
        int x = 0, n = 0;
        for (int i = arr.length-1; i > -1; i--) {
            char hexChar = arr[i];
            int decVal = 0;
            if (Character.isDigit(hexChar)) {
                decVal = hexChar - '0';
            } else {
                decVal = hexChar - 'a' + 10;
            }
            x += decVal * (int) Math.pow(16, n);
            n++;
        }
        return x;
    }

    /*
    48: 0
    65: A
    97: a
     */
    private static void testCharArithmetic01() {
        System.out.println((int) 'a');
        System.out.println((char) 'a');
        System.out.println((char) ('a' + 1));
        System.out.println((char) ('a' + 2));
    }

    private static void generateASCIIChart() {
        for (int i = 0; i < 128; i++) {
            System.out.println(i + ": " + (char) i);
        }
    }
}