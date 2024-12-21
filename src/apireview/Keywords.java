package apireview;

import java.util.HashSet;

public class Keywords {

    public static void main(String[] args) {
        //assertTest();
        //byteTest();
        //shortTest();
        //System.out.println(yieldTest("Monday"));
        //charTest();

        HashSet<Integer> set = new HashSet<>();
        Integer x = 7;
        set.add(x);
        System.out.println(set);
        x = 6;
        System.out.println(set);
    }

    //to enable assertions, need to add JVM arg: -ea
    private static void assertTest() {
        try {
            assert 1+1 == 3;
        } catch (AssertionError e) {
            System.out.println("Failed assertion: 1+1 == 3");
        }
    }

    //byte is signed 8-bit (7-bit with a high-order sign-bit, so vals: -2^7 to 2^7-1 = -128 to 127)
    private static void byteTest() {
        byte b1 = 127;
        System.out.println("b1: " + b1);
        b1++;
        System.out.println("b1: " + b1); //overflow wraps to -128
    }

    //short is signed 16-bit (15-bit with sign-bit, so vals: -2^15 to 2^15-1 = -32768 to 32767)
    private static void shortTest() {
        short s1 = 32767;
        System.out.println("s1: " + s1);
        s1++;
        System.out.println("s1: " + s1); //overflow wraps to -32768
    }

    //char is 16-bit (unsigned, so vals: 0 to 2^16-1 = 65535)
    //Uses UTF encoding: a single 16-bit Unicode character.
    private static void charTest() {
        char c = 32767;
        System.out.println("c: " + c);
        c++;
        System.out.println("c: " + c); //overflow wraps to -32768
    }

    private static String yieldTest(String day) {
        return switch(day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> {
                yield "weekday";
            }
            case "Saturday", "Sunday" -> {
                yield "weekend";
            }
            default -> {
                yield "invalid day";
            }
        };
    }
}
