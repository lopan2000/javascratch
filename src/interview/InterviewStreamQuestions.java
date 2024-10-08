package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterviewStreamQuestions {

    public static void main(String[] args) {
        System.out.println(
                sumOfEvenNums(Arrays.asList(1,2,3,4)));
        System.out.println(
                findMaxLengthString(Arrays.asList("apple","oranges","mountain")));
        System.out.println(
                filterInNumsGreaterThanTen(Arrays.asList(1,2,22,3,4,55,5,6)));
        System.out.println(
                groupStringsByLength(Arrays.asList("apple","oranges","mountain")));
        System.out.println(
                joinListOfStrings(Arrays.asList("apple","oranges","mountain"), "|"));
    }

    private static int sumOfEvenNums(List<Integer> nums) {
        return nums.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static String findMaxLengthString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    public static List<Integer> filterInNumsGreaterThanTen(List<Integer> nums) {
        return nums.stream()
                .filter(i -> i > 10)
                .collect(Collectors.toList());
    }

    public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    public static String joinListOfStrings(List<String> strings, String delim) {
        return strings.stream()
                .collect(Collectors.joining(delim));
    }
}
