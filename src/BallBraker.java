/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import javax.swing.JFrame;
/**
 *Gameloft project for hiring 
 * @author harshit
 * email - hrsht.sarma@gmail.com
 * OS used : Ubuntu 11.04, IDE used: NetBeans 7.1.2
 */
public class BallBraker extends JFrame {
    
    public BallBraker(){
        add(new Arena());
        setTitle("Game-loft: Ballbraker");
        // to set title on frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(Commn.WIDTH,Commn.HEIGHT);
        // to set size of the frame
        setLocationRelativeTo(null);
        setIgnoreRepaint(true);
        setResizable(false);
        /**
         * game is specific with width and height as used in logic
         * for collision detection and to limit the bounds for movement
         * of base and ball
* */
        setVisible(true);
    }
    //main function to start the execution
    public static void main(String[] args){
        new BallBraker();
    }

}
