/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypainter;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author junwu
 */
public class SelectionOutline {
    int deltaSize=10;
    easyOBJ parent;
    Point lp=null,cp=null;
    Panel Ecp, Wcp, Scp, Ncp, NEcp, SEco, NWcp, SWcp;
    
    
    SelectionOutline(easyOBJ p)
    {
        parent = p;
        Ecp=new Panel();
        Ecp.setBackground(Color.red);
        Ecp.setSize(deltaSize,deltaSize);
        Ecp.setVisible(false);
      //  parent.parent.add(Ecp);
      
        Ecp.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("SEL.."+parent.status);
                if((parent.status==Status.Ready2Resize)||(parent.status==Status.Resizing))
                {              
                    if(cp==null)
                        cp=new Point();
                    cp.x = e.getXOnScreen();
                    cp.y = e.getYOnScreen();
                    Dimension os=parent.getSize();
                    os.width+=(cp.x-lp.x);
//                    parent.outline.setVisible(false);
                    parent.setSize(os);
//                    parent.outline.setVisible(true);
                    parent.status=Status.Resizing;
                    lp.x=cp.x;
                    lp.y=cp.y;
                }
            }
        });
        
        Ecp.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("SEL.."+parent.status);
                if(lp==null)
                    lp = new Point();
                
                lp.x = e.getXOnScreen();
                lp.y = e.getYOnScreen();
                parent.status = Status.Ready2Resize;
            }
            
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("SEL.."+parent.status);
                if((parent.status==Status.Resizing)||(parent.status==Status.Ready2Resize))
                {
                    parent.status=Status.Activated;
                }
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
                       d.width+2*deltaSize, d.height+2*deltaSize);
            System.out.print("show(" + (d.width+2*deltaSize) + ")");
            Ecp.setLocation(p.x+d.width+deltaSize-deltaSize/2,
                            p.y+d.height/2-deltaSize/2);
            
            parent.parent.add(Ecp);
            Ecp.setVisible(true);
        }
        else
        {
            Graphics g = parent.parent.getGraphics();
            g.setXORMode(Color.yellow);
            Dimension d=parent.getSize();
            Point p=parent.getLocation();
            
            g.drawRect(p.x-deltaSize, p.y-deltaSize, 
                       d.width+2*deltaSize, d.height+2*deltaSize);
            System.out.println("hide(" + (d.width+2*deltaSize) + ")");
            
            parent.parent.remove(Ecp);
            //Ecp.setVisible(false);
        }
    }
    
}
