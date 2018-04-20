import java.util.*;
public class Snail extends Position{
    private double xDest;
    double moveTime;
    boolean direction;

    static Random r = new Random();
    //constructor
    public Snail(){
        super(0.0, 450.0);
        this.xDest = 0.0;
        moveTime = 0;
        direction = true;
    }

    public Snail(double xPos){
        super(xPos, 450.0);
        this.xDest = 0.0;
        this.moveTime = 0;
        this.direction = true;
    }

    //getter

    public boolean getDirection() {
        return direction;
    }

    public void move(double x, double t, boolean huntCoin){
        if(huntCoin){
            this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
            this.xDest = x;
            if(Math.abs(this.xDest - this.xPos) < 10){

            }
            else if(this.xPos - this.xDest > 0){
                this.direction = true;
            }else {
                this.direction = false;
            }
        }

        if((!(Math.abs(this.xDest - this.xPos) < 5)) && huntCoin){
            double a = Math.atan2(this.xDest - this.xPos, 0.0);
            this.xPos += 20*Math.sin(a)*t;
        }
    }
}
