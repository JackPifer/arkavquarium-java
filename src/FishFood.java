import java.awt.*;

/**
 * Represent fish food.
 * @version 1.0.
 */
public class FishFood extends DroppableItem implements Drawable {
  /**
   * price of fish food.
   */
  public static final int price = 10;

  //Constructor
  /**
   * constructor.
   * @param initPosition initial position of the food.
   */
  public FishFood(Position initPosition) {
    super(initPosition);
  }

  @Override
  /** 
   * draw to aquarium.
   * @param g Draw container.
   * @param t Object to grab image.
   */
  public void draw(Graphics g, Toolkit t) {
    g.drawImage(t.getImage("images/Food.png"), 
        (int) getCurrentPosition().getX(), (int) getCurrentPosition().getY(),null);
  }
}
