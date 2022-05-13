package _3_8_useful_methods_to_compose_lambda_expressions;

import model.Apple;
import model.Colour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;
import static model.Colour.*;
import static model.Colour.YELLOW;

public class ChainingComparatorsFurther {
    public static void main(String[] args) {
        var list = new ArrayList<Apple>();
        addApples(list, RED, 1);
        addApples(list, GREEN, 13);
        addApples(list, YELLOW, 10);
        addApples(list, YELLOW, 8);
        addApples(list, RED, 3);

        list.sort(
                comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getColour)
        );
        list.forEach(System.out::println);
//        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.get)

    }

    static List<Apple> addApples(List<Apple> list, Colour colour, Integer integer) {
        BiFunction<Colour, Integer, Apple> bifun = Apple::new;
        var apple = bifun.apply(colour, integer);
        list.add(apple);
        return list;
    }
}
