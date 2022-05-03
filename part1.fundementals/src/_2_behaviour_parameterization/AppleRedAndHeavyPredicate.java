package _2_behaviour_parameterization;

import model.Apple;
import model.Colour;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return Colour.RED.equals(apple.getColour()) &&
                apple.getWeight() > 100;
    }
}
