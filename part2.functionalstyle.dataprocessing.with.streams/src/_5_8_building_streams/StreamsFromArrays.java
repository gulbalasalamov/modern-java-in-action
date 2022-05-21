package _5_8_building_streams;

import java.util.Arrays;

public class StreamsFromArrays {
    public static void main(String[] args) {
        var numbers = new int[]{2,3,5,7,11,13};
        int sum = Arrays.stream(numbers)
                .reduce(0,(a,b) -> a+b);
        System.out.println(sum);

        int sum2 = Arrays.stream(numbers)
                .sum();
        System.out.println(sum2);
    }
}
