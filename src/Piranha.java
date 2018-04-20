public class Piranha extends Fish {
    //constructor
    public Piranha(){
        super();
    }

    public Coin extractCoin(int val){
        val = 100 * (val+1);
        return new Coin(val,this.getxPos(),this.getyPos());
    }

    public void eatFood(){
        this.hungerTime = 60;
    }
}
