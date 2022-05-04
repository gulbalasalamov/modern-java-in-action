package _2_3_tackling_verbosity;

import model.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static model.Colour.*;

public class Main {
    public static void main(String[] args) {
        var inventory = Arrays.asList(
                new Apple(GREEN, 100),
                new Apple(RED, 120),
                new Apple(GREEN, 90),
                new Apple(RED, 80),
                new Apple(GREEN, 200));
        List<Apple> redApples = filter(inventory, (Apple apple) -> RED.equals(apple.getColour()));
        System.out.println(redApples);

        var intList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = filter(intList, (Integer i) -> i % 2 == 0);
        System.out.println(evenNumbers);
    }

    /**
     * Use method filter with a List of anything. Abstract on the List type
     *
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

//interface Predicate<T> {
//    boolean test(T t);
//}
