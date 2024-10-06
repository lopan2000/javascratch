package interview;

import java.util.*;

public class InterviewQuestions {

    public static void main(String[] args) {
        /*
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
         */
        /*
        int[] arr = generateOddReverseArray();
        Arrays.stream(arr).forEach(System.out::println);
        */
        //System.out.println(sortAscAndRemoveDupes("213414415"));
        System.out.println(removeDuplicates("1112233"));
    }

    private static void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while (l < r) {
            char tempL = s[l];
            s[l] = s[r];
            s[r] = tempL;
            l++;
            r--;
        }
    }

    private static int[] generateOddReverseArray() {
        int n = 100;
        int[] result = new int[n/2];
        for (int i = 0, j = n-1; i < result.length; i++, j-=2) {
            result[i] = j;
        }
        return result;
    }

    private static String sortAscAndRemoveDupes(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return String.valueOf(arr).substring(0, slow+1);
    }

    public static String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return String.valueOf(arr).substring(0, slow+1);
    }

    /* (TODO)
    Air traffic control needs to lands planes coming into an airport. Return a list of the order the planes should land according to 1) their priority[high, medium, low], 2) their size[large, medium, small] and 3) by their time of arrival
     */
}
