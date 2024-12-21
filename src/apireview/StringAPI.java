package apireview;

import java.util.Arrays;

public class StringAPI {

    public static void main(String[] args) {
        //testParsing();
        testStringIntern();
    }

    private static void testParsing() {
        /*
        paypalSplitString("WWWW");
        paypalSplitString("WBWW");
        paypalSplitString("WBBWBBB");
        paypalSplitString("WBBWBBBW");
        paypalSplitString("BBB");
         */

        String s = "leet**cod*e";
        leetCodeRemoveStarsFromString(s);
    }

    /*
    From Paypal round 0:
    "WWWW" -> []
    "WBWW" -> ["B"]
    "WBBWBBB" -> ["BB","BBB"]
    etc...
     */
    private static void paypalSplitString(String s) {
        System.out.println(Arrays.toString(
                s.replaceAll("^W+|W+$", "").split("W+")));
    }

    private static void leetCodeRemoveStarsFromString(String s) {
        System.out.println(Arrays.toString(
                s.replaceAll("^\\*+|\\*+$", "").split("\\*+")));
    }

    private static void testStringIntern() {
        String s1 = "abc";                          //str literals always stored in str pool
        String s2 = "abc";                          //str literals always stored in str pool
        String s3 = (s1 + s2).substring(0,3);       //derived string not in str pool
        System.out.println(s1 == s2 && s2 == s3);   //false
        s3 = s3.intern();                           //returns ref to the existing str in the pool (same ref s1 and s2 hold), otherwise would add it to pool
        System.out.println(s1 == s2 && s2 == s3);   //true
    }


}