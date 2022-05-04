package _3_4_functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class WorkingWithPredicate {
    public static void main(String[] args) {
        var strList = Arrays.asList("Hello","World","Gulbala","");
        Predicate<String> nonEmptryStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(strList,nonEmptryStringPredicate);
        nonEmpty.forEach(System.out::println);
    }

    public static  <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static <T> List<T> myFancyMethod(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)){
                result.add(t);
            }
        }
        return result;
    }
}
//
//interface Predicate<T> {
//    boolean test (T t);
//}