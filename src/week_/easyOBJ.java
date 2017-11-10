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
    
    Status status;
    
    easyOBJ(Page p, Point sp, int w, int h){
        
        status = Status.Activated; //設定狀態
        
        
        
        parent = p;
        this.setSize(w,h);
        this.setLocation(sp);
//        this.setBackground(Color.red);


        this.outline = new SelectionOutline(this);  //美新增一個物件就會
        this.outline.setVisible(true);
        

        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){
                System.out.println("mousePressed in easyObJ");
                if(status == Status.Inactivated){//有作用中的物件存在
                    
                    
                        if(parent.activeOBJ != null){
                            parent.activeOBJ.outline.setVisible(false);
                        }
                        
                        outline.setVisible(true);
                        status = Status.Activated;

                        parent.activeOBJ = easyOBJ.this; //當從 inactivated 回到 activted 要更改的
                    }
                }
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
