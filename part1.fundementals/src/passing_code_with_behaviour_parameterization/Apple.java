package passing_code_with_behaviour_parameterization;

public class Apple {
    Colour colour;
    int weight;

    public Apple(Colour colour, int weight) {
        this.colour = colour;
        this.weight = weight;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "colour='" + colour +
                ", weight=" + weight;
    }
}
