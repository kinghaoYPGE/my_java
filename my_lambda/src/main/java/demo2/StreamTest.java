package demo2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        // forEach
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);

        // map
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 4, 5);
        numbers.forEach(a -> System.out.print(a + "\t"));
        List<Integer> squareList = numbers.stream().map(i -> i * 2) // 平方
                .distinct() // 去重
                .collect(Collectors.toList()); // 存储到一个新的list
        System.out.println();
        squareList.forEach(a -> System.out.print(a + "\t"));

        // filter
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        List<String> newStrings = strings.stream()
                .filter(s -> (!s.isEmpty()))
                .collect(Collectors.toList());
        newStrings.forEach(System.out::println);

        // reduce
        Integer sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(0, (acc, n) -> acc + n);
        System.out.println(sum);

        // limit
        random.ints().limit(10).forEach(System.out::println);

        // sorted
        random.ints().limit(10).sorted().forEach(System.out::println);

    }
}
