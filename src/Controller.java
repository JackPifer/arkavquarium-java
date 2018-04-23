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
        f.setSize(Aquarium.DEFAULT_WIDTH,Aquarium.DEFAULT_HEIGHT);
        f.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        Toolkit t = Toolkit.getDefaultToolkit();
        g.drawImage(t.getImage("src/images/Aquarium4.jpg"),0,0,this);

    }
}