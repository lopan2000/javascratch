package langfeatures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

public class Sorting {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(4,2,6,3,6,7);
        //list.sort((a,b) -> Integer.compare(a,b));
        list.sort(comparingInt(Integer::intValue));
        list.stream()
                .forEach(System.out::println);
    }
}
