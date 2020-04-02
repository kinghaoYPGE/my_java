package demo2;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * flatMap
 * FlatMap 用于将多个流合并为一个流，使用 FlatMap 时，
 * 表达式的返回值必须是 Stream 类型。而 Map 用于将一种流转化为另外一个流。
 */
public class StreamTest3 {
    public static void main(String[] args) {
        Stream<String> stringStream1 = Stream.of("shi yan", "shi yan lou","lou yan shi");
        Stream<String> stringStream2 = Stream.of("shi yan", "shi yan lou","lou yan shi");
        Stream<String[]> mapStream = stringStream1
                .map(v -> v.split(" "));
        System.out.println("mapStream打印：");
        mapStream.peek(System.out::println).count();

        Stream<String> flatMapStream = stringStream2
                .flatMap(v -> Arrays.stream(v.split(" ")));
        System.out.println("flatMapStream打印：");
        flatMapStream.peek(System.out::println).count();
    }
}
