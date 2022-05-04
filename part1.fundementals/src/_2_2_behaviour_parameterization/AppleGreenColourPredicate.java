package _2_2_behaviour_parameterization;

import model.Apple;

import static model.Colour.GREEN;

public class AppleGreenColourPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColour());
    }
}
