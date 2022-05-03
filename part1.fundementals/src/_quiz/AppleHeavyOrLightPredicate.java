package _quiz;

import model.Apple;

public class AppleHeavyOrLightPredicate implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String info = apple.getWeight() > 100 ? "heavy " : "light ";
        return "A " + info + apple.getColour() + " apple";
    }
}
