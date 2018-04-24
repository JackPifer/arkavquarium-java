/** 
 * represents a player.
 * @version 1.0.
 */
public class Player {
    /** 
     * playerstatus enum.
     */
    public enum PlayerStatus {
        LOSE, WIN, ON_GAME;
    }
    private double money;
    private int egg;
    private PlayerStatus playerStatus;

    /** 
     * constructor.
     */
    public Player(){
        this.money = 500;
        this.egg = 0;
        this.playerStatus = PlayerStatus.ON_GAME;
    }

    /** 
     * getter.
     * @return PlayerStatus.
     */
    public PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }

    /** 
     * getter.
     * @return double money.
     */
    public double getMoney() {
        return this.money;
    }

    /** 
     * getter.
     * @return integer egg size.
     */
    public int getEgg() {
        return this.egg;
    }

    /** 
     * setter.
     * @param playerStatus playerStatus.
     */
    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    /** 
     * increase money by certain value.
     * @param added value of the money to decrease.
     */
    public void increaseMoney(double added) {
        this.money = this.money + added;
    }
    
    /** 
     * decrease money by certain value.
     * @param cost value of the money to decrease.
     */
    public void decreaseMoney(double cost) {
        this.money = this.money - cost;
    }

    /** 
     * setter.
     * @param egg change egg size.
     */
    public void setEgg(int egg) {
        this.egg = egg;
    }

    /** 
     * determine if player win (when egg size = 3) and set the playerstatus to finish.
     * @return boolean true if player win.
     */
    public boolean isWin() {
        if (this.egg == 3) {
            this.playerStatus = PlayerStatus.WIN;
            return true;
        } else {
            return false;
        }
    }

    /** 
     * determine if player lose.
     * @return boolean true if player lose.
     */
    public boolean isLose(Aquarium tank){
        if (tank.getListOfCoin().getSize()==0 && tank.getListOfPiranha().getSize()==0 && tank.getListOfGuppy().getSize()==0 && this.getMoney() < Guppy.price){
            this.playerStatus = PlayerStatus.LOSE;
            return true;
        }else{
            return false;
        }
    }
    
    /** 
     * is available money greater than price.
     * @return boolean is it greater.
     */
    public boolean isMoneyEnough(int price){
        return this.money >= price;
    }

    /** 
     * return egg price correspondent to current size.
     * @return int egg price.
     */
    public int getEggPrice() {
        switch(this.egg){
            case 1 : return 350;
            case 2 : return 500;
            default : return 200;
        }
    }
    
    /** 
     * buy egg.
     * @return boolean, is payment success.
     */
    public boolean payEgg() {
        if(isMoneyEnough(this.getEggPrice()) && this.egg<=3) {
            this.egg++;
            this.decreaseMoney(this.getEggPrice());
            return true;
        }
        return false;
    }

    /** 
     * buy food.
     * @return boolean, is payment success.
     */
    public boolean payFood() {
        if(isMoneyEnough(FishFood.price)){
            this.decreaseMoney(FishFood.price);
            return true;
        }
        return false;
    }

    /** 
     * buy piranha.
     * @return boolean, is payment success.
     */
    public boolean payPiranha() {
        if(isMoneyEnough(Piranha.price)){
            this.decreaseMoney(Piranha.price);
            return true;
        }
        return false;
    }

    /** 
     * buy guppy.
     * @return boolean, is payment success.
     */
    public boolean payGuppy() {
        if(isMoneyEnough(Guppy.price)){
            this.decreaseMoney(Guppy.price);
            return true;
        }
        return false;
    }
}