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
public class easyOBJ extends Panel {
    
    Page parent;
    SelectionOutline outline=null;
    Status status;
    Point op,fp,cp;
    Dimension d;
    
    easyOBJ(Page p, Point sp, int w, int h)
    {
        status=Status.Activated;
        parent = p;
        this.setSize(w,h);
        this.setLocation(sp);
        this.outline = new SelectionOutline(this);
        this.outline.setVisible(true);
        
        
//        this.setBackground(Color.red);

        this.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                     Graphics g = parent.getGraphics();
                     g.setXORMode(Color.yellow);
                     g.drawRect(op.x-1+(cp.x-fp.x), op.y-1+(cp.y-fp.y),
                                d.width+1, d.height+1);
                     
                     cp = e.getPoint();
                     g.drawRect(op.x-1+(cp.x-fp.x), op.y-1+(cp.y-fp.y),
                                d.width+1, d.height+1);
                     

            }
        }
        );
        this.addMouseListener(new MouseAdapter()
        {
             public void mousePressed(MouseEvent e)
             {
                 System.out.println("mouse pressed in easyOBJ");
                 if(status==Status.Inactivated)
                 {
                     if(parent.activeOBJ!=null)
                     {
                         parent.activeOBJ.outline.setVisible(false);
                         parent.activeOBJ.status=Status.Inactivated;
                     }
                     
                     outline.setVisible(true);
                     status=Status.Activated;
                     parent.activeOBJ=easyOBJ.this;
                 }
                 else if(status==Status.Activated)
                 {
                     setVisible(false);
                     outline.setVisible(false);
                     
                     Graphics g = parent.getGraphics();
                     g.setXORMode(Color.yellow);
                     
                     fp = e.getPoint();
                     op = easyOBJ.this.getLocation();
                     d = easyOBJ.this.getSize();
                     System.out.println(fp.toString());
                     System.out.println(d.toString());
                     g.drawRect(op.x-1, op.y-1, d.width+1, d.height+1);
                    //g.drawRect(100,100,300,300);
                     cp=fp;
                     
                     parent.status=Status.MovingOBJ;
                     status=Status.Moving;
                 }
             }
             
             public void mouseReleased(MouseEvent e)
             {
                 System.out.println("mouse released in easyOBJ");
                 if(status==Status.Moving)
                 {
                     Graphics g = parent.getGraphics();
                     g.setXORMode(Color.yellow);
                     g.drawRect(op.x-1+(cp.x-fp.x), op.y-1+(cp.y-fp.y),
                                d.width+1, d.height+1);
                     
                     setLocation(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y));
                     
                     
                     setVisible(true);
                     outline.setVisible(true);
                     status=Status.Activated;
                 }
             }
        });


    }
    
    public void selected()
    {
        if(outline==null)
        {
            outline = new SelectionOutline(this);
        }
        outline.setVisible(true);
    }
    
    public void paint(Graphics g)
    {
      int w,h;
      w = (this.getSize()).width;
      h = (this.getSize()).height;
      g.setColor(Color.black);
      g.drawRect(0, 0, w-1, h-1);
    } 
}
