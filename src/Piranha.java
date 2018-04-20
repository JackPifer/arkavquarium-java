public class Piranha extends Fish {
    public static final int price = 100;
    
    //Constructor
    public Piranha(){
        super();
    }

    public Coin extractCoin(int val){
        val = 100 * (val+1);
        return new Coin(val,this.getCurrentPosition());
    }

    @Override
    public void eatFood(){
        this.setHungerLevel(60);
    }

    public Guppy findNearestFood(LinkedList<Guppy> foods){
        Guppy nearestFood = foods.get(0);
        double minDistance = this.currentPosition.calculateDistance(nearestFood.getCurrentPosition());
        for(int i = 1; i < foods.getSize(); i++){
            double tempDistance = this.currentPosition.calculateDistance(foods.get(i).getCurrentPosition());
            if (tempDistance < minDistance) {
                minDistance = tempDistance;
                nearestFood = foods.get(i);
            }
        }
        return nearestFood;
    }
}
