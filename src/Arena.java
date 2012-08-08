/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class Arena extends JPanel implements Commn,KeyListener {

    String message = "Game Over";
    Ball ball;
    Base base;
    Brick bricks[];
    Ball1 ball1;
    Ball2 ball2;
    Bomb bomb;
    Timer timer;
    /**
     * counters to keep track of power bricks been hit or not
     * in order to drop powers which will scaleup/down the size of brick
     * or bomb will be dropped to end the game
     */
    boolean ctr1 = false;
    boolean ctr2 = false;
    boolean ctr3 = false;
    int life =3;    // to keep track of chances available to user
    boolean ingame = true; // to check if game is running or not
    int timerId,x;
    int county = 0; // used to display scores on the frame
    
    
    
    public Arena(){
        
        addKeyListener(this); // used to record keys for base movement
        setFocusable(true);
                
        bricks = new Brick[40]; // total no. of bricks used
        
        setDoubleBuffered(true);
        
        timer = new Timer();
        /**
         * to schedule the task at fixed rate for execution
         * at specified time followed by specified period
         */
        timer.scheduleAtFixedRate(new ScheduleTask(), 1000,10);
      }
    
    public void addNotify(){
        super.addNotify();
        gameInit();
    }
    // game intialization, ball and base construcor called and bricks set-up
    public void gameInit(){
        ball = new Ball();
        base = new Base();
        
        int k =0;
        for(int i=0;i<5;i++){
            for(int j=0;j<8;j++){
                bricks[k] = new Brick(j*40+30,i*10+80);
                k++;
            }
        }
    }
    
    //to paint and drawstring on the frame at regular intervals 
    // to create illusion of movements of bae and balls.
    public void paint(Graphics g){
        super.paint(g);
        
        if(ingame){
            g.drawImage(ball.getImage(), ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight(), this);
            g.drawImage(base.getImage(), base.getX(), base.getY(), base.getWidth(),base.getHeight(),this);
            
            if(ctr1){
                // moment counter is set ball1 appears on screen.
                g.drawImage(ball1.getImage(), ball1.getX(), ball1.getY(), ball1.getWidth(), ball1.getHeight(), this);
            }
            if(ctr2){
                /*
                 * moment specific brick is hit and counter is 
                 * set ball2 will appear on the screen
                */
                g.drawImage(ball2.getImage(), ball2.getX(), ball2.getY(), ball2.getWidth(), ball2.getHeight(), this);
            }
            if(ctr3){
                /*
                 * moment specific brick is hit and counter is 
                 * set bomb will appear on the screen
                */
                g.drawImage(bomb.getImage(), bomb.getX(), bomb.getY(), bomb.getWidth(), bomb.getHeight(), this);
            }
             
            for(int i=0 ; i<40; i++){
                /**
                 * to draw only those bricks on the screen which are not destroyed
                 */
                if(!bricks[i].isDestroyed())
                    g.drawImage(bricks[i].getImage(), bricks[i].getX(), bricks[i].getY(), bricks[i].getWidth(), bricks[i].getHeight(), this);
            }
            g.setColor(Color.BLUE);
            // to show score and number of chances left with user
            g.drawString("your score:"+(county*10)+"   life left"+(life-1), 10, 9);
        } else {
            // to show message of game over or "you win" when game ends .                     
            g.setColor(Color.BLACK);
            g.drawString(message,(Commn.WIDTH)/2,(Commn.WIDTH/2));
                      
        }
       
    }
    
    /**
     * to keep track of key event and send it to base for movement.
     * @param e 
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
         base.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
       base.keyReleased(e);
    }
        
    // to run task regularly until game is over    
    class ScheduleTask extends TimerTask {
        public void run(){
            
            ball.move();
            base.move();
               if(ctr1){ // only when counter is set ball1 will move
                ball1.move();
            }
            if(ctr2){// only when counter is set ball2 will move
                ball2.move();
            }
            if(ctr3){// only when counter is set bomb will move
                bomb.move();
            }
            checkCollision();// to check collision
            repaint(); // paint() at regular intervals
         
        }
    }
    
    // gunction to set ingame to false and to stop game
    //condition : either base is hit with bomb or all bricks are boken
    //or number of life less than 0
    public void stopGame(){
        ingame = false;
        timer.cancel();
    }
    /**
     * to check collision between components ball , base , boundary and bricks
     */
    public void checkCollision(){
        
        if(ball.getRect().getMaxY()>Commn.BOTTOM){
            // if ball hits the bottom of arena life is reduced, total chances 3
                life--;
            if(life==0){stopGame(); // stop game when none life left and ball hits bottom
        }
            else{
            // if there is life left ball and base initialised again and drawn    
                base = new Base();
                ball = new Ball();
            }
                    
        }
       if((ctr1)&&(ball1.getRect().getMaxY()>Commn.BOTTOM)){
           //ctr set to false when ball1 reaches bottom of arena
           ctr1 = false ;
       }
          if((ctr2)&&(ball2.getRect().getMaxY()>Commn.BOTTOM)){
          //ctr set to false when ball2 reaches bottom of arena
            ctr2 = false;
        }
          if((ctr3)&&(bomb.getRect().getMaxY()>Commn.BOTTOM)){
          //ctr set to false when bomb reaches bottom of arena
            ctr3 = false;
        }
        
        for(int i =0,x=0;i<40;i++){
            // to keep track of number of bricks destroyed
            if(bricks[i].isDestroyed()){
                x++;
            }
            if(x>county){
                // to keep track of score.
                county = x;}
            if(x==40) {
                // when all the bricks destroyed player wins
                message = "YOU WON";
                stopGame();
            }
                    
        }
        if(ctr1){
            // if counter is set and ball1 hits base overloaded 
            //constructor is called which loads scaled down base
         if(ball1.getRect().intersects(base.getRect())){
            base = new Base(1);
          }
        }
          if(ctr2){
             // if counter is set and ball2 hits base overloaded 
            //constructor is called which loads scaled up base
         if(ball2.getRect().intersects(base.getRect())){
            base = new Base(2);
          }
          }
          if(ctr3){
            // if counter is set and bomb hits base stopGame() is called
         if(bomb.getRect().intersects(base.getRect())){
            stopGame();
          }
          }
         
        if(ball.getRect().intersects(base.getRect())){
            /**
             * here collision between base and ball is detected
             * and direction of the ball movement is set accordingly
             */
            int basePos = (int)base.getRect().getMinX();
            //keep track of leftmost x of base
            int ballLPos = (int)ball.getRect().getMinX();
            //keep track of leftmost x of ball
            int baseWidth = (int)base.getRect().getWidth();
            //keep track of width of base ,as base width will change 
            //as per collison with power balls
            
            /**
             * base is divided into 3 parts :
             * 1st part and 3rd part - when ball collides ball will
             * reverse the horizontal direction and vertical as well
             * 2nd part : ball will only revrse the vertical direction
             * while horizontal speed remains same direction
             */
            int first =  basePos+2;
            int second = basePos+(baseWidth-3);
            
            if(ballLPos<first){
                // 1st part
                ball.setXDir(-2);
                ball.setYDir(-2);
            }
            if((ballLPos >first)&&(ballLPos <= second)){
                // 2nd part
                if(ball.xdir == -2){
                    ball.setXDir(-2);
                    ball.setYDir(-2);
                }
                else if(ball.xdir == 2){
                    ball.setXDir(2);
                    ball.setYDir(-2);
                }
                else{
                ball.setYDir(-2);
            }
            }
             if(ballLPos > second){
                 //3rd part
                ball.setXDir(2);
                ball.setYDir(-2);
            }
            
      }
        /**
         * this part keep track of collision between ball and bricks
         * and set the movement accordingly and set the bricks to destroyed
         */    
        for(int i =0; i<40; i++){
            if((ball.getRect()).intersects(bricks[i].getRect())){
                /*
                 * to calculate left,height,topwidth of ball
                 */
                int ballLeft = (int)ball.getRect().getMinX();
                int ballHeight = (int)ball.getRect().getHeight();
                int ballWidth = (int)ball.getRect().getWidth();
                int ballTop = (int)ball.getRect().getMinY();
               /*
                * points are decided for left , top , right 
                * and bottom of the ball
                */
                Point pointRight = new Point(ballLeft+ballWidth+1,ballTop+(ballHeight/2));
                Point pointLeft = new Point(ballLeft -1,ballTop+(ballHeight/2));
                Point pointTop = new Point(ballLeft+(ballWidth/2),ballTop-1);
                Point pointBottom = new Point(ballLeft+(ballWidth/2),ballTop+ballHeight+1);
                
                //only when particular brick is not already destroyed
                if(!bricks[i].isDestroyed()){
                    if(i==17){
                        //when brick 17 is hit ball2 is intiialized
                    ball2 = new Ball2();
                    ctr2 = true;
                }
                if(i==19){
                    //when brick 19 is hit ball2 is intiialized
                    ball1 = new Ball1();
                    ctr1 = true;
                }
                if(i==28){
                    //when brick 28 is hit bomb is intiialized
                    bomb = new Bomb();
                    ctr3 = true;
                }
                    if(bricks[i].getRect().contains(pointRight)){
 //if brick is hit with right point of ball reverse direction in horizontal
                        ball.setXDir(-2);
                    }
                    
                    if(bricks[i].getRect().contains(pointTop)){
 //if brick is hit with top point of ball reverse direction in vertical
                        ball.setYDir(1);
                    }
                    if(bricks[i].getRect().contains(pointBottom))
                    {
//if brick is hit with bottom point of ball reverse direction in vertical
                        ball.setYDir(-2);
                    }
                    
                    else if(bricks[i].getRect().contains(pointLeft)){
//if brick is hit with left point of ball reverse direction in horizontal
                        ball.setXDir(2);
                    }
                  // set brick as destroyed  
                    bricks[i].setDestroyed(true);
                }
               
            }
        }
        
    }
}
