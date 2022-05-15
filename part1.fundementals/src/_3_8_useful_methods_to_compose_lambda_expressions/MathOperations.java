package _3_8_useful_methods_to_compose_lambda_expressions;

import java.util.function.DoubleFunction;

public class MathOperations {
    public static void main(String[] args) {
        DoubleFunction<Double> doubleFunction = a -> (a * 2.5);
        System.out.println(integrate(doubleFunction,3,4));
    }

    static double integrate(DoubleFunction<Double> df, double a, double b) {
        return (df.apply(a) + df.apply(b)) * (b - a) / 2.0;
    }
}
