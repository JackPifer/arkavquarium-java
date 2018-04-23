import java.awt.*;

public class Guppy extends Fish implements Drawable{
    private int size;
    private double coinTime;
    private int coinValue;
    private int numberOfFoodEaten;
    public static final int price = 50;
    private final double baseCoinTime = 15.0;

    //Constructor
    public Guppy(){
        super();
        this.size = 1;
        this.coinTime = baseCoinTime;
        this.coinValue = 0;
        this.numberOfFoodEaten = 0;
    }

    // Getter

    public double getCoinTime() {
        return this.coinTime;
    }

    public int getSize() {
        return this.size;
    }
    
    public int getCoinValue() {
        return this.coinValue;
    }

    public int getNumberOfFoodEaten() {
        return this.numberOfFoodEaten;
    }

    public void setNumberOfFoodEaten(int numberOfFoodEaten) {
        this.numberOfFoodEaten = numberOfFoodEaten;
    }

    public void setCoinValue(int coinValue) {
        this.coinValue = coinValue;
    }

    public void setCoinTime(double coinTime) {
        this.coinTime = coinTime;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void eatFood(){
        this.numberOfFoodEaten++;
        this.hungerLevel = 60;
        if((this.numberOfFoodEaten == 2) || (this.numberOfFoodEaten == 5)) {
            grow();
        }
    }

    public void grow(){
        this.size++;
        if(this.coinValue == 0){
            this.coinValue = 25;
        }else if(this.coinValue == 25){
            this.coinValue = 50;
        }
    }

    public Coin extractCoin(){
        this.coinTime = baseCoinTime;
        return new Coin(this.coinValue,this.getCurrentPosition());
    }
    public void draw(Graphics g, Toolkit t, Controller con){
        if (getSize() == 1) {
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Small_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Small_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Small_Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Small_Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }else if (getSize() == 2){
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Medium_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Medium_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Medium_Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Medium_Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }else{
            if (!isHungry()) {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Guppsy.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            } else {
                if (getFaceDirection()) {
                    g.drawImage(t.getImage("src/images/Hungry_Guppsy_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                } else {
                    g.drawImage(t.getImage("src/images/Hungry_Guppsy_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
                }
            }
        }
    }
}

