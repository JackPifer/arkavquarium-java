// File: Snail.java
// Concrete class for Pet in this Aquarium

import java.util.*;

public class Snail implements MovingObject {
    protected Position currentPosition;
    private Position destination;
    private double moveTime;
    private boolean faceDirection;
    private MovingStatus movingStatus;

    static Random r = new Random();
    
    //Constructor
    public Snail() {
        this.currentPosition = new Position( r.nextDouble() % 640 + 1, 450.0);
        this.destination = new Position(0.0, 450.0);
        this.moveTime = 0;
        this.faceDirection = true;
        this.movingStatus = MovingStatus.STATIC;
    }

    public Snail(Position initialPosition) {
        this.currentPosition = initialPosition;
        this.destination = new Position(0.0, 450.0);
        this.moveTime = 0;
        this.faceDirection = true;
        this.movingStatus = MovingStatus.STATIC;
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

    public void setMoveTime(double moveTime) {
        this.moveTime = moveTime;
    }

    public void changeMovingStatus(LinkedList<Coin> coins) {
        if (!coins.isEmpty()) {
            this.movingStatus = MovingStatus.HUNTING;
        } else {
            this.movingStatus = MovingStatus.STATIC;
        }
    }

    // public void move(double x, double t, boolean huntCoin) {
    //     if(huntCoin){
    //         this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
    //         this.xDest = x;
    //         if(Math.abs(this.xDest - this.xPos) < 10){

    //         }
    //         else if(this.xPos - this.xDest > 0){
    //             this.direction = true;
    //         }else {
    //             this.direction = false;
    //         }
    //     }

    //     if((!(Math.abs(this.xDest - this.xPos) < 5)) && huntCoin){
    //         double a = Math.atan2(this.xDest - this.xPos, 0.0);
    //         this.xPos += 20*Math.sin(a)*t;
    //     }
    // }

    public void move(Position destination, double time, MovingStatus movingStatus){

    }

    public Coin findNearestCoin(LinkedList<Coin> coins){
        Coin nearestCoin = coins.get(0);
        double minDistance = this.currentPosition.calculateDistance(nearestCoin.getCurrentPosition());
        for(int i = 1; i < coins.getSize(); i++){
            double tempDistance = this.currentPosition.calculateDistance(coins.get(i).getCurrentPosition());
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                nearestCoin = coins.get(i);
            }
        }
        return nearestCoin;
    }
}
