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

}
