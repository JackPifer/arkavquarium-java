import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class PiranhaTest {
    public Piranha p;
    
    @Before
    public void initialization() {
        p = new Piranha();
    }

    @Test
    public void eatFoodTest() {
        p.eatFood();
        assertEquals(60, p.getHungerLevel());
    }
}