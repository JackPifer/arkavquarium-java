public class Position {
    protected double xPos;
    protected double yPos;

    //constructor
    public Position(){
        this.xPos = 0.0;
        this.yPos = 0.0;
    }

    public Position(double x, double y){
        this.xPos = x;
        this.yPos = y;
    }

    //getter
    public double getxPos() {
        return xPos;
    }

    public double getyPos() {
        return yPos;
    }

    //setter

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }
}
