public class Coin extends Position{
    private double value;

    //constructor
    public Coin(){
        super();
        this.value = 0.0;
    }

    public Coin(double value, double x, double y){
        super(x,y);
        this.value = value;
    }

    //getter
    public double getValue() {
        return value;
    }

    public void move(double t){
        this.yPos += 20*t;
    }
}
