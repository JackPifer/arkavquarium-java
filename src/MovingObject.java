public interface MovingObject {
    public enum MovingStatus {
        RANDOM, HUNTING, STATIC;
    }
    public <T> void move(Position destination, double time, MovingStatus movingStatus, LinkedList<T> food);
}