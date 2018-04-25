// File: Aquarium.java
// Responsibility : Container for all objects created

import java.awt.Graphics;
import java.awt.Toolkit;

/** Represents an aquarium.
 * @version 1.0.
*/
public class Aquarium implements Drawable {
  /** 
   * Max Width of the app window .
   */
  public static final int DEFAULT_WIDTH = 650;
  /** 
   * Max Height of the app window .
   */
  public static final int DEFAULT_HEIGHT = 508;
  private LinkedList<Piranha> listOfPiranha;
  private LinkedList<Guppy> listOfGuppy;
  private LinkedList<Coin> listOfCoin;
  private LinkedList<FishFood> listOfFishFood;
  private Snail snail;
  
  /** 
   * Aquarium Constructor.
   */
  public Aquarium() {
    snail = new Snail();
    listOfPiranha = new LinkedList<>();
    listOfGuppy = new LinkedList<>();
    listOfCoin = new LinkedList<>();
    listOfFishFood = new LinkedList<>();
  }

  /** 
   * Snail prop getter.
   * @return object of class Snail.
   */
  public Snail getSnail() {
    return this.snail;
  }

  /** 
   * listOfPiranha prop getter.
   * @return object of class LinkedList of Piranha.
   */
  public LinkedList<Piranha> getListOfPiranha() {
    return this.listOfPiranha;
  }

  /** 
   * listOfGuppy prop getter.
   * @return object of class LinkedList of Guppy.
   */
  public LinkedList<Guppy> getListOfGuppy() {
    return this.listOfGuppy;
  }

  /** 
   * listOfFishFood prop getter.
   * @return object of class LinkedList of FishFood.
   */
  public LinkedList<FishFood> getListOfFishFood() {
    return this.listOfFishFood;
  }

  /** 
   * listOfCoin prop getter.
   * @return object of class LinkedList of Coin.
   */
  public LinkedList<Coin> getListOfCoin() {
    return this.listOfCoin;
  }

  /** 
   * add guppy to listOfguppy.
   * @param guppy Guppy object to add.
   */
  public void addGuppy(Guppy guppy) {
    this.listOfGuppy.add(guppy);
  }

  /** 
   * add piranha to listOfPiranha.
   * @param piranha Piranha object to add.
   */
  public void addPiranha(Piranha piranha) {
    this.listOfPiranha.add(piranha);
  }

  /** 
   * add coin to listOfCoin.
   * @param coin Coin object to add.
   */
  public void addCoin(Coin coin) {
    this.listOfCoin.add(coin);
  }

  /** 
   * add food to listOfFishFood.
   * @param food FishFood object to add.
   */
  public void addFishFood(FishFood food) {
    this.listOfFishFood.add(food);
  }

  /** 
   * remove guppy from listOfguppy.
   * @param guppy Guppy object to remove.
   */
  public void removeGuppy(Guppy guppy) {
    this.listOfGuppy.remove(guppy);
  }

  /** 
   * remove piranha from listOfPiranha.
   * @param piranha Piranha object to remove.
   */
  public void removePiranha(Piranha piranha) {
    this.listOfPiranha.remove(piranha);
  }

  /** 
   * remove coin from listOfCoin.
   * @param coin Coin object to remove.
   */
  public void removeCoin(Coin coin) {
    this.listOfCoin.remove(coin);
  }

  /** 
   * remove food from listOfFishFood.
   * @param food FishFood object to remove.
   */
  public void removeFishFood(FishFood food) {
    this.listOfFishFood.remove(food);
  }

  /** 
   * draw to aquarium.
   * @param g Draw container.
   * @param t Object to grab image.
   */
  public void draw(Graphics g, Toolkit t) {
    g.drawImage(t.getImage("assets/images/Aquarium4.jpg"), 0, 0, null);
  }
}