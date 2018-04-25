import java.awt.Graphics;
import java.awt.Toolkit;

/** 
 * represents a Piranha.
 * @version 1.0.
 */
public class Piranha extends Fish implements Drawable {
  /** 
   * price of a piranha.
   */
  public static final int price = 100;

  //Constructor
  /** 
   * constructor.
   */
  public Piranha() {
    super();
  }

  /** 
   * extract coin.
   * @param val value of coin
   * @return Coin
   */
  public Coin extractCoin(int val) {
    val = 100 * (val + 1);
    return new Coin(val, 
        new Position(
            this.getCurrentPosition().getX(), this.getCurrentPosition().getY()));
  }

  /** 
   * eat food.
   */
  @Override
  public void eatFood() {
    this.setHungerLevel(60);
  }

  /** 
   * draw to aquarium.
   * @param g Draw container.
   * @param t Object to grab image.
   */
  public void draw(Graphics g, Toolkit t) {
    if (!isHungry()) {
      if (getFaceDirection()) {
        g.drawImage(t.getImage("assets/images/Piranha_left_side.png"), (int) getCurrentPosition().getX(),
            (int) getCurrentPosition().getY(), null);
      } else {
        g.drawImage(t.getImage("assets/images/Piranha_right_side.png"), (int) getCurrentPosition().getX(),
            (int) getCurrentPosition().getY(), null);
      }
    } else {
      if (getFaceDirection()) {
        g.drawImage(t.getImage("assets/images/Piranha_Hungry_left_side.png"), 
            (int) getCurrentPosition().getX(),
                (int) getCurrentPosition().getY(), null);
      } else {
        g.drawImage(t.getImage("assets/images/Piranha_Hungry_right_side.png"),
            (int) getCurrentPosition().getX(),
                (int) getCurrentPosition().getY(), null);
      }
    }
  }

}
