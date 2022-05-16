package _5_1_working_with_streams;

import model.Dish;

import java.util.Comparator;
import java.util.stream.Collectors;

public class SkipElement {
    public static void main(String[] args) {
        var list = Dish.menu;

        list.forEach(System.out::println);

        System.out.println("Dshes that have fewer than 401 calories");
        var filteredMenu = list.stream()
                .filter(dish -> dish.getCalories() < 401)
                .sorted(Comparator.comparing(Dish::getName))
                .skip(1)
                .collect(Collectors.toList());
        filteredMenu.forEach(System.out::println);

    }


}
