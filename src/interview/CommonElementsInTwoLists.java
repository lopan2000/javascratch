package interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElementsInTwoLists {

    public static void main(String[] args) {
        System.out.println(getCommonElements(List.of(99,1,2,3), List.of(1,99,3,4,5)));
    }

    private static List<Integer> getCommonElements(List<Integer> l1, List<Integer> l2) {
        if (l1.size() > l2.size()) {
            getCommonElements(l2, l1);
        }
        Set<Integer> l1Set = new HashSet<>(l1);     //a Set could be constructed from a List
        List<Integer> result = new ArrayList<>();
        for (Integer y : l2) {
            if (l1Set.contains(y)) {
                result.add(y);
            }
        }
        return result;
    }
}
