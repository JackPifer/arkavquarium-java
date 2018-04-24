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
  protected final int hungryLevelLimit = 40;
  protected final int movingSpeed = 1;

  protected final int defaultHungerLevel = 60;
  protected final double defaultXPos = 0.0;
  protected final double defaultYPos = 0.0;

  static Random r = new Random();

  //Constructor
  /** 
   * Constructor.
   */

  public Fish() {
    // Get Random initial position
    double initialX = 1 + (640 - 1) * r.nextDouble();
    double initialY = 1 + (480 - 1) * r.nextDouble();
    this.currentPosition = new Position(initialX, initialY);
    this.destination = new Position(defaultXPos, defaultYPos);
    this.moveTime = 0;
    this.movingStatus = MovingStatus.RANDOM;
    this.faceDirection = true;
    this.isAlive = true;
    this.hungerLevel = defaultHungerLevel;
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
    if (this.getHungerLevel() < 0) {
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
   * @param food LinkedList object of available.
   */

  public <T> void move(LinkedList<T> food) {
    double xInit = 1 + (600 - 1) * r.nextDouble();
    double yInit = 1 + (410 - 1) * r.nextDouble()
    Position destination = new Position(xInit,yInit);
    if (movingStatus == MovingStatus.HUNTING) {
      moveHunt(findNearestFood(food));
    } else {
      moveRandom(destination);
    }
  }

  /** 
  * move fish towards nearest food.
  * @param destination nearest food position.
  */

  public void moveHunt(Position destination) {
    this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
    this.destination = destination;
    if (this.getCurrentPosition().getX() - this.getDestination().getX() > 0) {
      this.faceDirection = true;
    } else {
      this.faceDirection = false;
    }
    double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(),
        this.destination.getY() - this.currentPosition.getY());
    this.currentPosition.setX(1.3 * this.movingSpeed * Math.sin(a) + this.currentPosition.getX());
    this.currentPosition.setY(1.3 * this.movingSpeed * Math.cos(a) + this.currentPosition.getY());
  }

  /** 
   * move to random position.
   * @param destination random position.
   */
  public void moveRandom(Position destination) {
    if (this.moveTime <= 1 || (Math.abs(this.destination.getX() - this.currentPosition.getX()) < 3
        && Math.abs(this.destination.getY() - this.currentPosition.getY()) < 3)) {
      this.hungerLevel -= 3;
      this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
      this.destination = destination;
      if (this.getCurrentPosition().getX() - this.getDestination().getX() > 0) {
        this.faceDirection = true;
      } else {
        this.faceDirection = false;
      }
    } else {
      this.moveTime -= 0.02;
    }
    double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(),
        this.destination.getY() - this.currentPosition.getY());
    this.currentPosition.setX(this.movingSpeed * Math.sin(a) + this.currentPosition.getX());
    this.currentPosition.setY(this.movingSpeed * Math.cos(a) + this.currentPosition.getY());
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
    if (foods.getSize() != 0 && this.isHungry()) {
      this.movingStatus = MovingStatus.HUNTING;
    } else {
      this.movingStatus = MovingStatus.RANDOM;
    }
  }
}
