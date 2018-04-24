// File: Drawable.java
// Interface to draw object into visual representation
import java.awt.*;
/** 
 * Interface to draw object into visual representation.
 * @version 1.0.
 */
public interface Drawable {
    /** 
     * draw to aquarium.
     * @param g Draw container.
     * @param t Object to grab image.
     */
    public void draw(Graphics g, Toolkit t);
}