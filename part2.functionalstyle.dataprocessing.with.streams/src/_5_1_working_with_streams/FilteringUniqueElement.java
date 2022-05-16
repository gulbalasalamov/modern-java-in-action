package _5_1_working_with_streams;

import java.util.Arrays;

public class FilteringUniqueElement {
    public static void main(String[] args) {
        var list = Arrays.asList(1,2,1,3,3,2,4);
        list.stream()
                .filter(i-> i%2==0)
                .distinct()
                .forEach(System.out::println);
    }
}
