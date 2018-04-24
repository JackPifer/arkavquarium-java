import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class GuppyTest {
  public Guppy guppy;

  @Before
  public void initialization() {
    guppy = new Guppy();
  }

  @Test
  public void eatFoodTest() {
    int numberOfFoodEatenBefore = guppy.getNumberOfFoodEaten();

    guppy.eatFood();
    assertEquals(numberOfFoodEatenBefore + 1, guppy.getNumberOfFoodEaten());
  }

  @Test
  public void growTest() {
    int sizeBefore = guppy.getSize();

    guppy.grow();
    assertEquals(sizeBefore + 1, guppy.getSize());
  }

  @Test
  public void extractCoinTest() {
    guppy.setCoinTime(0);

    guppy.extractCoin();
    assertEquals(15.0, guppy.getCoinTime(), 0);
  }
}