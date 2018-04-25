import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
  Player player;

  @Test
  public void increaseMoneyTest() {
    player = new Player();
    double beforeMoney = player.getMoney();
    player.increaseMoney(50.0);
    assertEquals(beforeMoney+50.0, player.getMoney(), 0.0);
  }

  @Test
  public void decreaseMoneyTest() {
    player = new Player();
    double beforeMoney = player.getMoney();
    player.decreaseMoney(50);
    assertEquals(beforeMoney-50.0, player.getMoney(), 0.0);
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