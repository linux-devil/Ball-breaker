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
public class Bomb extends Graphc implements Commn {
     
    /**Most dangerous :
     * this class is for bomb which will end the game on collision
     */
    protected int ydir;
    private String bomb = "/images/bomb.png";
   
    public Bomb(){
        //constructor called to load image
        ydir= 1;
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bomb));
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
            // coordinate of the brick[28] is calculated which
         //hold this power
        x = 190;
        y = 110;
    }
    

}
