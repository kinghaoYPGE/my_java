package demo;


import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * 函数式接口配合stream
 */
public class LambdaTest3 {
    public static void main(String[] args) {
        Predicate<Integer> predicate = a -> a > 50;

        System.out.println(predicate.test(52));

        IntPredicate intPredicate = a -> a > 50;

       IntStream.of(10, 12, 34, 342, 231, -98, 20)
                .filter(intPredicate)
                .peek(System.out::println).count();
    }
}
