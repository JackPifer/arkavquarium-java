import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller extends JPanel {
    private Aquarium tank;
    private Player player;
    public static JFrame f = new JFrame();
    public static long prev = System.nanoTime();
    public static long time = 1;
    public Controller() {
       this.tank = new Aquarium();
       this.player = new Player();
       tank.addGuppy(new Guppy());
       tank.addGuppy(new Guppy());
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
            this.tank.addFishFood(food);
        }
    }

    public void run(){

        f.add(this);
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(e.getButton() == MouseEvent.BUTTON1){
                    buyFood(new Position(e.getX(),e.getY()));
                }
            }
        });

        f.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_F){
                    buyGuppy();
                } else if (e.getKeyCode() == KeyEvent.VK_P){
                    buyPiranha();
                }
            }
        });

        f.setPreferredSize(new Dimension(Aquarium.DEFAULT_WIDTH, Aquarium.DEFAULT_HEIGHT));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public void animateGuppy() {
        for (int gupCount = 0; gupCount < tank.getListOfGuppy().getSize(); gupCount++) {
            Guppy curr = tank.getListOfGuppy().get(gupCount);
            if (curr.getIsAlive()) {
                curr.changeMovingStatus(tank.getListOfFishFood());
                curr.move(time, tank.getListOfFishFood());
                for (int foodCount = 0; foodCount < tank.getListOfFishFood().getSize(); foodCount++) {
                    if (curr.isHungry() && curr.getCurrentPosition().calculateDistance(tank.getListOfFishFood().get(foodCount).getCurrentPosition()) < 15) {
                        tank.removeFishFood(tank.getListOfFishFood().get(foodCount));
                        curr.eatFood();
                        break;
                    }
                }
                if (curr.getCoinTime() < 0) {
                    tank.addCoin(curr.extractCoin());
                }
                curr.changeIsAlive();
            } else {
                tank.removeGuppy(curr);
            }
        }
    }

    public void animatePiranha() {
        for (int pirCount = 0; pirCount < tank.getListOfPiranha().getSize(); pirCount++) {
            Piranha curr = tank.getListOfPiranha().get(pirCount);
            if (curr.getIsAlive()) {
                curr.changeMovingStatus(tank.getListOfGuppy());
                curr.move(time, tank.getListOfGuppy());
                for (int gupCount = 0; gupCount < tank.getListOfGuppy().getSize(); gupCount++) {
                    if (curr.isHungry() && curr.getCurrentPosition().calculateDistance(tank.getListOfGuppy().get(gupCount).getCurrentPosition()) < 15) {
                        tank.addCoin( curr.extractCoin(tank.getListOfGuppy().get(gupCount).getSize()) );
                        tank.removeGuppy(tank.getListOfGuppy().get(gupCount));
                        curr.eatFood();
                        break;
                    }
                }
                curr.changeIsAlive();
            } else {
                tank.removePiranha(curr);
            }
        }
    }

    public void animateFishFood() {
        for (int foodCount = 0; foodCount < tank.getListOfFishFood().getSize(); foodCount++) {
            tank.getListOfFishFood().get(foodCount).moveDown(time);

        }
    }

    public void animateCoin() {
        for (int coinCount = 0; coinCount < tank.getListOfCoin().getSize(); coinCount++) {
            tank.getListOfCoin().get(coinCount).moveDown(time);
        }
    }

    public void animateSnail(){
        tank.getSnail().move(time,tank.getListOfCoin());
    }

    @Override
    public void paintComponent(Graphics g) {
//        System.out.println("MASUK");
//        long now = System.nanoTime();
//        long time = now - prev;
//        prev = now;
//        System.out.println(time);
        Toolkit t = Toolkit.getDefaultToolkit();
        tank.draw(g,t,null);
//        System.out.println("MASUK SINI");
        for(int gupCount = 0;gupCount<tank.getListOfGuppy().getSize(); gupCount++){
            tank.getListOfGuppy().get(gupCount).draw(g,t,this);
        }

        for(int pirCount = 0;pirCount<tank.getListOfPiranha().getSize(); pirCount++){
            tank.getListOfPiranha().get(pirCount).draw(g,t,this);
        }

        for(int foodCount = 0;foodCount<tank.getListOfFishFood().getSize(); foodCount++){
            tank.getListOfFishFood().get(foodCount).draw(g,t,this);
        }

        for(int coinCount = 0;coinCount<tank.getListOfCoin().getSize(); coinCount++){
            tank.getListOfCoin().get(coinCount).draw(g,t,this);
        }
        tank.getSnail().draw(g,t,this);
        animateGuppy();
        animateCoin();
        animatePiranha();
        animateFishFood();
        animateSnail();
        try{
            Thread.sleep(100);
        }catch(Exception exc){

        }
        f.repaint();


    }
}