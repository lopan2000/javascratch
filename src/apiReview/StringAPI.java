package apiReview;

import java.util.Arrays;

public class StringAPI {

    public static void main(String[] args) {

        /*
        paypalSplitString("WWWW");
        paypalSplitString("WBWW");
        paypalSplitString("WBBWBBB");
        paypalSplitString("WBBWBBBW");
        paypalSplitString("BBB");
         */

        String s = "leet**cod*e";
        leetCodeRemoveStarsFromString(s);
        leetCodeInverseRemoveStarsFromString(s);
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

    private static void leetCodeInverseRemoveStarsFromString(String s) {
        //TODO
    }
}
