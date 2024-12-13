package langfeatures.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        createFreqMapFromListWithGroupingBy();
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