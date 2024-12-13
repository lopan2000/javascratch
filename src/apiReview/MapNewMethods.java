package apiReview;

import java.util.*;

public class MapNewMethods {

    public static void main(String[] args) {
        //countCharOccurrencesAndPrintTheOneWithMaxOccurrences();
        countCharOccurrencesAndPrintTheOnesWithMaxOccurrence();
    }

    private static void computeIfAbsent() {
        List<String> list = List.of("a", "b", "c");
        Map<String, List<Integer>> map = new HashMap<>();
        for (String s : list) {
            map.computeIfAbsent(s, key -> new ArrayList<>()).add(7);
        }
    }

    private static void mapEntryIteration() {
        List<String> list = List.of("a", "b", "c");
        Map<String, List<Integer>> map = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void countCharOccurrencesAndPrintTheOneWithMaxOccurrences() {
        String s = "aabcdklmmmbcl";
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        Character maxChar = null;
        for (char c : s.toCharArray()) {
            int count = map.merge(c, 1, Integer::sum);
            if (count > maxCount) {
                maxCount = count;
                maxChar = c;
            }
        }
        System.out.println(maxChar);
    }

    private static void countCharOccurrencesAndPrintTheOnesWithMaxOccurrence() {
        String s = "aadasdddvaaadd";
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        Set<Character> maxChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            int count = map.merge(c, 1, Integer::sum);
            if (count > maxCount) {
                maxCount = count;
                maxChars.clear();
                maxChars.add(c);
            } else if (count == maxCount) {
                maxChars.add(c);
            }
        }
        System.out.println(maxChars);
    }
}