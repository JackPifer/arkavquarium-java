public class Piranha extends Fish {
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
