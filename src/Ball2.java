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
public class Ball2 extends Graphc implements Commn{
    /**
     * this class is for power ball which will increase the size of
     * base on collision
     */
    protected int ydir;
    private String ball2 = "/images/ball2.png";
    
    public Ball2(){
     
        //constructor called to load image
        ydir= 1;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ball2));
        image = ii.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        
        resetState();
     }
    // function to move ball only in vertical direction
    public void move(){
        y += ydir;
     }
     public void resetState(){
            // coordinate of the brick[17] is calculated which
         //hold this power
        x = 70;
        y = 100;
    }

}
