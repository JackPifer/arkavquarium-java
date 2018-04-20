public class Player {
    public enum PlayerStatus {
        LOSE, WIN, ON_GAME;
    }
    private int money;
    private int egg;
    private PlayerStatus playerStatus;

    public Player(){
        this.money = 500;
        this.egg = 0;
        this.playerStatus = PlayerStatus.ON_GAME;
    }

    public PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }

    public int getMoney() {
        return this.money;
    }

    public int getEgg() {
        return this.egg;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public void increaseMoney(int added) {
        this.money = this.money + added;
    }
    
    public void decreaseMoney(int cost) {
        this.money = this.money - cost;
    }

    public void setEgg(int egg) {
        this.egg = egg;
    }

    public boolean isWin() {
        if (this.egg == 3) {
            this.playerStatus = PlayerStatus.WIN;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isMoneyEnough(int price){
        return this.money >= price;
    }

    public int getEggPrice() {
        switch(this.egg){
            case 1 : return 350;
            case 2 : return 500;
            default : return 200;
        }
    }
    
    public boolean payEgg() {
        if(isMoneyEnough(this.getEggPrice())) {
            this.egg++;
            this.decreaseMoney(this.getEggPrice());
            return true;
        }
        return false;
    }

    public boolean payFood() {
        if(isMoneyEnough(FishFood.price)){
            this.decreaseMoney(FishFood.price);
            return true;
        }
        return false;
    }

    public boolean payPiranha() {
        if(isMoneyEnough(Piranha.price)){
            this.decreaseMoney(Piranha.price);
            return true;
        }
        return false;
    }

    public boolean payGuppy() {
        if(isMoneyEnough(Guppy.price)){
            this.decreaseMoney(Guppy.price);
            return true;
        }
        return false;
    }
}