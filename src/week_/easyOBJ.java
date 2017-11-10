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
    Page parent;
    SelectionOutline outline = null;
    //每一個
    
    
    easyOBJ(Page p, Point sp, int w, int h){
        parent = p;
        this.setSize(w,h);
        this.setLocation(sp);
//        this.setBackground(Color.red);

        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){
                System.out.println("mousePressed in easyObJ");
            }
            
            public void mouseReleased(MouseEvent e){
                System.out.println("mouseReleased in easyObJ");
            }
        });
    }
    
    public void selected(){  //選取物件
        if(outline == null){
        
            outline = new SelectionOutline(this); //要把 Page 傳進去，不然沒辦法畫在 Page 上面
        }
        outline.setVisible(true);
    }
    
    
    public void paint(Graphics g){  //記錄Line
        
        int x, y, w, h; 
        w = (this.getSize()).width ;
        h = (this.getSize()).height ;
        g.setColor(Color.black);
        
        g.drawRect(0, 0, w-1, h-1); //100(0-99)
    }
}
