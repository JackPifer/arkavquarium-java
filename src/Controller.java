public class Controller {
    private Aquarium tank;
    private Player player;

    public Controller() {
       this.tank = new Aquarium();
       this.player = new Player();    
    }
    
    public void buyEgg() {
        this.player.payEgg();
    }

    public void buyGuppy() {
        if(this.player.payGuppy()) {
            Guppy guppy = new Guppy();
            this.tank.addGuppy(guppy);
        }
    }

    public void buyPiranha() {
        if(this.player.payPiranha()) {
            Piranha piranha = new Piranha();
            this.tank.addPiranha(piranha);
        }
    }

    public void buyFood(Position initPosition) {
        if(this.player.payFood()) {
            FishFood food = new FishFood(initPosition);
        }
    }
}