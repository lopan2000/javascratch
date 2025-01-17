package langfeatures.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class BaseStreamSubclasses {

    /*
     * public interface BaseStream<T, S extends BaseStream<T,S>>
     *   T                          //the type of the stream elements
     *   S extends BaseStream<T,S>  //the type of the stream implementing BaseStream
     *
     * public interface Stream<T> extends BaseStream<T, Stream<T>>
     *
     *
     *
     *
     *
     *
     */
    public static void main(String[] args) {
        //intStream();
        Random rand = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(rand.nextInt(3));
        }
    }

    /*
    public interface IntStream extends BaseStream<T, IntStream>
     */
    private static void intStream() {

        //range
        String range = IntStream.range(1, 11)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        System.out.println("range: " + range);

        //count
        long count = IntStream.range(1, 11).count();
        System.out.println("count: " + count);

        //avg
        OptionalDouble avg = IntStream.range(1, 11).average();
        System.out.println("avg: " + (avg.isPresent() ? avg.getAsDouble() : "n/a"));

        //concat
        String concat = IntStream.concat(IntStream.of(1,2,3), IntStream.of(4,5,6))
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        System.out.println("concat: " + concat);

        //distinct
        String distinct = IntStream.of(1,1,2,2,2,3,3,3,3,3,3)
                .distinct()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        System.out.println("distinct: " + distinct);

        //limit
        String limit = IntStream.range(1,11)
                .limit(3)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        System.out.println("limit: " + limit);

        //max (min also available)
        OptionalInt max = IntStream.of(3,1,-5,999,6,0).max();
        System.out.println("max: " + (max.isPresent() ? max.getAsInt() : "n/a"));

        //max -- cool example:
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        result.add(List.of(1,2,3));
        result.add(List.of(1,2));
        int maxSize = result.stream()
                .mapToInt(List::size)
                .max()
                .orElse(0);
        System.out.println("max list size: " + maxSize);

        //none match
        boolean isNoneMatch = IntStream.of(1,2,3)
                .noneMatch(x -> x == 999);
        System.out.println("isNoneMatch: " + isNoneMatch);

        //sorted
        String sorted = IntStream.of(5,3,8,1,9,4)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(","));
        System.out.println("sorted: " + sorted);

        //sum
        int sum = IntStream.of(1,2,3).sum();
        System.out.println("sum: " + sum);

        //peek
        IntStream.of(1,2,3)
                .peek(x -> System.out.println("before adding 10: " + x))
                .map(x -> x + 10)
                .forEach(x -> System.out.println("after adding 10: " + x)); //each stream iteration is peek(xi)->map(xi)->forEach(xi)
    }

    /*
    public interface LongStream extends BaseStream<T, LongStream>
     */
    private static void longStream() {
        LongStream.of(1,2,3).forEach(System.out::print);
    }

    /*
    public interface DoubleStream extends BaseStream<T, DoubleStream>
     */
    private static void doubleStream() {
        DoubleStream.of(1.1,2.2,3.3).forEach(System.out::println);
    }
}