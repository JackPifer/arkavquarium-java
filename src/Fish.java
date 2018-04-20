import java.util.*;
public abstract class Fish extends Position {
    protected double xDest;
    protected double yDest;
    protected double moveTime;
    protected int foodEaten;
    protected boolean direction;
    protected int hungerTime;
    final protected  int fullTimeLimit = 40;
    final protected int speed = 40;

    static Random r = new Random();
    //constructor
    public Fish(){
        super(1 + (640 - 1) * r.nextDouble(),1 + (480 - 1) * r.nextDouble());
        this.xDest = 0.0;
        this.yDest = 0.0;
        this.moveTime = 0;
        this.foodEaten = 0;
        this.direction = true;
        this.hungerTime = 60;
    }

    //getter

    public boolean getDirection() {
        return direction;
    }

    public int getHungerTime() {
        return hungerTime;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isHungry() {
        return this.hungerTime < this.fullTimeLimit;
    }

    public void move(double x, double y, double t, boolean huntFood){
        double mult;
        if(huntFood){
            this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
            this.xDest = x;
            this.yDest = y;
            if(this.xPos - this.xDest > 0){
                this.direction = true;
            }else {
                this.direction = false;
            }
        }else if(this.moveTime <= t || (Math.abs(this.xDest - this.xPos) < 3 && Math.abs(this.yDest - this.yPos) < 3)){
            this.hungerTime -= 2;
            this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
            if(this.xPos - this.xDest > 0){
                this.direction = true;
            }else {
                this.direction = false;
            }
        }else {
            this.moveTime -= t;
        }
        double a = Math.atan2(this.xDest-this.xPos,this.yDest-this.yPos);
        if(huntFood){
            mult = 1.3;
        }else {
            mult = 1;
        }
        this.xPos += mult * this.speed*Math.sin(a)*t;
        this.yPos += mult * this.speed*Math.cos(a)*t;
    }

    public abstract void eatFood();

}
