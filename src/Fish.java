import java.util.*;

public abstract class Fish implements MovingObject {
    protected Position currentPosition;
    protected Position destination;
    protected MovingStatus movingStatus;
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
        this.movingStatus = MovingStatus.RANDOM;
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

    public MovingStatus getMovingStatus() {
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

    public void setMovingStatus(MovingStatus movingStatus) {
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

    public <T> void move(Position destination,double time, MovingStatus movingStatus, LinkedList<T> food) {
        if (movingStatus == MovingStatus.HUNTING) {
            moveHunt(findNearestFood(food), time);
        }
        else {
            moveRandom(destination, time);
        }
    }

    public void moveHunt(Position destination, double t) {
        this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
        this.destination = destination;
        if(this.currentPosition.getX() - this.destination.getX() > 0){
         this.faceDirection = true;
        }else {
         this.faceDirection = false;
        }
        double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), this.destination.getY() - this.currentPosition.getY());
        this.currentPosition.setX(1.3 * this.movingSpeed * Math.sin(a) * t + this.currentPosition.getX());
        this.currentPosition.setY(1.3 * this.movingSpeed * Math.cos(a) * t + this.currentPosition.getY());
    }

    public void moveRandom(Position destination, double t) {
        if(this.moveTime <= t || (Math.abs(this.destination.getX() - this.currentPosition.getX()) < 3 && Math.abs(this.destination.getY() - this.currentPosition.getY()) < 3)) {
            this.hungerLevel -= 2;
            this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
            this.destination = destination;
            if (this.currentPosition.calculateDistance(this.destination) > 0) {
                this.faceDirection = true;
            } else {
                this.faceDirection = false;
            }
        } else {
            this.moveTime -= t;
        }
        double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), this.destination.getY() - this.currentPosition.getY());
        this.currentPosition.setX(this.movingSpeed * Math.sin(a) * t + this.currentPosition.getX());
        this.currentPosition.setY(this.movingSpeed * Math.cos(a) * t + this.currentPosition.getY());
    }

    public <T> Position findNearestFood(LinkedList<T> foods) {
        if (foods.get(0) instanceof FishFood) {
            FishFood nearestFood = (FishFood) foods.get(0);
            double minDistance = this.currentPosition.calculateDistance(nearestFood.getCurrentPosition());
            for (int i = 1; i < foods.getSize(); i++) {
                FishFood food = (FishFood) foods.get(i);
                double tempDistance = this.currentPosition.calculateDistance(food.getCurrentPosition());
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    nearestFood = (FishFood) foods.get(i);
                }
            }
            return nearestFood.getCurrentPosition();
        } else {
            Guppy nearestFood = (Guppy) foods.get(0);
            double minDistance = this.currentPosition.calculateDistance(nearestFood.getCurrentPosition());
            for (int i = 1; i < foods.getSize(); i++) {
                Guppy food = (Guppy) foods.get(i);
                double tempDistance = this.currentPosition.calculateDistance(food.getCurrentPosition());
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                    nearestFood = (Guppy) foods.get(i);
                }
            }
            return nearestFood.getCurrentPosition();
        }
    }

    public abstract void eatFood();
    public void changeMovingStatus(LinkedList<Objects> foods) {
        if (!foods.isEmpty() && this.isHungry()) {
            this.movingStatus = MovingStatus.HUNTING;
        } else {
            this.movingStatus = MovingStatus.RANDOM;
        }
    }
}
