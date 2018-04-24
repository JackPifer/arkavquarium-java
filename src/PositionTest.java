import static org.junit.Assert.*;
import org.junit.Test;

public class PositionTest {
    @Test
    public void calculateDistance() {
        Position p1 = new Position(0.0, 0.0);
        Position p2 = new Position(3.0, 4.0);

        assertEquals(5.0, p1.calculateDistance(p2), 0.0);
    }
}