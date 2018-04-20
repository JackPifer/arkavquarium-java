public interface MovingObject {
    public enum MovingStatus {
        RANDOM, HUNTING, STATIC;
    }
    public void move(Position destination, double time, MovingStatus movingStatus);
}