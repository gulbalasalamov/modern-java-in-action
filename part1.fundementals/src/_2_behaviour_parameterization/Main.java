package _2_behaviour_parameterization;

import model.Apple;

import java.util.ArrayList;
import java.util.List;

import static model.Colour.GREEN;
import static model.Colour.RED;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<Apple>();
        arr.add(new Apple(RED, 105));
        arr.add(new Apple(GREEN, 110));
        arr.add(new Apple(GREEN, 120));
        arr.add(new Apple(RED, 90));

        System.out.println(filterApples(arr, new AppleRedAndHeavyPredicate()));
    }

    //Attempt: Filtering by abstract criteria
    static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        var result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.test(apple)) { // Predicate p encapsulates the condition to test on apple
                result.add(apple);
            }
        }
        return result;
    }
}
