package _6_2_reducing_and_summarizing;

import model.Dish;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class JoiningStrings {
    public static void main(String[] args) {
        var shortMenu = Dish.menu.stream()
                .map(Dish::getName)
                .collect(Collectors.joining(", "));
        System.out.println(shortMenu);

        var totalCalories = Dish.menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        var totalCalories2 = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce((a,b) -> (a+b));
        totalCalories2.ifPresent(System.out::println);

        var totalCalories3 = Dish.menu.stream()
                .collect(Collectors.reducing(0,Dish::getCalories, (i,j) -> i+j));



    }
}
