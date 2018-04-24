import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player player;

  @Test
  public void increaseMoneyTest() {
    player = new Player();
    player.increaseMoney(50);
    assertEquals(550, player.getMoney());
  }

  @Test
  public void decreaseMoneyTest() {
    player = new Player();
    player.decreaseMoney(50);
    assertEquals(450, player.getMoney());
  }

  @Test
  public void isWinTest() {
    player = new Player();
    player.setEgg(3);
    assertTrue(player.isWin());

    player.setEgg(1);
    assertFalse(player.isWin());
  }
}