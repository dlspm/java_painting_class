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
public class easyOBJ extends Panel {
    
    Page parent;
//    SelectionOutline outline=null;
    Status status;
    Point op,lp=null,cp=null;
    Dimension d;
    
    easyOBJ(Page p, Point sp, int w, int h)
    {// sp 是第一點
        super();
        status=Status.Activated;
        parent = p;
        this.setSize(w,h);
        this.setLocation(sp);
//        this.outline = new SelectionOutline(this);
       // this.outline.setVisible(true);
        
        System.out.println("easyOBJ");
        
       // this.setBackground(Color.red);

        this.addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent e)
            {
                //Graphics g = parent.getGraphics();
                //g.setXORMode(Color.yellow);
                //g.drawRect(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y),
                //                d.width-1, d.height-1);
                System.out.println("easD" + parent.activeOBJ.status);
                System.out.println("easD" + status);
                if(cp==null)
                   cp = new Point();
                // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                cp.x = e.getXOnScreen();
                cp.y = e.getYOnScreen();
                //     g.drawRect(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y),
                //                d.width-1, d.height-1);
                if(op==null) op=new Point();
                op.x = op.x + (cp.x-lp.x);
                op.y = op.y + (cp.y-lp.y);
                easyOBJ.this.setLocation(op);
//                easyOBJ.this.setLocation(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y));
                lp.x=cp.x;
                lp.y=cp.y;

            }
        }
        );
        this.addMouseListener(new MouseAdapter()
        {
             public void mousePressed(MouseEvent e)
             {
                 System.out.println("mouse pressed in easyOBJ");
                 if(status==Status.Inactivated)
                 { //第一下先選擇才變 Activated
//                    System.out.println("1" + parent.activeOBJ.status);
                     if(parent.activeOBJ!=null)
                     {
                       //  parent.activeOBJ.outline.setVisible(false);
                         parent.activeOBJ.status=Status.Inactivated;
                     }
                     
                    // outline.setVisible(true);
                     status=Status.Activated;
                     parent.activeOBJ=easyOBJ.this; //更改物件
                     parent.repaint();
                     System.out.println("1" + parent.activeOBJ.status);
                 }
                 else if(status==Status.Activated)
                 { //選到了知道第二次才開始移動
                     System.out.println("2" + parent.activeOBJ.status);
                    // outline.setVisible(false);
                     //setVisible(false);
                     
                    // Graphics g = parent.getGraphics();
                    // g.setXORMode(Color.yellow);
                     if(lp==null)
                         lp=new Point();
                     // getXOnScreen() 與 getYOnScreen() 印出在螢幕中點擊的座標
                     lp.x = e.getXOnScreen();
                     lp.y = e.getYOnScreen();
                     op = easyOBJ.this.getLocation();
                    // d = easyOBJ.this.getSize();
                    // System.out.println(fp.toString());
                    // System.out.println(d.toString());
                    // g.drawRect(op.x, op.y, d.width-1, d.height-1);
                   //  g.drawRect(op.x-1, op.y-1, d.width+1, d.height+1);
                    //g.drawRect(100,100,300,300);
                    // cp=fp;
                     
                     parent.status=Status.MovingOBJ;
                     status=Status.Moving;
                     //setVisible(false);
                     System.out.println("2" + parent.activeOBJ.status);
                 }
             }
             
             public void mouseReleased(MouseEvent e)
             {
                 System.out.println("mouse released in easyOBJ");
                 if(status==Status.Moving)
                 {
                   //  Graphics g = parent.getGraphics();
                   //  g.setXORMode(Color.yellow);
                   //  g.drawRect(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y),
                   //             d.width-1, d.height-1);
                     
                   //  setLocation(op.x+(cp.x-fp.x), op.y+(cp.y-fp.y));
                     
                     
                   //  setVisible(true);
                   //  outline.setVisible(true);
                     status=Status.Activated;
                 }
             }
        });


    }
    
    public void selected()
    {
//        if(outline==null)
//        {
//            outline = new SelectionOutline(this);
//        }
//        outline.setVisible(true);
    }
   /* 
    public void paint(Graphics g)
    {
      int w,h;
      w = (this.getSize()).width;
      h = (this.getSize()).height;
      g.setColor(Color.black);
//      g.drawRect(0, 0, w-1, h-1);
      g.drawRect(0, 0, w-1, h-1);
    }*/ 
}
