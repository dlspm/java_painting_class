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
 * @author junwu
 */
public class SelectionOutline {
    int deltaSize=8;
    easyOBJ parent;
    Panel Ecp, Wcp, Scp, Ncp, NEcp, SEco, NWcp, SWcp;
    Point lp=null,cp=null;
    
    SelectionOutline(easyOBJ p)
    {
        parent = p;
        Ecp=new Panel();
        Ecp.setBackground(Color.red);
        Ecp.setSize(deltaSize,deltaSize);
        Ecp.setVisible(false);
//        parent.parent.add(Ecp);
        Ecp.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                
                System.out.println("----");
                
                if(lp == null)
                    lp = new Point(); // 代表完全沒有 新增過
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                parent.status = Status.Ready2Resize;  //1. 進入 ready2reasize 狀態
            }
            public void mouseReleased(MouseEvent e){
            
                if((parent.status == Status.Resizing)||(parent.status == Status.Ready2Resize)){
                    parent.status = Status.Activated ; //回到 Activated 下次才能再拖曳
                }
            }
        });

        Ecp.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent e){
                
                if((parent.status == Status.Ready2Resize)||(parent.status == Status.Resizing)){ // 改斃了裡面的元件大小，外框還沒更改
                    if(cp == null)
                        cp = new Point();
                    cp.x = e.getXOnScreen();
                    cp.y = e.getYOnScreen();
                    Dimension os = parent.getSize();
                    
                    parent.outline.setVisible(false);
                    parent.setSize(os.width + (cp.x - lp.x), os.height);
                    parent.outline.setVisible(true);
                    parent.status = Status.Resizing; //下一次如果又發生 Dragged
                    lp.x = cp.x;
                    lp.y = cp.y;
                    
                }
                
                if(lp == null)
                    lp = new Point(); // 代表完全沒有 新增過
                    
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                
                parent.status = Status.Ready2Resize;  //1. 進入 ready2reasize 狀態
            
            }
        
            
        });
    }
    
    public void setVisible(boolean b)
    {
        if(b)
        {
            Graphics g = parent.parent.getGraphics();
            g.setXORMode(Color.yellow);
            Dimension d=parent.getSize();
            Point p=parent.getLocation();
            g.drawRect(p.x-deltaSize, p.y-deltaSize, 
                       d.width+2*deltaSize-1, d.height+2*deltaSize-1);
            Ecp.setLocation(p.x+d.width-1+deltaSize-deltaSize/2,
                            p.y+d.height/2-1-deltaSize/2);
            
            parent.parent.add(Ecp);  //需要時再加進去並顯示
            Ecp.setVisible(true);
        }
        else
        {
            Graphics g = parent.parent.getGraphics();
            g.setXORMode(Color.yellow);
            Dimension d=parent.getSize();
            Point p=parent.getLocation();
            g.drawRect(p.x-deltaSize, p.y-deltaSize, 
                       d.width+2*deltaSize-1, d.height+2*deltaSize-1);
            parent.parent.remove(Ecp); //刪除他不然會在 Paint 佔位置
//            Ecp.setVisible(false);
        }
    }
    
}
