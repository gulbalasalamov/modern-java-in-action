package _quiz;

import model.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static model.Colour.GREEN;
import static model.Colour.RED;

/**
 * Quiz solution added. Abstract over behaviour made the code adapt to requirement changes,
 * but the process is verbose because you need to declare multiple classes that you instantiate only once.
 * Improve that
 */
public class Quiz {
    public static void main(String[] args) {
        var arr = new ArrayList<Apple>();
        arr.add(new Apple(RED, 105));
        arr.add(new Apple(GREEN, 110));
        arr.add(new Apple(GREEN, 120));
        arr.add(new Apple(RED, 90));
        prettyPrintApple(arr, new AppleHeavyOrLightPredicate());
    }

    static void prettyPrintApple(List<Apple> inventory, AppleFormatter p) {
        for (Apple apple : inventory) {
            System.out.println(p.accept(apple));
        }
    }
}
