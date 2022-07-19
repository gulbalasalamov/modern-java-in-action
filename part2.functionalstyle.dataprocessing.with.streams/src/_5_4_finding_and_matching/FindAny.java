package _5_4_finding_and_matching;

import model.Dish;

import java.util.Arrays;
import java.util.Optional;

public class FindAny {
    public static void main(String[] args) {
        boolean dish = Dish.menu.stream()
                .anyMatch(d -> d.getType().equals(Dish.Type.FISH));

        Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(m -> System.out.println(m.getName()));

        var someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSqrDivisibleByThree =
                someNumbers.stream()
                        .filter(x -> Math.pow(x, 2) % 3 == 0)
                        .findFirst();
        firstSqrDivisibleByThree.ifPresent(System.out::println);
        System.out.println(firstSqrDivisibleByThree.get());//

    }
}
