// File: Coin.java
// Responsibility : Act as Coin for player to get to increase money

import java.awt.*;

public class Coin extends DroppableItem implements Drawable{
    private double value;

    // User-defined Constructor
    public Coin(double value, Position fishPosition){
        super(fishPosition);
        System.out.println(fishPosition.getY());
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

    public void draw(Graphics g, Toolkit t, Controller con) {
        g.drawImage(t.getImage("images/Coin.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);

    }
}
