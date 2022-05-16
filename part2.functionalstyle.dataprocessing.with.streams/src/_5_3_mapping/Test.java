package _5_3_mapping;

import model.Dish;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        var list = Arrays.asList("tomatoes", "peach", "apple", "oranges", "banana", "egg");
        list.stream()
                .map(String::length)
                .forEach(System.out::println);
        //.collect(Collectors.toList());

        var lengthOfDishnames = Dish.menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        var arrayOfWords = new String[]{"Hello", "World"};
        var result = Arrays.stream(arrayOfWords)
                .map(x->x.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
