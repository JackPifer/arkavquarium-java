public class FishFood extends DroppableItem {
    private final int price = 10;

    //Constructor
    public FishFood(Position initPosition){
        super(initPosition);
    }
    
    //Getter
    public int getPrice() {
        return this.price;
    }
}
