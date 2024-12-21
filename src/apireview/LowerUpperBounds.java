package apireview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LowerUpperBounds {

    public static void main(String[] args) {
        //addElementsToListOfLowerType();
        printListOfAnyHigherOrEqualType();
    }

    private static void addElementsToListOfLowerType() {
        List<Number> list = new ArrayList<>();
        list.add(0);
        //addAll(Collection<? super T> c, T... elements)
        Collections.addAll(list, 1, 2, 3, Double.valueOf("4.5"));
        System.out.println(list);
    }

    private static void printListOfAnyHigherOrEqualType() {
        List<Integer> list = List.of(1,2,3);
        doPrintListOfAnyHigherOrEqualType(list);
    }

    private static void doPrintListOfAnyHigherOrEqualType(List<? extends Number> list) {
        list.forEach(System.out::println);
    }

}
