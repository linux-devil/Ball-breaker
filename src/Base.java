/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class Base extends Graphc implements Commn{
    private String base = "/images/paddle.png";
    private String base1 = "/images/paddle1.png";
    private String base2 = "/images/paddle2.png";
    int dx;    
   
      public Base(int a){
         if(a ==1){
           ImageIcon img = new ImageIcon(this.getClass().getResource(base1));
           image = img.getImage();
           resetState(a);
       }
       else if(a==2) {
           ImageIcon img = new ImageIcon(this.getClass().getResource(base2));
           image = img.getImage();
           resetState(a);
       }
       else{
           ImageIcon img = new ImageIcon(this.getClass().getResource(base));
           image = img.getImage();
           resetState(0);
       }
        width = image.getWidth(null);
        height = image.getHeight(null);
      
      }
      
      public Base(){
          this(0);
      }
      
    
    public void move(){
        x += dx;
        if(x <= 2)
            x =2;
        if(x >= Commn.BASE_RIGHT){
            x = Commn.BASE_RIGHT;
        }}
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT){
            dx = -2;
        }
        if(key == KeyEvent.VK_RIGHT){
            dx = 2;
        }
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT){
            dx = 0;
        }
        
        if(key == KeyEvent.VK_RIGHT){
            dx = 0;
        }
    }
    
    public void resetState(int a){
       if(a==0){
           x = 200;
           y = 350;
       }
       if(a==1){y= 350;
            x = 150;
       }
       if(a==2){ 
           y= 350;
           x =  70;
       }
    }

}
