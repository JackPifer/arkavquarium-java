import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class ConcreteFish extends Fish {
  ConcreteFish() {
    super();
  }

  public void eatFood() {

  }
}

public class FishTest {
  // Fish object
  ConcreteFish fish;
  Position pos;
  LinkedList<FishFood> listOfFishFood;
  LinkedList<Guppy> listOfGuppy;

  @Before
  public void initialize() {
    //Fish Object
    fish = new ConcreteFish();

    pos = new Position(5.0, 5.0);
    //list of fish food
    listOfFishFood = new LinkedList<>();
    FishFood ff = new FishFood(pos);
    listOfFishFood.add(ff);

    //list of fuppy
    listOfGuppy = new LinkedList<>();
    Guppy g = new Guppy();
    g.setCurrentPosition(pos);
    listOfGuppy.add(g);
  }

  @Test
  public void changeFaceDirectionTest() {
    boolean before = fish.getFaceDirection();
    fish.changeFaceDirection();

    assertEquals(!before, fish.getFaceDirection());
  }

  @Test
  public void isHungryTest() {
    //not hungry condition
    assertEquals(false, fish.isHungry());

    //make fish hungry
    fish.setHungerLevel(39);
    assertEquals(true, fish.isHungry());
  }

  @Test
  public void findNearestFoodTest() {
    //Test if food is a fishfood object
    Position fishFoodNearest = fish.findNearestFood(listOfFishFood);
    assertEquals(fishFoodNearest, pos);

    //Test if food is a guppy object
    Position guppyNearest = fish.findNearestFood(listOfGuppy);
    assertEquals(guppyNearest, pos);
  }

  @Test
  public void changeMovingStatusTest() {
    //Fish is hungry
    fish.setHungerLevel(39);

    //change to hunting test
    fish.changeMovingStatus(listOfFishFood);
    assertEquals(fish.getMovingStatus(), MovingObject.MovingStatus.HUNTING);

    //Fish is not hungry
    fish.setHungerLevel(60);

    //change to random test
    fish.changeMovingStatus(listOfFishFood);
    assertEquals(fish.getMovingStatus(), MovingObject.MovingStatus.RANDOM);
  }

  @Test
  public void moveHuntTest() {
    fish.moveHunt(pos);
    assertEquals(fish.getDestination(), pos);
  }

  // move random test?
  // move test?
}