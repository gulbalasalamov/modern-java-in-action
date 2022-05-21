package _5_8_building_streams;

import java.util.stream.Stream;

public class Generate {
    public static void main(String[] args) {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}
