package _4_2_getting_started_with_streams;

import java.util.Arrays;

public class Dummy {
    public static void main(String[] args) {
        var intArr = new int[]{5,2,10,-4,5,-6};
        var value = Arrays.stream(intArr)
                .filter(x-> x>=0)
                .reduce(0,Integer::sum);

    }
}
