/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;

import java.awt.*;
import java.awt.event.*;

//當選下物件時，顯示物件外框

public class SelectionOutline {
    
    int deltaSize = 8;
    
    easyOBJ parent;
    
    
    SelectionOutline(easyOBJ p){  //因為是在 easyOBJ 呼叫 SelectionOutline，所以會傳入的 this 是 easyOBJ 型態
        parent = p;
    }
    
    
    public void setVisible(boolean b){
    
        if(b){
            //在 Page 裡面畫框
            //1. 需要先知道物件在哪裡, 有大小多大
            
            Graphics g = parent.parent.getGraphics();
//            g.setColor(Color.red);
            g.setXORMode(Color.yellow);
            //兩個向量寬,高
            Dimension d = parent.getSize();
            Point p = parent.getLocation();
            
            g.drawRect(p.x-deltaSize, p.y-deltaSize, d.width+deltaSize * 2-1, d.height+deltaSize * 2-1);
        
        }else{
            Graphics g = parent.parent.getGraphics();
//            g.setColor(Color.red);
            g.setXORMode(Color.yellow);
            //兩個向量寬,高
            Dimension d = parent.getSize();
            Point p = parent.getLocation();
            
            g.drawRect(p.x-deltaSize, p.y-deltaSize, d.width+deltaSize * 2-1, d.height+deltaSize * 2-1);
        
            
        
        }
    
    
    }
    
}
