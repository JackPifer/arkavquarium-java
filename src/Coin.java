// File: Coin.java
// Responsibility : Act as Coin for player to get to increase money

import java.awt.*;
/** 
 * Representas a coin
 * @version 1.0
 */
public class Coin extends DroppableItem implements Drawable{
    private double value;

    // User-defined Constructor
    /** 
     * constructor
     * @param value value of coin
     * @param fishPosition Position of fish
     */
    public Coin(double value, Position fishPosition){
        super(fishPosition);
        this.value = value;
    }

    //Getter
    /** 
     * value getter
     * @return value
     */
    public double getValue() {
        return this.value;
    }

    //Setter
    /** 
     * value setter
     * @param value value to be set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /** 
     * draw to aquarium
     * @param g Draw container
     * @param t Object to grab image
     * @param con Game controller
     */
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
