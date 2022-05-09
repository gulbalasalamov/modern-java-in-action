package _3_6_method_references;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/**
 * Sort list of strings ignoring case differences
 */
public class MethodReferenceExample {
    public static void main(String[] args) {
        var strList = Arrays.asList("a","b","A","B");
        //The sort method on a List expects Comparator parameter. (T,T) -> int
        //You can define a lambda expression using the predefined method compareToIgnoreCase in String class
        strList.sort((s1,s2) -> s1.compareTo(s2)); //using lambda
        strList.sort(String::compareTo); //using method reference

        ToIntFunction<String> strToInt = (String s) -> Integer.parseInt(s);
        ToIntFunction<String> strToInt2 = Integer::parseInt;

        BiPredicate<List<String>,String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>,String> contains2 = List::contains;

        //Predicate<String> startsWithNumber = (String s) -> this::startsWithNumber;
    }

}
