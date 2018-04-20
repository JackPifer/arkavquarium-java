// File: Coin.java
// Responsibility : Act as Coin for player to get to increase money

public class Coin extends DroppableItem {
    private double value;

    // User-defined Constructor
    public Coin(double value, Position fishPosition){
        super(fishPosition);
        this.value = value;
    }

    //Getter
    public double getValue() {
        return this.value;
    }

    //Setter
    public void setValue(double value) {
        this.value = value;
    }
}
