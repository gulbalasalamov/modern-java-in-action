package _3_4_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * create a method map to transform a list of Strings into a list
 * of Integers containing the length of each String
 */
public class WorkingWithFunction {
    static <T, R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> result = new ArrayList<>();
        for (T t: list) {
            result.add(f.apply(t));
        }
        return result;
    }
    public static void main(String[] args) {
        var stringlist =  Arrays.asList("Hello","Gulbala","Salamov");
        var integerList = map(stringlist,(String s) -> s.length());
        integerList.forEach(System.out::println);
    }
}
