public class FishFood extends Position {
    //constructor
    public FishFood(){
        super();
    }

    public FishFood(double x, double y){
        super(x,y);
    }

    public void move(double t){
        this.yPos += 20*t;
    }
}
