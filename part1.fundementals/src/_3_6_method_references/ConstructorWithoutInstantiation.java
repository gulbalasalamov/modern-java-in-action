package _3_6_method_references;


import model.Apple;
import model.Colour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Interesting application capable of referring to a constuctor without instantiating it
 */
public class ConstructorWithoutInstantiation {
    //Map to associate constructors with a String value..
    static Map<String, BiFunction<Colour, Integer, Apple>> map = new HashMap<>();

    static {
        map.put("king", Apple::new);
        map.put("golden", Apple::new);
    }

    public static void main(String[] args) {
        var myFruit = giveMeApple("KING", Colour.RED, 5);
        System.out.println(myFruit);

    }

    /**
     * Given a String and Integer, can create different types of apples with different weights and colour
     *
     * @param type
     * @param colour
     * @param weight
     * @return
     */
    public static Apple giveMeApple(String type, Colour colour, Integer weight) {
        return map.get(type.toLowerCase())
                .apply(colour, weight);
    }
}
