package langfeatures.regex;

import java.util.Arrays;

public class StringSplitting {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                splitOnCharsNumOrNumCharsBreaks()));
    }

    /*
*       0 or more
?       0 or 1
+       1 or more
(?<= )  positive lookbehind
(?= )   positive lookahead
\\d     digit
\\D     non-digit
     */
    private static String[] splitOnCharsNumOrNumCharsBreaks() {
        String s = "i126758765iz4n";
        return s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
    }
}