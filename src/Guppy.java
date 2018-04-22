public class Guppy extends Fish {
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
}

