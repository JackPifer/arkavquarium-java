/** 
 * moving object interface.
 * @version 1.0.
 */
public interface MovingObject {
    /** 
     * enum.
     */
    public enum MovingStatus {
        RANDOM, HUNTING, STATIC;
    }

    /** 
     * move.
     * @param time time.
     * @param food LinkedList of food.
     */
    public <T> void move(double time, LinkedList<T> food);
}