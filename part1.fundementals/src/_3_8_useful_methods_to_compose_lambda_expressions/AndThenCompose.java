package _3_8_useful_methods_to_compose_lambda_expressions;

import java.util.function.Function;

/**
 * Letter example
 */
public class AndThenCompose {
    public static void main(String[] args) {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                        .andThen(Letter::addFooter);
        System.out.println(
                transformationPipeline.apply("Gulbala")
        );
    }
}

class Letter {
    static String addHeader(String text) {
        return "From Raoul, Mario and Alan: \n" + text;
    }

    static String addFooter(String text) {
        return text + "\nKind regards";
    }

    static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
