package _2_behaviour_parameterization;

import model.Apple;
//ApplePredicate encapsulates a strategy for selecting an apple
public interface ApplePredicate {
    boolean test(Apple apple);
}
