package _5_7_numeric_streams;

import model.Dish;

public class NumericStreamTest {
    public static void main(String[] args) {
        //mapToInt, mapToDouble, mapToLong most common specialized version
        //These methods work exactly like map but return a specialized Stream, instread of Stream<T>
        var v = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        var v2 = Dish.menu.stream()
                .map(dish -> dish.getCalories())
                .reduce(Integer::sum);

        System.out.println(v);
        v2.ifPresent(System.out::println);
        System.out.println();
    }
}
