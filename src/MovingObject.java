public interface MovingObject {
    public enum MovingStatus {
        RANDOM, HUNTING, STATIC;
    }
    public <T> void move(double time, LinkedList<T> food);
}