import java.awt.*;

/** 
 * represent guppy.
 * @version 1.0.
 */
public class Guppy extends Fish implements Drawable{
    private int size;
    private double coinTime;
    private int coinValue;
    private int numberOfFoodEaten;
    /** 
     * guppy price.
     */
    public static final int price = 50;
    private final double baseCoinTime = 15.0;

    //Constructor
    /** 
     * constructor.
     */
    public Guppy(){
        super();
        this.size = 1;
        this.coinTime = baseCoinTime;
        this.coinValue = 0;
        this.numberOfFoodEaten = 0;
    }

    // Getter
    /** 
     * getter.
     * @return double coinTime.
     */
    public double getCoinTime() {
        return this.coinTime;
    }

    /** 
     * getter.
     * @return integer guppySize.
     */
    public int getSize() {
        return this.size;
    }
    
    /** 
     * getter.
     * @return integer coin value.
     */
    public int getCoinValue() {
        return this.coinValue;
    }

    /** 
     * getter.
     * @return integer numberOfFoodEaten.
     */
    public int getNumberOfFoodEaten() {
        return this.numberOfFoodEaten;
    }

    /** 
     * setter.
     * @param numberOfFoodEaten change numberOfFoodEaten.
     */
    public void setNumberOfFoodEaten(int numberOfFoodEaten) {
        this.numberOfFoodEaten = numberOfFoodEaten;
    }

    /** 
     * setter.
     * @param coinValue integer.
     */
    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }

    /** 
     * setter.
     * @param coinTime double.
     */
    public void setCoinTime(double coinTime) {
        this.coinTime = coinTime;
    }

    /** 
     * setter.
     * @param size integer.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /** 
     * eat food.
     */
    public void eatFood(){
        this.numberOfFoodEaten++;
        this.hungerLevel = 60;
        if((this.numberOfFoodEaten == 2) || (this.numberOfFoodEaten == 5)) {
            grow();
        }
    }

    /** 
     * increase guppy size.
     */
    public void grow(){
        this.size++;
        if(this.coinValue == 0){
            this.coinValue = 25;
        }else if(this.coinValue == 25){
            this.coinValue = 50;
        }
    }

    /** 
     * extract coin.
     * @return Coin object.
     */
    public Coin extractCoin() {
        this.coinTime = baseCoinTime;
        return new Coin(this.coinValue, new Position(this.getCurrentPosition().getX(), this.getCurrentPosition().getY()));

    }
    /** 
     * draw.
     * @param g Draw Container.
     * @param t Object to grab image.
     * @param con Game controller.
     */
    public void draw(Graphics g, Toolkit t, Controller con){
        if (getSize() == 1) {
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Small_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Small_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Small_Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Small_Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }else if (getSize() == 2){
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Medium_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Medium_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Medium_Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Medium_Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }else{
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Guppsy.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("images/Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("images/Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }
    }
}

