package _5_4_finding_and_matching;

import model.Dish;

import java.util.Optional;

public class AnyMatch {
    public static void main(String[] args) {
        boolean isHealthy = Dish.menu.stream()
                .allMatch(d -> d.getCalories() < 2000);
        System.out.println(isHealthy);
    }
}
