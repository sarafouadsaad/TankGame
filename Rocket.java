
package tankgame;

import java.awt.Color;
import java.awt.Point;

public class Rocket implements Runnable{
    public Point pos = new Point();
    public Color CurrentColor;
    public int Speed;
    public String imgPath;
    
    public Rocket()
    {
        Speed=1;
    }
    
    public  void  move()
    {
        pos.y-=Speed;
    }

    @Override
    public void run() 
    {
        for (int i=0;i<400;i++)
        {
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
            }
        }
    }
}

