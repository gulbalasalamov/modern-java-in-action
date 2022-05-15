package _4_1_streams;

import model.Dish;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingBy {
    public static void main(String[] args) {
        var list = Dish.menu;
        Map<Dish.Type, List<Dish>> dishesByType =
                list.stream().collect(Collectors.groupingBy(Dish::getType));
        for (Map.Entry<Dish.Type, List<Dish>> entry : dishesByType.entrySet()) {
            System.out.print(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
