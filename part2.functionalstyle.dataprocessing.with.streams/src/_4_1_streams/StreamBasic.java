package _4_1_streams;

import model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String[] args) {

        var menu = Dish.menu;

        var order = getLowCaloriesDishesNameInJava8(menu);
        order.forEach(System.out::println);

    }

    public static List<String> getLowCaloriesDishesNameInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() < 500)
                //.sorted(Comparator.comparing(Dish::isVegetarian))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getLowCaloriesDishesNameInJava7(List<Dish> dishes) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }
}