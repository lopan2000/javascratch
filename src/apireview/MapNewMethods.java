package apireview;

import java.util.*;

public class MapNewMethods {

    public static void main(String[] args) {
        //computeIfAbsent();
        //countCharOccurrencesAndPrintTheOneWithMaxOccurrences();
        //countCharOccurrencesAndPrintTheOnesWithMaxOccurrence();
        //removeFromMapInPlace();
        //testGetOrDefault();
        testPutIfAbsent();
    }

    private static void computeIfAbsent() {
        List<String> list = List.of("a", "b", "c");
        Map<String, List<Integer>> map = new HashMap<>();
        for (String s : list) {
            map.computeIfAbsent(s, key -> new ArrayList<>()).add(7);    //returns the val (the list), upon which we call add()
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

    private static void removeFromMapInPlace() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 23);
        map.put("Fred", 50);
        map.put("Jim", 30);
        System.out.println(map);
        map.entrySet().removeIf(entry -> entry.getValue() > 40);
        System.out.println(map);
    }

    private static void testGetOrDefault() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(map.getOrDefault("a", -1));  //1
        System.out.println(map.getOrDefault("b", -1));  //2
        System.out.println(map.getOrDefault("c", -1));  //-1
    }

    /*
        Only put if key is absent.

        case 1: key is absent
            put(key,val) and return null

        case 2: key is not absent
            don't put(key,newval) and return oldval that was in map
     */
    private static void testPutIfAbsent() {
        Map<String, Integer> map = new HashMap<>();
        Integer prevVal = map.putIfAbsent("a", 1);
        System.out.println(prevVal);                    //null
        prevVal = map.putIfAbsent("a", 100);            //(not put since key not absent)
        System.out.println(prevVal);                    //1
        System.out.println(map.get("a"));               //1 (still val=1 since the val->100 wasn't put since key="a" was 'not' absent)
        System.out.println(map.putIfAbsent("a", 1));    //1
    }

}