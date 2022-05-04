package _3_4_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WorkingWithConsumer {
    public static void main(String[] args) {
        myMethod(Arrays.asList(1, 2, 3, 4, 5), System.out::println);
    }

    static <T> void myMethod(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
