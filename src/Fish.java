import java.util.*;
/** 
 * Represent a fish.
 * @version 1.0.
 */
public abstract class Fish implements MovingObject {
    protected boolean isAlive;
    protected Position currentPosition;
    protected Position destination;
    protected MovingStatus movingStatus;
    protected double moveTime;
    protected boolean faceDirection;
    protected int hungerLevel; 
    protected final  int hungryLevelLimit = 40;
    protected final int movingSpeed = 1;

    protected final int DEFAULT_HUNGER_LEVEL = 60;
    protected final double DEFAULT_X_POS = 0.0;
    protected final double DEFAULT_Y_POS = 0.0;
    
    static Random r = new Random();
    
    //Constructor
    /** 
     * Constructor.
     */
    public Fish(){
        // Get Random initial position
        double initial_x = 1 + (Aquarium.DEFAULT_WIDTH - 1) * r.nextDouble();
        double initial_y = 1 + (Aquarium.DEFAULT_HEIGHT - 1) * r.nextDouble();
        this.currentPosition = new Position(initial_x, initial_y);
        this.destination = new Position(DEFAULT_X_POS, DEFAULT_Y_POS);
        this.moveTime = 0;
        this.movingStatus = MovingStatus.RANDOM;
        this.faceDirection = true;
        this.isAlive = true;
        this.hungerLevel = DEFAULT_HUNGER_LEVEL;
    }

    //Getter
    /** 
     * currentPosition getter.
     * @return object of Position.
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }
    /** 
     * destination getter.
     * @return object of Position.
     */
    public Position getDestination() {
        return this.destination;
    }
    /** 
     * fish face direction getter, if true then left.
     * @return boolean.
     */
    public boolean getFaceDirection() {
        return this.faceDirection;
    }

    /** 
     * moveTime getter.
     * @return double.
     */
    public double getMoveTime() {
        return this.moveTime;
    }

    /** 
     * hungerLevel getter.
     * @return integer.
     */
    public int getHungerLevel() {
        return this.hungerLevel;
    }

    /** 
     * movingSpeed getter.
     * @return integer.
     */
    public int getMovingSpeed() {
        return this.movingSpeed;
    }

    /** 
     * isAlive getter.
     * @return boolean, if true then still alive.
     */
    public boolean getIsAlive() {
        return this.isAlive;
    }

    /** 
     * hungryLevelLimit getter.
     * @return integer.
     */
    public int getHungryLevelLimit() {
        return this.hungryLevelLimit;
    }
    /** 
     * movingStatus getter.
     * @return MovingStatus enum.
     */
    public MovingStatus getMovingStatus() {
        return this.movingStatus;
    }
    
    // Setter
    /** 
     * currentPosition setter.
     * @param currentPosition Object of Position.
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }
    /** 
     * destination setter.
     * @param destination Object of Position.
     */
    public void setDestination(Position destination) {
        this.destination = destination;
    }
    /** 
     * hungerLevel setter
     * @param hungerLevel integer
     */
    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    /** 
     * moveTime setter.
     * @param moveTime integer.
     */
    public void setMoveTime(int moveTime) {
        this.moveTime = moveTime;
    }

    /** 
     * movingStatus setter.
     * @param movingStatus MovingStatus enum.
     */
    public void setMovingStatus(MovingStatus movingStatus) {
        this.movingStatus = movingStatus;
    }
    /** 
     * Change isAlive if fish hunger level below 0.
     */
    public void changeIsAlive() {
        if(this.getHungerLevel()<0) {
            this.isAlive = false;
        } else {
            this.isAlive = true;
        }
    }

    /** 
     * faceDirection setter.
     * Reverse the faceDirection.
     */
    public void changeFaceDirection() {
        this.faceDirection = !this.faceDirection;
    }
    
    /** 
     * Fish hungry checker.
     * @return true if fish hungry.
     */
    public boolean isHungry() {
        return this.hungerLevel < this.hungryLevelLimit;
    }

    /** 
     * currentPosition setter.
     * @param time time.
     * @param food LinkedList object of available.
     */
    public <T> void move(double time, LinkedList<T> food) {
        Position destination = new Position(1 + (600 - 1) * r.nextDouble(),1 + (410 - 1) * r.nextDouble());
        if (movingStatus == MovingStatus.HUNTING ) {
            moveHunt(findNearestFood(food), time);
        }
        else {
            moveRandom(destination, time);
        }
    }
    /** 
     * move fish towards nearest food.
     * @param destination nearest food position.
     * @param t time.
     */
    public void moveHunt(Position destination, double t) {
        this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
        this.destination = destination;
        if(this.getCurrentPosition().getX() - this.getDestination().getX() > 0){
         this.faceDirection = true;
        }else {
         this.faceDirection = false;
        }
        double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), this.destination.getY() - this.currentPosition.getY());
        this.currentPosition.setX(1.3 * this.movingSpeed * Math.sin(a) * t + this.currentPosition.getX());
        this.currentPosition.setY(1.3 * this.movingSpeed * Math.cos(a) * t + this.currentPosition.getY());
    }

    /** 
     * move to random position.
     * @param destination random position.
     * @param t time.
     */
    public void moveRandom(Position destination, double t) {
        if(this.moveTime <= t || (Math.abs(this.destination.getX() - this.currentPosition.getX()) < 3 && Math.abs(this.destination.getY() - this.currentPosition.getY()) < 3)) {
            this.hungerLevel -= 3;
            this.moveTime = 0.1*(5 + (45 - 5) * r.nextDouble());
            this.destination = destination;
            if (this.getCurrentPosition().getX() - this.getDestination().getX() > 0) {
                this.faceDirection = true;
            } else {
                this.faceDirection = false;
            }
        } else {
            this.moveTime -= 0.02*t;
        }
        double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), this.destination.getY() - this.currentPosition.getY());
        this.currentPosition.setX(this.movingSpeed * Math.sin(a) * t + this.currentPosition.getX());
        this.currentPosition.setY(this.movingSpeed * Math.cos(a) * t + this.currentPosition.getY());
    }

    /** 
     * find nearest food.
     * @param foods LinkedList of Food.
     * @return Position of nearest food.
     */
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

    /** 
     * eat food.
     */
    public abstract void eatFood();

    /** 
     * change moving status to hunting or random, depend on foods availability and hunger status.
     * @param foods LinkedList of food.
     */
    public <T> void changeMovingStatus(LinkedList<T> foods) {
        if (foods.getSize()!=0 && this.isHungry()) {
            this.movingStatus = MovingStatus.HUNTING;
        } else {
            this.movingStatus = MovingStatus.RANDOM;
        }
    }
}
