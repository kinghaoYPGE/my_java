package demo2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest2 {
    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");

        long count = strings.parallelStream().filter(String::isEmpty).count();

        System.out.println(count);
    }

    public static void test2() {
        List<String>strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);
    }

    public static void test3() {
        List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
