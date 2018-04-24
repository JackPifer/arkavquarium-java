/** 
 * represents a position.
 * @version 1.0.
 */
public class Position {
  protected double absis;
  protected double ordinat;

  //Constructor
  /** 
   * constructor.
   */
  public Position() {
    this.absis = 0.0;
    this.ordinat = 0.0;
  }

  /** 
   * parameter overload cosntructor.
   * @param x double x position.
   * @param y dobule y position.
   */
  public Position(double x, double y) {
    this.absis = x;
    this.ordinat = y;
  }

  //Getter for each attribute
  /** 
   * getter.
   * @return double position of x.
   */
  public double getX() {
    return this.absis;
  }

  /** 
   * getter.
   * @return double position of y.
   */
  public double getY() {
    return this.ordinat;
  }

  //Setter for each attribute
  /** 
   * setter.
   * @param x value of x.
   */
  public void setX(double x) {
    this.absis = x;
  }

  /** 
   * setter.
   * @param y value of y.
   */
  public void setY(double y) {
    this.ordinat = y;
  }

  /** 
   * calculate distance of this and another position.
   * @param pos another Position.
   * @return return distance between this position and Pos.
   */
  public double calculateDistance(Position pos) {
    return Math.sqrt(Math.pow(pos.getX() - this.absis, 2) + Math.pow(pos.getY() - this.ordinat, 2));
  }
}
