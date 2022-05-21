package _5_8_building_streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamsFromTexts {

    public static final String TEXT = "Hello my names is Gulbala." +
            "\nI am a software developer." + "\n I am from Azerbaijan";

    public static void main(String[] args) {
        System.out.println(
                getNumberOfUniqueWords(TEXT)
        );
    }

    static long getNumberOfUniqueWords(String text) {

        var v = text.lines() // lines() returns a stream of lines extracted from a given multi-line string
                .map(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .count();
        return v;
    }
}
