package _5_7_numeric_streams;

import java.util.stream.IntStream;

public class NumericRanges {
    public static void main(String[] args) {
        var v = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(v.count());
    }
}
