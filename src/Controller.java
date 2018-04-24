import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/** 
 * represent controller.
 * @version 1.0.
 */
public class Controller extends JPanel {
  private Aquarium tank;
  private Timer time;
  private Player player;
  /** 
   * JFrame.
   */
  public static JFrame f = new JFrame("Arkavquarium");
  
  /** 
   * constructor.
  */

  public Controller() {
    this.tank = new Aquarium();
    this.player = new Player();
    this.tank.addGuppy(new Guppy());
    this.tank.addGuppy(new Guppy());
  }

  /** 
  * buy egg.
  */
  
  public void buyEgg() {
    this.player.payEgg();
  }
  
  /**
  * buy guppy.
  */

  public void buyGuppy() {
    if (this.player.payGuppy()) { 
      Guppy guppy = new Guppy();
      this.tank.addGuppy(guppy);
    }
  }
  
  /**
    * buy piranha.
  */
  
  public void buyPiranha() {
    if (this.player.payPiranha()) {
      Piranha piranha = new Piranha();
      this.tank.addPiranha(piranha);
    }
  }
  
  /**
  * buy food.
  * @param initPosition object Position of the food.
  */

  public void buyFood(Position initPosition) {
    if (this.player.payFood()) {
      FishFood food = new FishFood(initPosition);
      this.tank.addFishFood(food);
    }
  }

  /**
    * run.
    */
  public void run() {
    f.add(this);
    f.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        boolean getCoin = false;
        boolean buyegg = false;
        if (e.getButton() == MouseEvent.BUTTON1) {
          if (Math.abs(e.getX() - 584) < 15 && Math.abs(e.getY() - 72) < 15) {
            buyEgg();
            buyegg = true;
          } else {
            getCoin = getCoin(e);
          }
          if (!getCoin && !buyegg) {
            buyFood(new Position(e.getX() - 10, e.getY() - 20));
          }
        }
      }
    });

    f.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if (e.getKeyCode() == KeyEvent.VK_F) {
          buyGuppy();
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
          buyPiranha();
        }
      }
    });

    f.setPreferredSize(new Dimension(Aquarium.DEFAULT_WIDTH, Aquarium.DEFAULT_HEIGHT));
    f.pack();
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    time = new Timer(20, new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        repaint();
      }
    });
    time.start();
  }

  /**
  * getCoin using mouse event.
  * @param e Mouseevent.
  * @return getCoin boolean.
  */
   
  public boolean getCoin(MouseEvent e) {
    boolean getCoin = false;
    for (int coinCount = 0 ; coinCount < tank.getListOfCoin().getSize() ; coinCount++) {
      Position clickedPosition = new Position(e.getX() - 18, e.getY() - 33);
      if (tank.getListOfCoin().get(coinCount).getCurrentPosition().calculateDistance(
            clickedPosition) < 15) {
        player.increaseMoney(tank.getListOfCoin().get(coinCount).getValue());
        tank.removeCoin(tank.getListOfCoin().get(coinCount));
        getCoin = true;
      }
    }
    return getCoin;
  }
    
  /**
  * animate guppy.
  */

  public void animateGuppy() {
    for (int gupCount = 0; gupCount < tank.getListOfGuppy().getSize(); gupCount++) {
      Guppy curr = tank.getListOfGuppy().get(gupCount);
      if (curr.getIsAlive()) {
        curr.changeMovingStatus(tank.getListOfFishFood());
        curr.move(tank.getListOfFishFood());
        curr.setCoinTime(curr.getCoinTime() - 0.02);
        for (int foodCount = 0; foodCount < tank.getListOfFishFood().getSize(); foodCount++) {
          if (curr.isHungry() 
              && curr.getCurrentPosition().calculateDistance(
                  tank.getListOfFishFood().get(foodCount).getCurrentPosition()) < 15) {
            tank.removeFishFood(tank.getListOfFishFood().get(foodCount));
            curr.eatFood();
            break;
          }
        }
        if (curr.getCoinTime() < 0 && curr.getSize() > 1) {
          tank.addCoin(curr.extractCoin());
        }
        curr.changeIsAlive();
      } else {
        tank.removeGuppy(curr);
      }
    }
  }

  /**
  * animate piranha.
  */

  public void animatePiranha() {
    for (int pirCount = 0; pirCount < tank.getListOfPiranha().getSize(); pirCount++) {
      Piranha curr = tank.getListOfPiranha().get(pirCount);
      if (curr.getIsAlive()) {
        curr.changeMovingStatus(tank.getListOfGuppy());
        curr.move(tank.getListOfGuppy());
        for (int gupCount = 0; gupCount < tank.getListOfGuppy().getSize(); gupCount++) {
          if (curr.isHungry() 
              && curr.getCurrentPosition().calculateDistance(
                  tank.getListOfGuppy().get(gupCount).getCurrentPosition()) < 15) {
            tank.addCoin(curr.extractCoin(tank.getListOfGuppy().get(gupCount).getSize()));
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

  /**
  * animate FishFood.
  */

  public void animateFishFood() {
    for (int foodCount = 0; foodCount < tank.getListOfFishFood().getSize(); foodCount++) {
      tank.getListOfFishFood().get(foodCount).moveDown();
      if (tank.getListOfFishFood().get(foodCount).isBottom()) {
        tank.removeFishFood(tank.getListOfFishFood().get(foodCount));
      }
    }
  }

  /**
  * animate Coin.
  */

  public void animateCoin() {
    for (int coinCount = 0; coinCount < tank.getListOfCoin().getSize(); coinCount++) {
      tank.getListOfCoin().get(coinCount).moveDown();
    }
  }

  /**
  * animate Snail.
  */

  public void animateSnail() {
    tank.getSnail().changeMovingStatus(tank.getListOfCoin());
    tank.getSnail().move(tank.getListOfCoin());
    for (int coinCount = 0;coinCount < tank.getListOfCoin().getSize();coinCount++) {
      if (tank.getListOfCoin().get(coinCount).getCurrentPosition().calculateDistance(
            tank.getSnail().getCurrentPosition()) < 15) {
        player.increaseMoney(tank.getListOfCoin().get(coinCount).getValue());
        tank.removeCoin(tank.getListOfCoin().get(coinCount));
      }
    }
  }

  /**
  * animate egg.
  * @param g graphic.
  * @param t toolkit.
  */

  public void animateEgg(Graphics g, Toolkit t) {
    if (player.getEgg() == 0) {
      g.drawImage(t.getImage("images/Egg_L1.png"),550,20,null);
    } else if (player.getEgg() == 1) {
      g.drawImage(t.getImage("images/Egg_L2.png"),550,20,null);
    } else {
      g.drawImage(t.getImage("images/Egg_L3.png"),550,20,null);
    }
  }

  /**
  * draw text and sprite needed for the game.
  * @param g graphic.
  * @param t toolkit.
  */

  public void graphicAccesories(Graphics g, Toolkit t) {
    g.setColor(new Color(255,215,0));
    g.setFont(new Font("Gill Sans Ultra Bold", Font.BOLD, 20));
    g.drawImage(t.getImage("images/Money.png"),40,20,null);
    g.drawString(Double.toString(player.getMoney()), 70, 45);
    g.setColor(Color.white);
    g.setFont(new Font("Gill Sans",Font.BOLD, 12));
    g.drawString("F : Buy Guppy ($50)",40,70);
    g.drawString("P : Buy Piranha ($100)",40,85);
    g.drawString("1: $200 2: $350 3: $500",500,75);
    g.drawImage(t.getImage("images/ArkavQuarium.png"),210,20,null);
    animateEgg(g,t);
  }

  /**
  * Generic method to draw every member of list. 
  * @param list LinkedList of generic Type.
  * @param g graphic.
  * @param t Toolkit.
  */
    
  public <T extends Drawable> void drawAllInList(LinkedList<T> list,Graphics g, Toolkit t) {
    for (int gupCount = 0; gupCount < list.getSize(); gupCount++) {
      list.get(gupCount).draw(g, t);
    }
  }

  /**
  * Generic method to draw and animate every object in aquarium. 
  * @param g graphic.
  * @param t Toolkit.
  */

  public void drawAndAnimateObject(Graphics g, Toolkit t) {
    drawAllInList(this.tank.getListOfGuppy(),g,t);
    drawAllInList(this.tank.getListOfPiranha(),g,t);
    drawAllInList(this.tank.getListOfFishFood(),g,t);
    drawAllInList(this.tank.getListOfCoin(),g,t);
    this.tank.getSnail().draw(g, t);
    animateGuppy();
    animateCoin();
    animatePiranha();
    animateFishFood();
    animateSnail();
  }

  /**
  * paint.
  * @param g graphic.
  */

  @Override
  public void paintComponent(Graphics g) {
    Toolkit t = Toolkit.getDefaultToolkit();
    tank.draw(g,t);
    if (!player.isWin()) {
      this.drawAndAnimateObject(g,t);
      this.graphicAccesories(g,t);
      if (player.isLose(tank)) {
        g.drawImage(t.getImage("images/Lose.png"), 
            Aquarium.DEFAULT_WIDTH / 2 - 170, Aquarium.DEFAULT_HEIGHT / 2 - 50, null);
      }
    } else {
      g.drawImage(t.getImage("images/Win.png"), 
          Aquarium.DEFAULT_WIDTH / 2 - 270,Aquarium.DEFAULT_HEIGHT / 2 - 75 ,null);
    }
  }
}