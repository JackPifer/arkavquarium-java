import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Controller extends JPanel {
    private Aquarium tank;
    private Player player;
    public static JFrame f = new JFrame();

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
                    buyFood(new Position(e.getXOnScreen(),e.getYOnScreen()));
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
        for(int gupCount = 0;gupCount<tank.getListOfGuppy().getSize(); gupCount++){
            Guppy curr = tank.getListOfGuppy().get(gupCount);
            curr.changeMovingStatus(tank.getListOfFishFood());
            curr.move(time,tank.getListOfFishFood());
            curr.eatFood();
            if (curr.getCoinTime()<0){
                tank.addCoin(curr.extractCoin());
            }
        }

        for(int pirCount = 0;pirCount<tank.getListOfPiranha().getSize(); pirCount++){
            Piranha curr = tank.getListOfPiranha().get(pirCount);
            curr.changeMovingStatus(tank.getListOfGuppy());
            curr.move(time,tank.getListOfGuppy());
            for(int gupCount = 0;gupCount<tank.getListOfGuppy().getSize(); gupCount++){
                tank.getListOfFishFood().get(food).moveDown(time);
            }
        }

        for(int foodCount = 0;foodCount<tank.getListOfFishFood().getSize(); foodCount++){
            tank.getListOfFishFood().get(foodCount).moveDown(time);
        }

        for(int coinCount = 0;coinCount<tank.getListOfCoin().getSize(); coinCount++){
            tank.getListOfCoin().get(coinCount).moveDown(time);
        }

        tank.getSnail().move(time,tank.getListOfCoin());

        f.setSize(Aquarium.DEFAULT_WIDTH,Aquarium.DEFAULT_HEIGHT);
        f.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        tank.draw(g,t,this);

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
    }
}