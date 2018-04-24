import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class DroppableItemTest {
    public Position p;
    public DroppableItem di;

    @Before
    public void initialization() {
        p = new Position(5.0, 5.0);
        di = new DroppableItem(p);
    }

    @Test
    public void moveDownTest() {
        di.moveDown(2.0);
        assertEquals(di.getCurrentPosition().getY(), 45.0, 0.0);
    }
}