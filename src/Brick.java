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
public class Brick extends Graphc {
    
    private String brickie = "/images/brickie.png";
    boolean destroyed;
    
    public Brick(int x, int y){
        // for intialization of brick called from arena file
        this.x = x;
        this.y = y;
        
       ImageIcon ii = new ImageIcon(this.getClass().getResource(brickie));
       image = ii.getImage();
        
        width = image.getWidth(null);
        height = image.getHeight(null);
        destroyed = false;
        
    }
    
    // to keep track of wether the brick is destroyed
    public boolean isDestroyed(){
        return destroyed;
    }
    // to set destroy counter to true when brick is destroyed
    public void setDestroyed(boolean destroyed){
        this.destroyed = destroyed;
    }

}
