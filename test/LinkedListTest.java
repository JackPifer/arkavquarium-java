import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
  LinkedList<Integer> ll;

  @Test
  public void getSizeTest() {
    ll = new LinkedList<>();

    assertEquals(0, ll.getSize());

    ll.add(123);
    assertEquals(1, ll.getSize());
  }

  @Test
  public void addTest() {
    ll = new LinkedList<>();

    ll.add(123);
    assertEquals(123, (int) ll.get(0));

    ll.add(456);
    assertEquals(456, (int) ll.get(1));
  }

  @Test
  public void findTest() {
    ll = new LinkedList<>();

    // assertEquals(-1, ll.find(123));

    ll.add(123);
    assertEquals(0, ll.find(123));
  }

  @Test
  public void removeTest() {
    LinkedList<String> xx = new LinkedList<>();

    xx.add("aaa");
    xx.add("bbb");

    xx.remove("aaa");
    assertEquals("bbb", (String) xx.getFirst().getValue());
    
    xx.remove("bbb");
    assertNull(xx.getFirst());
  }

  @Test
  public void getTest() {
    ll = new LinkedList<>();

    assertNull(ll.get(1234));

    ll.add(123);
    assertEquals(123, (int) ll.get(0));
  }
}