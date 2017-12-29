
package tankgame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static tankgame.TankGame.frame;

public class Game extends JPanel implements Runnable{

   public ArrayList<Ball>Balls=new ArrayList<Ball>(5);
   public Tank BlueTank=new Tank("img\\preview_344 copy copy.png");
   int ballsNumber = 35;
   
   public Game()
    {
       setSize(600,600);
       BlueTank.pos.x = 220;
       BlueTank.pos.y = 340;
       this.addKeyListener(new keylist());
    }

    private class keylist implements KeyListener 
    {
        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
                BlueTank.mover();
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
                BlueTank.movel();
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                BlueTank.fireBullet();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
    }
    
   @Override
    public void  paintComponent(Graphics g)
    {
        g.clearRect(0, 0, 600, 600);
        try
        {
        BufferedImage imgtank = ImageIO.read(new File(BlueTank.ImagePath));
        BufferedImage imgrocket = ImageIO.read(new File(BlueTank.rocket.imgPath));
        g.drawImage(imgtank, BlueTank.pos.x, BlueTank.pos.y+90,null);
        g.drawImage(imgrocket, BlueTank.rocket.pos.x, BlueTank.rocket.pos.y,null);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        for (Ball OneBall: Balls) 
        {
            g.setColor(OneBall.CurrentColor);
            g.fillOval(OneBall.x,OneBall.y, 50, 50);
            if (BlueTank.rocket.pos.distance(OneBall.x, OneBall.y)<=50)
            {
                Balls.remove(OneBall);
                ballsNumber--;
                break;
            }   
         }    
    }
    
    @Override
    public void run() 
    {
        try
        {
            while(true)
            {
                for (Ball OneBall: Balls)
                {
                    OneBall.move(this.getHeight());
                    if(OneBall.y>415){
                        int lost = JOptionPane.showOptionDialog(null, "You Lost The Game", "Losser", 
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                if(lost == 0){
                                   frame.dispose();
                                   System.exit(0);
                                }
                    }
                } 
                 if(ballsNumber==0){
                        int win = JOptionPane.showOptionDialog(null, "You Won The Game", "Winner", 
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                                if(win == 0){
                                   frame.dispose();
                                   System.exit(0);
                                }
                    }
                Thread.sleep(50);
                repaint();
            }
        }
        catch (InterruptedException e)
        {}
   } 
}
