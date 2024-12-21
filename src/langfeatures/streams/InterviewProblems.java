package langfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/
 */
public class InterviewProblems {

    public static void main(String[] args) {
        //separateOddEven();
        //accumulateNamesIntoList();
        //accumulateNamesIntoTreeSet();
        //convertElementsToStringsAndConcatCommaDelim();
        //sumSalaries();
        //createFreqMapFromArray();
        //createFreqMapFromList();
        //createFreqMapFromListWithGroupingBy();
        //populateStringBuilder();
        //collectStringIntolist();
        //cartesianProduct();
        //unionOfTwoArrays();
        unionOfTwoPrimitiveArrays();
    }

    private static void separateOddEven() {
        List<Integer> nums = List.of(1,2,3,4,5,6,7,8);

        Map<Boolean, List<Integer>> map = nums.stream()
                        .collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println("Even:");
        map.get(true).forEach(System.out::println);

        System.out.println("Odd:");
        map.get(false).forEach(System.out::println);
    }

    // Accumulate names into a List
    private static void accumulateNamesIntoList() {
        List<Person> people = List.of(new Person("Phil"), new Person("Fred"));
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
                //.collect(Collectors.toList());
        names.forEach(System.out::println);
    }

    // Accumulate names into a TreeSet
    private static void accumulateNamesIntoTreeSet() {
        List<Person> people = List.of(new Person("Phil"), new Person("Fred"));
        TreeSet<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));
        names.forEach(System.out::println);
    }

    // Convert elements to strings and concatenate them, separated by commas
    private static void convertElementsToStringsAndConcatCommaDelim() {
        List<Person> people = List.of(new Person("Phil"), new Person("Fred"));
        String s = people.stream()
                .map(Person::toString)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }

    // Compute sum of salaries of employee
    private static void sumSalaries() {
        List<Person> people = List.of(new Person("Phil",3), new Person("Fred",4));
        int sum = people.stream().mapToInt(Person::getSalary).sum();
        //.collect(Collectors.summingInt(Person::getSalary));
        System.out.println(sum);
    }

    private static void createFreqMapFromArray() {
        int[] arr = {1,1,2,3,4,4,4};
        Map<Integer, Integer> map = Arrays.stream(arr)
                .boxed() //int->Integer
                .collect(Collectors.toMap(
                    x -> x,
                    x -> 1,
                    Integer::sum
                ));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void createFreqMapFromList() {
        List<Integer> list = List.of(1,1,2,3,4,4,4);
        Map<Integer, Integer> map = list.stream()
                .collect(Collectors.toMap(
                        x -> x,
                        x -> 1,
                        Integer::sum
                ));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void createFreqMapFromListWithGroupingBy() {
        List<Integer> list = List.of(1,1,2,3,4,4,4);
        Map<Integer, Long> map = list.stream()
                .collect(Collectors.groupingBy(
                        x -> x,
                        Collectors.counting()
                ));
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void populateStringBuilder() {
        List<String> list = List.of("a","b","c");
        StringBuilder sb = list.stream()
                .collect(StringBuilder::new,    //supplier
                        StringBuilder::append,  //accumulator
                        StringBuilder::append); //combiner (for parallel ops)
        System.out.println(sb.toString());
    }

    private static void collectStringIntolist() {
        List<String> list = List.of("a","b","c");
        List<String> result = list.stream()
                .map(String::toUpperCase)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(result);
    }

    private static void cartesianProduct() {
        List<String> list1 = Arrays.asList("A","B","C");
        List<Integer> list2 = Arrays.asList(1,2,3);
        List<String> result = list1.stream()
                .flatMap(x -> list2.stream()
                        .map(y -> x+y))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private static void unionOfTwoArrays() {
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {4,5,6};
        Integer[] result = Stream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(result));
    }

    private static void unionOfTwoPrimitiveArrays() {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,5,6};
        int[] result = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2))
                .toArray();
        System.out.println(Arrays.toString(result));
    }

    private static class Person {
        private String name;
        private int salary = 0;
        public Person(String name) {
            this.name = name;
        }
        public Person(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getSalary() {
            return salary;
        }
        public void setSalary(int salary) {
            this.salary = salary;
        }
        @Override
        public String toString() {
            return getName();
        }
    }
}