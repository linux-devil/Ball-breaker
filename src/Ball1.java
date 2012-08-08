/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class Ball1 extends Graphc implements Commn{
    /**
     * this class is for power ball which will reduce the size of
     * base on collision
     */
    protected int ydir;
    private String ball1 = "/images/ball1.png";
    
    public Ball1(){
        //constructor called to load image
        ydir= 1;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ball1));
      // Image image = new ImageIcon(ball1).getImage();
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
         // coordinate of the brick[19] is calculated which
         //hold this power
        x = 150;
        y = 100;
    }
}
