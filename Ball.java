
package tankgame;

import java.awt.Color;

public class Ball {
     public int x,y;
    public int speedy;
    public Color CurrentColor;

    public Ball(int x,int y,int speedy,Color color)
    {
        this.x=x;
        this.y=y;
        this.speedy=speedy;
        this.CurrentColor=color;
    }

    public  void move(int width)
    {
        y+=speedy;
    }   
}