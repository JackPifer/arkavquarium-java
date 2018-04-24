// File: Snail.java
// Concrete class for Pet in this Aquarium

import java.awt.*;
import java.util.*;

/** 
 * Represents a snail.
 * @version 1.0.
 */
public class Snail implements MovingObject,Drawable{
    protected Position currentPosition;
    private Position destination;
    private double moveTime;
    private boolean faceDirection;
    private final double movingSpeed = 1;
    private MovingStatus movingStatus;

    static Random r = new Random();
    
    //Constructor
    /** 
     * constructor.
     */
    public Snail() {
        this.currentPosition = new Position( r.nextDouble() * (1+(600-1)), 420.0);
        this.destination = new Position(0.0, 420.0);
        this.moveTime = 0;
        this.faceDirection = true;
        this.movingStatus = MovingStatus.STATIC;
    }

    /** 
     * constructor.
     * @param initialPosition initialPosition of snail.
     */
    public Snail(Position initialPosition) {
        this.currentPosition = initialPosition;
        this.destination = new Position(0.0, 420.0);
        this.moveTime = 0;
        this.faceDirection = true;
        this.movingStatus = MovingStatus.STATIC;
    }

    //Getter
    /** 
     * getter.
     * @return currentPosition.
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }
    /** 
     * getter.
     * @return destination.
     */
    public Position getDestination() {
        return this.destination;
    }
    /** 
     * getter.
     * @return boolean of face direction.
     */
    public boolean getFaceDirection() {
        return this.faceDirection;
    }
    
    /** 
     * getter.
     * @return moveTime.
     */
    public double getMoveTime() {
        return this.moveTime;
    }

    /** 
     * getter.
     * @return movingStatus.
     */
    public MovingStatus getMovingStatus() {
        return this.movingStatus;
    }

    // Setter
    /** 
     * setter.
     * @param currentPosition to change currentPosition.
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    /** 
     * setter.
     * @param destination to change destination.
     */
    public void setDestination(Position destination) {
        this.destination = destination;
    }

    /** 
     * setter.
     * @param moveTime to change moveTime.
     */
    public void setMoveTime(double moveTime) {
        this.moveTime = moveTime;
    }

    /** 
     * change moving status(HUNTING if coin available).
     * @param coins list of coin.
     */
    public void changeMovingStatus(LinkedList<Coin> coins) {
        if (coins.getSize()!=0) {
            this.movingStatus = MovingStatus.HUNTING;
        } else {
            this.movingStatus = MovingStatus.STATIC;
        }
    }

    /** 
     * move the snail.
     * @param food food.
     */
    public <T> void move(LinkedList<T> food) {
        if (movingStatus == MovingStatus.HUNTING ) {
            this.destination = findNearestCoin(food);
            if(this.currentPosition.getX() - this.destination.getX() > 0){
                this.faceDirection = true;
            }else {
                this.faceDirection = false;
            }
            if(Math.abs(this.currentPosition.getX() - this.destination.getX()) >= 1) {
                double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), 0);
                this.currentPosition.setX(1.3 * this.movingSpeed * Math.sin(a) + this.currentPosition.getX());
            }
        }
    }

    /** 
     * find nearest coin.
     * @param coins linkedlist of coin.
     */
    public <T> Position findNearestCoin(LinkedList<T> coins){
        Coin nearestCoin = (Coin) coins.get(0);
        double minDistance = this.currentPosition.calculateDistance(nearestCoin.getCurrentPosition());
        for(int i = 0; i < coins.getSize(); i++){
            Coin coin = (Coin) coins.get(i);
            double tempDistance = this.currentPosition.calculateDistance(coin.getCurrentPosition());
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                nearestCoin = coin;
            }
        }
        return nearestCoin.getCurrentPosition();
    }

    /** 
     * draw to aquarium.
     * @param g Draw container.
     * @param t Object to grab image.
     * @param con Game controller.
     */
    public void draw(Graphics g, Toolkit t, Controller con){
        if (movingStatus == MovingStatus.STATIC) {
            if (getFaceDirection()) {
                g.drawImage(t.getImage("images/Snail_shel.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY() + 7, con);
            } else {
                g.drawImage(t.getImage("images/Snail_shel_right.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY() + 7, con);
            }
        } else {
            if (getFaceDirection()) {
                g.drawImage(t.getImage("images/Snail_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            } else {
                g.drawImage(t.getImage("images/Snail_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            }
        }
    }
}
