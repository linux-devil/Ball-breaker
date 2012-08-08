/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;


import java.awt.Image;
import java.awt.Rectangle;

/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class Graphc {
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    protected Image image;
    /**
     * Instance variables and methods used in this class are common to
     * base , ball , brick classes. Mentioned classes will extend this class
     * to use the variables and functions in this class [more OOP].
     * @return 
     */
        
    public int getWidth(){
        return width;       //to return width of the object figure(either base,ball or brick)
    }
    
    public int getHeight(){
        return height;      //to return height of the object figure(either base,ball or brick)
    }
    
    Image getImage(){
        return image;       // to return image of type Image.
    }
    
    Rectangle getRect(){
        return new Rectangle(x,y,image.getWidth(null),image.getHeight(null));
               /**
                * calling constructor to return Rectangle formed by specified 
                * coordinates in the parameter. 
    */}
    
    public void setX(int x){
        this.x=x;               // to set x coordinate of the calling object as per the parameter passed
    }
    
    public int getX(){
        return x;               // to return x coordinate of the calling object .
    }
    
     public void setY(int x){
        this.y=y;               // to set y coordinate of the calling object as per the parameter passed
    }
    
    public int getY(){
        return y;               // to return y coordinate of the calling object .
    }
    
}
