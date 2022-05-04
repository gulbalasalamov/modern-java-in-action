package _2_2_behaviour_parameterization.quiz1_2;

import model.Apple;

public class AppleHeavyOrLightPredicate implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String info = apple.getWeight() > 100 ? "heavy " : "light ";
        return "A " + info + apple.getColour() + " apple";
    }
}
