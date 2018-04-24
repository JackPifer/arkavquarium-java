// File : DroppableItem.java
// Parent class for FishFood and Coin
/** 
 * Represent object that will only move downwards.
 * @version 1.0.
 */
public class DroppableItem {
    protected Position currentPosition;
    /** 
     * Constructor.
     * @param initialPosition the initial position of the item.
     */
    public DroppableItem(Position initialPosition) {
        this.currentPosition = initialPosition;
    }

    // Getter for Position
    /** 
     * currentPosition getter.
     * @return object of Position.
     */
    public Position getCurrentPosition() {
        return this.currentPosition;
    }

    // Setter for Position
    /** 
     * currentPositionSetter.
     * @param currentPosition object of Position to be set.
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    // Method for vertical move
    /** 
     * move object downwards.
     * @param t move distance.
     */
    public void moveDown(double t) {
        if (this.getCurrentPosition().getY() <= 410) {
            this.currentPosition.setY(this.getCurrentPosition().getY() + t);
        }
    }


}