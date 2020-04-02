package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;


public class LambdaTest2 {
    public static void main(String[] args) {
        test3();
    }

    /**
     * lambda方法引用
     */
    public static void test1() {
        List<String> names = new ArrayList<>();

        names.add("peter");
        names.add("bob");
        names.add("grace");
        names.add("tom");

        names.forEach(System.out::println);
    }

    /**
     * 函数式接口
     */

    public static void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("all numbers: ");
        eval(numbers, n -> true);

        System.out.println("even numbers: ");
        eval(numbers, n -> n % 2 != 0);

        System.out.println(">=3 numbers: ");
        eval(numbers, n -> n >= 3);

    }

    // 过滤指定条件
    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }
    }

    public static void test3() {

        Integer sum = sum(Optional.ofNullable(null), Optional.of(2));
        System.out.println(sum);
    }

    public static Integer sum(Optional<Integer> v1, Optional<Integer> v2) {
        Integer a = v1.orElse(new Integer(0));
        Integer b = v2.get();
        return a + b;

    }
}
