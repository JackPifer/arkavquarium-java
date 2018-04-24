import java.awt.*;
public class Piranha extends Fish implements Drawable{
    public static final int price = 100;
    
    //Constructor
    public Piranha(){
        super();
    }

    public Coin extractCoin(int val){
        val = 100 * (val+1);
        return new Coin(val,new Position(this.getCurrentPosition().getX(),this.getCurrentPosition().getY()));
    }

    @Override
    public void eatFood(){
        this.setHungerLevel(60);
    }

    public void draw(Graphics g, Toolkit t, Controller con){
        if (!isHungry()) {
            if (getFaceDirection()) {
                g.drawImage(t.getImage("images/Piranha_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            } else {
                g.drawImage(t.getImage("images/Piranha_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            }
        }else{
            if (getFaceDirection()) {
                g.drawImage(t.getImage("images/Piranha_Hungry_left_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            } else {
                g.drawImage(t.getImage("images/Piranha_Hungry_right_side.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);
            }
        }
    }

}
