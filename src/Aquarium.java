public class Aquarium {
    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 480;

    private LinkedList<Piranha> listOfPiranha;
    private LinkedList<Guppy> listOfGuppy;
    private LinkedList<Coin> listOfCoin;
    private LinkedList<FishFood> listOfFishFood;
    private Snail snail;

    public Aquarium() {
        Snail snail1 = new Snail();
        this.snail = snail1;
    }

    public Snail getSnail() {
        return this.snail;
    }

    public LinkedList<Piranha> getListOfPiranha() {
        return this.listOfPiranha;
    }

    public LinkedList<Guppy> getListOfGuppy() {
        return this.listOfGuppy;
    }

    public LinkedList<FishFood> getListOfFishFood() {
        return this.listOfFishFood;
    }

    public LinkedList<Coin> getListOfCoin() {
        return this.listOfCoin;
    }

    public void addGuppy(Guppy guppy) {
        this.listOfGuppy.add(guppy);
    }

    public void addPiranha(Piranha piranha) {
        this.listOfPiranha.add(piranha);
    }

    public void addCoin(Coin coin) {
        this.listOfCoin.add(coin);
    }

    public void addFishFood(FishFood food) {
        this.listOfFishFood.add(food);
    }
    
    public void removeGuppy(Guppy guppy) {
        this.listOfGuppy.remove(guppy);
    }

    public void removePiranha(Piranha piranha) {
        this.listOfPiranha.remove(piranha);
    }

    public void removeCoin(Coin coin) {
        this.listOfCoin.remove(coin);
    }

    public void removeFishFood(FishFood food) {
        this.listOfFishFood.remove(food);
    }
}