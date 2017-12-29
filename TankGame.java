
package tankgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author sara fouad
 */
public class TankGame {
static int num = 0;
    static Timer timer = null;
    static JFrame frame = new JFrame();
    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Game game = new Game();
        
        frame.setSize(600, 600);
        
        ActionListener taskPerformer = new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent evt) {
                if(num<5){
                game.Balls.add(new Ball(100,-200,2,Color.ORANGE));
                game.Balls.add(new Ball(150,-200,2,Color.RED));
                game.Balls.add(new Ball(200,-200,2,Color.CYAN));
                game.Balls.add(new Ball(250,-200,2,Color.MAGENTA));
                game.Balls.add(new Ball(300,-200,2,Color.YELLOW));
                game.Balls.add(new Ball(350,-200,2,Color.BLUE));
                game.Balls.add(new Ball(400,-200,2,Color.BLACK));
                num++;
                }
        }
     };
        timer = new Timer(2000,taskPerformer);
        timer.start();
        frame.add(game,BorderLayout.CENTER);
        game.setFocusable(true);
        Thread thread = new Thread(game);
        thread.start();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
}
