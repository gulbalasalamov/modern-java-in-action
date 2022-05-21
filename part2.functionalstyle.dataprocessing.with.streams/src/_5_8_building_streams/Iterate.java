package _5_8_building_streams;

import java.util.stream.IntStream;

public class Iterate {
    public static void main(String[] args) {
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
        System.out.println("-----------------");

        IntStream.iterate(5,n -> n+5)
                .takeWhile(n -> n<50)
                .forEach(System.out::println);

    }
}
