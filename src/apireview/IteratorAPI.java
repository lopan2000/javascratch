package apireview;

import java.util.*;

public class IteratorAPI {

    public static void main(String[] args) {
        //removeFromSetInPlace();
        //removeFromListInPlace();
        removeFromMapInPlace();
    }

    //** instead use: set.removeIf(x -> x > 30);
    private static void removeFromSetInPlace() {
        //Set<Integer> set = Set.of(10,20,30,40,50);    //won't work since Set.of() returns an immutable set
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);
        System.out.println(set);
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int x = iter.next();
            if (x > 30) {
                iter.remove();
            }
        }
        System.out.println(set);
    }

    //** instead use: list.removeIf(x -> x > 3);
    private static void removeFromListInPlace() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()) {
            if (iter.next() > 3) {
                iter.remove();
            }
        }
        System.out.println(list);
    }

    //** instead use: map.entrySet().removeIf(entry -> entry.getValue() > 40);
    private static void removeFromMapInPlace() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 23);
        map.put("Fred", 50);
        map.put("Jim", 30);
        System.out.println(map);
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            if (entry.getValue() > 40) {
                iter.remove();
            }
        }
        System.out.println(map);
    }
}
