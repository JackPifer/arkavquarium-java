import java.util.*;

public abstract class Fish {
    public enum FishMovingStatus {
        RANDOM, HUNTING;
    }
    protected Position currentPosition;
    protected Position destination;
    protected FishMovingStatus movingStatus;
    protected double moveTime;
    protected boolean faceDirection;
    protected int hungerLevel; 
    protected final  int hungryLevelLimit = 40;
    protected final int movingSpeed = 40;

    protected final int DEFAULT_HUNGER_LEVEL = 60;
    protected final double DEFAULT_X_POS = 0.0;
    protected final double DEFAULT_Y_POS = 0.0;
    
    static Random r = new Random();
    
    //Constructor
    public Fish(){
        // Get Random initial position
        double initial_x = 1 + (Aquarium.DEFAULT_WIDTH - 1) * r.nextDouble();
        double initial_y = 1 + (Aquarium.DEFAULT_HEIGHT - 1) * r.nextDouble();
        this.currentPosition = new Position(initial_x, initial_y);
        this.destination = new Position(DEFAULT_X_POS, DEFAULT_Y_POS);
        this.moveTime = 0;
        this.movingStatus = FishMovingStatus.RANDOM;
        this.faceDirection = true;
        this.hungerLevel = DEFAULT_HUNGER_LEVEL;
    }

    //Getter
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    public Position getDestination() {
        return this.destination;
    }

    public boolean getFaceDirection() {
        return this.faceDirection;
    }

    public double getMoveTime() {
        return this.moveTime;
    }

    public int getHungerLevel() {
        return this.hungerLevel;
    }

    public int getMovingSpeed() {
        return this.movingSpeed;
    }

    public int getHungryLevelLimit() {
        return this.hungryLevelLimit;
    }

    public FishMovingStatus getMovingStatus() {
        return this.movingStatus;
    }
    
    // Setter
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    
    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    public void setMovingStatus(FishMovingStatus movingStatus) {
        this.movingStatus = movingStatus;
    }

    public void changeFaceDirection() {
        if(this.faceDirection) {
            this.faceDirection = false;
        } else {
            this.faceDirection = true;
        }
    }
    
    public boolean isHungry() {
        return this.hungerLevel < this.hungryLevelLimit;
    }

    // public void move(double x, double y, double t, boolean huntFood){
    //     double mult;
    //     if(huntFood){
    //         this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
    //         this.xDest = x;
    //         this.yDest = y;
    //         if(this.xPos - this.xDest > 0){
    //             this.direction = true;
    //         }else {
    //             this.direction = false;
    //         }
    //     }else if(this.moveTime <= t || (Math.abs(this.xDest - this.xPos) < 3 && Math.abs(this.yDest - this.yPos) < 3)){
    //         this.hungerTime -= 2;
    //         this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
    //         if(this.xPos - this.xDest > 0){
    //             this.direction = true;
    //         }else {
    //             this.direction = false;
    //         }
    //     }else {
    //         this.moveTime -= t;
    //     }
    //     double a = Math.atan2(this.xDest-this.xPos,this.yDest-this.yPos);
    //     if(huntFood){
    //         mult = 1.3;
    //     }else {
    //         mult = 1;
    //     }
    //     this.xPos += mult * this.speed*Math.sin(a)*t;
    //     this.yPos += mult * this.speed*Math.cos(a)*t;
    // }

    public abstract void eatFood();
    // public abstract void findNearestFood();
}
