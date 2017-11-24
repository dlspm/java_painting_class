/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypainter;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

/**
 *
 * @author junwu
 */


public class Page extends Panel {
    
    Color pageColors[] = {Color.white, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK};
    public static int id=0;
    Point lp, cp, fp;
    public Vector<Line> lines=null;
    public Status status;
    public easyOBJ activeOBJ=null;

    
    Page()
    {
        this.setLayout(null);
        status=Status.Selection;
        lines = new Vector<Line>();
        this.setBackground(pageColors[id++]);
        this.addMouseMotionListener( new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                System.out.println("mouse dragged");
                
                if(Page.this.status == Status.Drawing)
                {
                    cp=e.getPoint();
                    Graphics g = Page.this.getGraphics();
                    g.drawLine(lp.x, lp.y, cp.x, cp.y);
                    Page.this.lines.add( new Line(lp, cp));
                    lp=cp;
                }
                else if(Page.this.status == Status.CreatingOBJ)
                {
                    Graphics g = Page.this.getGraphics();
                    g.setXORMode(Color.red);
                    if(cp!=null)
                    {
                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y -fp.y);
                    }
                    cp=e.getPoint();
                    g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y -fp.y);
                    
                }
            }
        });
        
        this.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                System.out.println("mouse pressed");
                if(Page.this.status == Status.Drawing)
                {
                    lp=e.getPoint();
                }
                else if(Page.this.status == Status.CreatingOBJ)
                {
                    fp=e.getPoint();
                    cp=null;
                }
                
                if(Page.this.activeOBJ!=null)
                {
                    System.out.println("here");
                    if(Page.this.activeOBJ.status==Status.Activated)
                    {
                        Page.this.activeOBJ.outline.setVisible(false);
                        Page.this.activeOBJ.status=Status.Inactivated;
                        Page.this.activeOBJ=null;
                    }
                }
            }
            public void mouseReleased(MouseEvent e)
            {
                System.out.println("mouse released");
                if(Page.this.status == Status.CreatingOBJ)
                {
                    Graphics g = Page.this.getGraphics();
                    g.setXORMode(Color.red);
                    if(cp!=null)
                    {
                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y -fp.y);
                    }
                    if(cp!=null)
                    {   
                        if(((cp.x-fp.x)>10)&&((cp.y-fp.y)>10))
                        {
                            easyOBJ newOBJ = new easyOBJ(Page.this, fp,cp.x-fp.x, cp.y-fp.y );
                            Page.this.add(newOBJ);
                            Page.this.activeOBJ=newOBJ;
                        }
                        cp=null;
                    }
                }
              /*  if(Page.this.status == Status.Drawing)
                {
                    Page.this.status=Status.Selection;
                } */ 
            }
        });    
    }
    
    
    public void paint(Graphics g)
    {
        for(int i=0;i< this.lines.size();i++)
        {
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
        }
    }
    
}
