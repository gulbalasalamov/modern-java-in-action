package _5_8_building_streams;

import java.util.stream.Stream;

public class StreamsFromFunctions {
    public static void main(String[] args) {
        Stream.iterate(0,n-> n+2)
                .limit(5)
                .forEach(System.out::println);
    }
}
