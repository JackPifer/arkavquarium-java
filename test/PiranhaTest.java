import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PiranhaTest {
  public Piranha piranha;

  @Before
  public void initialization() {
    piranha = new Piranha();
  }

  @Test
  public void eatFoodTest() {
    piranha.eatFood();
    assertEquals(60, piranha.getHungerLevel());
  }
}