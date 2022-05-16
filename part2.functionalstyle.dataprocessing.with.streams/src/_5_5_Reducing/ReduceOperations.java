package _5_5_Reducing;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReduceOperations {
    public static void main(String[] args) {
        int n = 5;
        var intArr = Arrays.asList(2, 3, 6, 1, 9);
        int sum = intArr.stream()
                //.reduce(0,(a,b)-> (a+b));
                .reduce(0, Integer::sum);
        System.out.println(sum);

        int factorial = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> (a * b));
        System.out.println(factorial);

        var min = IntStream.rangeClosed(1,10)
                .reduce((a,b)-> a<b?a:b);
        min.ifPresent(System.out::println);

        var max = intArr.stream()
                .reduce(Integer::max);
        max.ifPresent(System.out::println);

    }
}
