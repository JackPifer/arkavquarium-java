// File: Snail.java
// Concrete class for Pet in this Aquarium

import java.awt.*;
import java.util.*;

public class Snail implements MovingObject,Drawable{
    protected Position currentPosition;
    private Position destination;
    private double moveTime;
    private boolean faceDirection;
    private final double movingSpeed = 20;
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

    public <T> void move(double time, LinkedList<T> food) {
        Position destination = new Position(1 + (Aquarium.DEFAULT_WIDTH - 1) * r.nextDouble(),1 + (Aquarium.DEFAULT_HEIGHT - 1) * r.nextDouble());
        if (movingStatus == MovingStatus.HUNTING && !food.isEmpty()) {
            this.moveTime = 0.1 * (5 + (45 - 5) * r.nextDouble());
            this.destination = destination;
            if(this.currentPosition.getX() - this.destination.getX() > 0){
                this.faceDirection = true;
            }else {
                this.faceDirection = false;
            }
            double a = Math.atan2(this.destination.getX() - this.currentPosition.getX(), this.destination.getY() - this.currentPosition.getY());
            this.currentPosition.setX(1.3 * this.movingSpeed * Math.sin(a) * time + this.currentPosition.getX());
            this.currentPosition.setY(1.3 * this.movingSpeed * Math.cos(a) * time + this.currentPosition.getY());
        }
    }

    public <T> Position findNearestCoin(LinkedList<T> coins){
        Coin nearestCoin = (Coin) coins.get(0);
        double minDistance = this.currentPosition.calculateDistance(nearestCoin.getCurrentPosition());
        for(int i = 1; i < coins.getSize(); i++){
            Coin coin = (Coin) coins.get(i);
            double tempDistance = this.currentPosition.calculateDistance(coin.getCurrentPosition());
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                nearestCoin = coin;
            }
        }
        return nearestCoin.getCurrentPosition();
    }

    public void draw(Graphics g, Toolkit t, Controller con){
        if (movingStatus == MovingStatus.STATIC) {
            if (getFaceDirection()) {
                g.drawImage(t.getImage("src/images/Snail_shel_right.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            } else {
                g.drawImage(t.getImage("src/images/Snail_shel.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            }
        }else{
            if (getFaceDirection()) {
                g.drawImage(t.getImage("src/images/Snail_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            } else {
                g.drawImage(t.getImage("src/images/Snail_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            }
        }
    }
}
