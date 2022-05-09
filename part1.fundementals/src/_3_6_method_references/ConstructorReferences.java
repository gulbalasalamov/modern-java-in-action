package _3_6_method_references;

import model.Apple;
import model.Colour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static model.Colour.GREEN;
import static model.Colour.RED;

public class ConstructorReferences {

    public static void main(String[] args) {
        //You can create a reference to an existing constructor using its name andthe keyword new as follows:
        //ClassName::new

        //Zero-argument constructor. This fits the signature () -> Apple of Supplier
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        //Constructor with signature, then it fits signature of Function interface
        BiFunction<Colour, Integer, Apple> c3 = (c, i) -> new Apple(c, i);
        Apple a3 = c3.apply(GREEN, 12);
        System.out.println(a3);

        BiFunction<Colour, Integer, Apple> c4 = Apple::new;
        Apple a4 = c4.apply(RED, 15);
        System.out.println(a4);

    }
}