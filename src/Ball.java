/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import javax.swing.ImageIcon;
/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class Ball extends Graphc implements Commn {
    
    private String ball = "/images/ball.png"; //address to ball graphic
    protected int xdir;      
    // to keep track of movement in x and y directions
    protected int ydir;
        
    public Ball(){  //constructor for intialization
        xdir =  2;
        ydir = -2;
        
        ImageIcon img = new ImageIcon(this.getClass().getResource(ball));
        image = img.getImage();
        
        height = image.getHeight(null);
        width = image.getWidth(null);
               
        resetState();
    }
    
    public void move(){
        x += xdir;
        y += ydir;
        /**
         * if x coordinate reaches left side of screen 
         * we will reverse the direction in horizontal direction
         * + - in right hand direction
         * - for left side
         * speed can be varied , I have used 2 , to slow down game 
         * speed can be set to 1
         */
        if(x<=1){
            setXDir(2);
        }
        /**
         * if x coordinate reaches left side of screen 
         * again reverse the direction in horizontal
         */
       if(x == BALL_RIGHT){ 
                      setXDir(-2); 
          }
        /**
         * if ball reaches top off the screen reverse 
         * movement in vertical
         */
        if(y<=5){
            setYDir(2);
        }
    }
    
    public void resetState(){
        x = 230;
        y = 340;
    }
    /**
     * setXDir and setYDir are used to set the
     * direction of movement after collision on boundaries 
     * or bricks or base
     * */
    public void setXDir(int x){
        xdir = x;
    }
    
    public void setYDir(int y){
        ydir = y;
    }
    
    public int getYDir(){
        return ydir;
    }    
}
