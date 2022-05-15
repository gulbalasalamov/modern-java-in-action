package _4_1_streams;

import model.Dish;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        var menu = Arrays.asList(
                new Dish("meatball soup", 100),
                new Dish("rice", 99),
                new Dish("kebap", 300),
                new Dish("tomato soup", 42),
                new Dish("vegie food", 128));


        var nameLowCaloriesDish = menu.stream()
                .filter(dish -> dish.getCalories() < 125)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        nameLowCaloriesDish.forEach(System.out::println);
//        var lowCaloricDishes = new ArrayList<Dish>();
//                for (Dish dish : menu) {
//            if (dish.getCalories() <= 100) {
//                lowCaloricDishes.add(dish);
//            }
//        }
//        lowCaloricDishes.sort(Comparator.comparing(Dish::getCalories).reversed());
//        lowCaloricDishes.forEach(System.out::println);
//    }
    }
}