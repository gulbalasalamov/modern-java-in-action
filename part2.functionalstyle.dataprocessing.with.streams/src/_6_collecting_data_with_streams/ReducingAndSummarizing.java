package _6_collecting_data_with_streams;

import model.Dish;

import static java.util.stream.Collectors.counting;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReducingAndSummarizing {
    public static void main(String[] args) {
        var howManyDishes = Dish.menu.stream()
                .collect(counting());
        System.out.println("Number of dishes: " + howManyDishes);

        //Far more directly
        var v = Dish.menu.stream().count();
        //System.out.println(v + "\n");

       findMaxAndMinCaloriesDish();
    }

    /**
     * Collectors.maxBy and Collectors.minBy calculate the max and min value in stream
     * These two collectors take a Comparator as argument to compare elements in stream
     */
    static void findMaxAndMinCaloriesDish() {
        var dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> mostCalorieDish =
                Dish.menu.stream().max(dishCaloriesComparator);

        var minCalorieDish = Dish.menu.stream()
                .min(Comparator.comparingInt(Dish::getCalories));

        System.out.println("Most calorie dish: ");
        mostCalorieDish.ifPresent(System.out::print);

        System.out.println("\nMin calorie dish: ");
        minCalorieDish.ifPresent(System.out::print);
    }
}
