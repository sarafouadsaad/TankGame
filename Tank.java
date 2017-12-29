
package tankgame;

import java.awt.Point;

public class Tank {
    public Point pos = new Point();
    public String ImagePath;
    public Rocket rocket = new Rocket();
    public int speed;
    public Tank (String ImagePath)
    {
        speed=5;
        this.ImagePath=ImagePath;
        rocket.imgPath="img\\rocket.gif";
    }

    void mover() 
    {
        this.pos.x += speed;
    }
    
      void movel() 
      {
        this.pos.x -= speed;
    }

    public void fireBullet() 
    {
        rocket.pos.x=this.pos.x+60;
        rocket.pos.y=this.pos.y;
        Thread thread=new Thread (rocket);
        thread.start();
    }
}
