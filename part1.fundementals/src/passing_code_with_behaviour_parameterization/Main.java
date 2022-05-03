package passing_code_with_behaviour_parameterization;

import java.util.ArrayList;

import java.util.List;

import static passing_code_with_behaviour_parameterization.Colour.GREEN;
import static passing_code_with_behaviour_parameterization.Colour.RED;

public class Main {
    public static void main(String[] args) {
        var arr = new ArrayList<Apple>();
        arr.add(new Apple(RED, 100));
        arr.add(new Apple(GREEN, 110));
        arr.add(new Apple(GREEN, 120));
        arr.add(new Apple(RED, 90));

        System.out.println(filterGreenApples(arr));
        var greenApples = filterApplesByColour(arr, GREEN);
        System.out.println(greenApples);
        var redApples = filterApplesByColour(arr, RED);
        System.out.println(redApples);
    }

    //First Attempt: filtering the green apples
    static List<Apple> filterGreenApples(List<Apple> inventory) {
        var result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColour())) {
                result.add(apple);
            }
        }
        return result;
    }

    //Second Attempt: parameterizing the colour
    static List<Apple> filterApplesByColour(List<Apple> inventory, Colour colour) {
        var result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (apple.getColour().equals(colour)) {
                result.add(apple);
            }
        }
        return result;
    }
}
