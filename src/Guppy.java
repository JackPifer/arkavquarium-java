public class Guppy extends Fish {
    private int size;
    private double coinTime;
    private int coinValue;
    private int foodEaten;
    final private double baseCoinTime = 15.0;

    //constructor
    public Guppy(){
        super();
        this.size = 1;
        this.coinTime = baseCoinTime;
        this.coinValue = 0;
        this.foodEaten = 0;
    }

    public double getCoinTime() {
        return coinTime;
    }

    public int getSize() {
        return size;
    }

    public void setCoinTime(double coinTime) {
        this.coinTime = coinTime;
    }

    public void eatFood(){
        this.foodEaten++;
        this.hungerTime = 60;
        if((this.foodEaten == 2) || (this.foodEaten == 5)){
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
        coinTime = baseCoinTime;
        return new Coin(this.coinValue, this.getxPos(), this.getyPos());
    }
}

