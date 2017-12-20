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
public class ControlPoints {
    
    Panel E, S, W, N, NW, SW, NE, SE;
    Page parent;
    Status old;
    Point p1=null,p2=null;
    
    ControlPoints(Page p)
    {
        
        parent = p;
        
        E = new Panel();
        S = new Panel();
        W = new Panel();
        N = new Panel();
        NW = new Panel();
        SW = new Panel();
        NE = new Panel();
        SE = new Panel();

        E.setBackground(Color.red);
        S.setBackground(Color.red);
        W.setBackground(Color.red);
        N.setBackground(Color.red);
        NW.setBackground(Color.red);
        SW.setBackground(Color.red);
        NE.setBackground(Color.red);
        SE.setBackground(Color.red);
        
        E.setSize(9,9);
        S.setSize(9,9);
        W.setSize(9,9);
        N.setSize(9,9);
        NW.setSize(9,9);
        SW.setSize(9,9);
        NE.setSize(9,9);
        SE.setSize(9,9);
        
        parent.add(E);
        parent.add(S);
        parent.add(W);
        parent.add(N);
        parent.add(NW);
        parent.add(SW);
        parent.add(NE);
        parent.add(SE);
        
        
        
        E.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                old = parent.activeOBJ.status;
                parent.activeOBJ.status = Status.Ready2Resize;
                if(p1==null)
                    p1=new Point();
                p1.x = e.getXOnScreen();
                p1.y = e.getYOnScreen();
            }

            public void mouseReleased(MouseEvent e)
            {
                parent.activeOBJ.status = old;
            }
        });
        
        E.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("Cont.."+parent.activeOBJ.status);
                parent.activeOBJ.status = Status.Resizing;
                if(p2==null)
                    p2 = new Point();
                p2.x = e.getXOnScreen();
                p2.y = e.getYOnScreen();
                
                Dimension OBJsize = parent.activeOBJ.getSize();
                OBJsize.width += (p2.x-p1.x); 
                //OBJsize.height+= (p2.y-p1.y);
                parent.activeOBJ.setSize(OBJsize);
                //p1=(Point)p2.clone();
                
                p1.x=p2.x;
                p1.y=p2.y;
               
            }
        });
        
        SE.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("Cont.."+parent.activeOBJ.status);
                old = parent.activeOBJ.status;
                parent.activeOBJ.status = Status.Ready2Resize;
                if(p1==null)
                    p1=new Point();
                p1.x = e.getXOnScreen();
                p1.y = e.getYOnScreen();
            }

            public void mouseReleased(MouseEvent e)
            {
                parent.activeOBJ.status = old;
            }
        });
        
        SE.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                parent.activeOBJ.status = Status.Resizing;
                if(p2==null)
                    p2 = new Point();
                p2.x = e.getXOnScreen();
                p2.y = e.getYOnScreen();
                
                Dimension OBJsize = parent.activeOBJ.getSize();
                OBJsize.width += (p2.x-p1.x); 
                OBJsize.height+= (p2.y-p1.y);
                parent.activeOBJ.setSize(OBJsize);
                p1=(Point)p2.clone();
            }
        });
        
        
    }
    
    void setVisible(boolean b)
    {
        E.setVisible(b);
        N.setVisible(b);
        W.setVisible(b);
        S.setVisible(b);
        NW.setVisible(b);
        NE.setVisible(b);
        SW.setVisible(b);
        SE.setVisible(b);
        
    }
    
    void setLocations()
    {
        
        Point p=parent.activeOBJ.getLocation();
        Dimension d=parent.activeOBJ.getSize();
        
        NW.setLocation(p.x-9, p.y-9);
        N.setLocation( p.x+d.width/2-4, p.y-9);
        NE.setLocation(p.x+d.width+1, p.y-9);
        E.setLocation(p.x+d.width+1, p.y+d.height/2-4);
        SE.setLocation(p.x+d.width+1, p.y+d.height+1);
        S.setLocation(p.x+d.width/2-4, p.y+d.height+1);
        SW.setLocation(p.x-9, p.y+d.height+1);
        W.setLocation(p.x-9, p.y+d.height/2-4);
    }
    
    
}

/*
class ControlPointMouseListener implements MouseListener
{
}
*/