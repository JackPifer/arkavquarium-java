// File: Coin.java
// Responsibility : Act as Coin for player to get to increase money

import java.awt.*;

public class Coin extends DroppableItem implements Drawable{
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

    public void draw(Graphics g, Toolkit t, Controller con) {
        if(this.getValue()==25) {
            g.drawImage(t.getImage("images/Silver_coin.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);

        }else if(this.getValue()==50){
            g.drawImage(t.getImage("images/Gold_coin.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);

        }else{
            g.drawImage(t.getImage("images/Diamond_Coin.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);

        }
    }
}
