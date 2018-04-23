import java.awt.*;

public class FishFood extends DroppableItem implements Drawable{
    public static final int price = 10;

    //Constructor
    public FishFood(Position initPosition){
        super(initPosition);
    }

    @Override
    public void draw(Graphics g, Toolkit t, Controller con) {
        g.drawImage(t.getImage("images/Ikan.png"), (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(), con);

    }
}
