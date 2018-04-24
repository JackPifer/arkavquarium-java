/** 
 * represents a position.
 * @version 1.0.
 */
public class Position {
    protected double x;
    protected double y;

    //Constructor
    /** 
     * constructor.
     */
    public Position(){
        this.x = 0.0;
        this.y = 0.0;
    }

    /** 
     * parameter overload cosntructor.
     * @param x double x position.
     * @param y dobule y position.
     */
    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    //Getter for each attribute
    /** 
     * getter.
     * @return double position of x.
     */
    public double getX() {
        return this.x;
    }

    /** 
     * getter.
     * @return double position of y.
     */
    public double getY() {
        return this.y;
    }

    //Setter for each attribute
    /** 
     * setter.
     * @param x value of x.
     */
    public void setX(double x) {
        this.x = x;
    }

    /** 
     * setter.
     * @param y value of y.
     */
    public void setY(double y) {
        this.y = y;
    }

    /** 
     * calculate distance of this and another position.
     * @param P1 another Position.
     * @return return distance between this position and P1.
     */
    public double calculateDistance(Position P1) {
        return Math.sqrt(Math.pow(P1.getX() - this.x, 2) + Math.pow(P1.getY() - this.y, 2));
    }
}
