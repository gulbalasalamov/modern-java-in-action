package _6_2_reducing_and_summarizing;

import model.Dish;

import java.util.stream.Collectors;

public class Summarization {
    public static void main(String[] args) {
        //summingLong Double Int works sameway
        var totalCalories = Dish.menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        System.out.println(totalCalories);

        var avarageCalories = Dish.menu.stream()
                .collect(Collectors.averagingDouble(Dish::getCalories));

        System.out.println(avarageCalories);

        var menuStatistics = Dish.menu.stream()
                .collect(Collectors.summarizingInt(Dish::getCalories));

        System.out.println(menuStatistics);

    }
}
