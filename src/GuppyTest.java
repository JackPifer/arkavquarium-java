import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class GuppyTest {
    public Guppy g;
    
    @Before
    public void initialization() {
        g = new Guppy();
    }

    @Test
    public void eatFoodTest() {
        int numberOfFoodEatenBefore = g.getNumberOfFoodEaten();

        g.eatFood();
        assertEquals(numberOfFoodEatenBefore + 1, g.getNumberOfFoodEaten());
    }

    @Test
    public void growTest() {
        int sizeBefore = g.getSize();

        g.grow();
        assertEquals(sizeBefore + 1, g.getSize());
    }

    @Test
    public void extractCoinTest() {
        g.setCoinTime(0);

        g.extractCoin();
        assertEquals(15.0, g.getCoinTime(), 0);
    }
}