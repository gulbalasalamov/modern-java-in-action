package _3_8_useful_methods_to_compose_lambda_expressions;

import java.util.function.Function;

public class ComposingFunctions {
    public static void main(String[] args) {
        Function<Integer,Integer> f = x -> x +1;
        Function<Integer,Integer> g = x -> x * 2;
        Function<Integer,Integer> h = f.andThen(g);
        int result = h.apply(5);
        System.out.println(result);

        Function<Integer,Integer> z = f.compose(g);
        int result2 = z.apply(5);
        System.out.println(result2);

    }
}
