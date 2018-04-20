public class Position {
    protected double x;
    protected double y;

    //Constructor
    public Position(){
        this.x = 0.0;
        this.y = 0.0;
    }

    public Position(double x, double y){
        this.x = x;
        this.y = y;
    }

    //Getter for each attribute
    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    //Setter for each attribute
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
