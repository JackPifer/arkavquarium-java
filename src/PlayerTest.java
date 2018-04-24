import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PlayerTest {
    Player p;

    @Test
    public void increaseMoneyTest() {
        p = new Player();
        p.increaseMoney(50);
        assertEquals(550, p.getMoney());
    }

    @Test
    public void decreaseMoneyTest() {
        p = new Player();
        p.decreaseMoney(50);
        assertEquals(450, p.getMoney());
    }

    @Test
    public void isWinTest() {
        p = new Player();
        p.setEgg(3);
        assertTrue(p.isWin());

        p.setEgg(1);
        assertFalse(p.isWin());
    }
}