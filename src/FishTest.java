import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before; 

class ConcreteFish extends Fish {
    ConcreteFish() {
        super();
    }

    public void eatFood() {

    }
}

public class FishTest {
    // Fish object
    ConcreteFish f;
    Position p;
    LinkedList<FishFood> listOfFishFood;
    LinkedList<Guppy> listOfGuppy;

    @Before
    public void initialize() {
        //Fish Object
        f = new ConcreteFish();

        p = new Position(5.0, 5.0);
        //list of fish food
        listOfFishFood = new LinkedList<>();
        FishFood ff = new FishFood(p);
        listOfFishFood.add(ff);

        //list of fuppy
        listOfGuppy = new LinkedList<>();
        Guppy g = new Guppy();
        g.setCurrentPosition(p);
        listOfGuppy.add(g);
    }

    @Test
    public void changeFaceDirectionTest() {
        boolean before = f.getFaceDirection();
        f.changeFaceDirection();

        assertEquals(!before, f.getFaceDirection());
    }

    @Test
    public void isHungryTest() {
        //not hungry condition
        assertEquals(false, f.isHungry());

        //make fish hungry
        f.setHungerLevel(39);
        assertEquals(true, f.isHungry());
    }

    @Test
    public void findNearestFoodTest() {
        //Test if food is a fishfood object
        Position fishFoodNearest = f.findNearestFood(listOfFishFood);
        assertEquals(fishFoodNearest, p);

        //Test if food is a guppy object
        Position guppyNearest = f.findNearestFood(listOfGuppy);
        assertEquals(guppyNearest, p);
    }

    @Test
    public void changeMovingStatusTest() {
        //Fish is hungry
        f.setHungerLevel(39);

        //change to hunting test
        f.changeMovingStatus(listOfFishFood);
        assertEquals(f.getMovingStatus(), MovingObject.MovingStatus.HUNTING);
        
        //Fish is not hungry
        f.setHungerLevel(60);
        
        //change to random test
        f.changeMovingStatus(listOfFishFood);
        assertEquals(f.getMovingStatus(), MovingObject.MovingStatus.RANDOM);
    }

    @Test
    public void moveHuntTest() {
        f.moveHunt(p, 10.0);
        assertEquals(f.getDestination(), p);
    }

    // move random test?
    // move test?
}