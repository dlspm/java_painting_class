/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author angus
 */
public class easyOBJ extends Panel{
    
    easyOBJ(Point sp, int w, int h){
    
        this.setSize(w,h);
        this.setLocation(sp);
//        this.setBackground(Color.red);
    
    }
    
    public void paint(Graphics g){  //記錄Line
        
        int x, y, w, h; 
//        x = (this.getLocation()).x ;
//        y = (this.getLocation()).y ;
        w = (this.getSize()).width ;
        h = (this.getSize()).height ;
        g.setColor(Color.black);
        
        g.drawRect(0, 0, w-2, h-2);
    }
}
