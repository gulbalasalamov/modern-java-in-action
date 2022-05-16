package _4_2_getting_started_with_streams;

import model.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFIlterMapSortLimitCollect {
    public static void main(String[] args) {
        var list = Dish.menu;
        var custom = get3HighCaloricDishName(list);
        custom.forEach(System.out::println);
    }

    static List<String> get3HighCaloricDishName(List<Dish> list) {
        return list.stream()
                .filter(dish -> dish.getCalories() >=300)
                .map(Dish::getName)
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }
}
