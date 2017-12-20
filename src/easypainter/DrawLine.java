/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypainter;


import java.awt.*;

import java.awt.geom.Line2D;
/**
 *
 * @author angus
 */
 
public class DrawLine extends easyOBJ{
    
    public DrawLine(Page p, Point sp, int w, int h) {
        super(p, sp, w, h);
        parent = p;
    }
    
    protected Line2D.Double makeLine(Point p1, Point p2)
    {
        System.out.println("Oval1"+parent.fp+ "," + parent.cp);
        final int x = Math.min(p1.x, p2.x);   
        final int y = Math.min(p1.y, p2.y);
        final int width = Math.abs(p1.x - p2.x);
        final int height = Math.abs(p1.y - p2.y);
        return new Line2D.Double(x, y, width, height);
    }
    
    public void paintComponent(Graphics g)
    {
//        Graphics2D g2d = (Graphics2D)g;
//        g2d.setPaint(Color.BLUE);
        System.out.println("Oval2"+parent.fp+ "," + parent.cp);
//        g2d.draw(makeOval(parent.fp, parent.cp));
        
      int w,h;
      w = (this.getSize()).width;
      h = (this.getSize()).height;
      g.setColor(Color.black);
      g.drawOval(0, 0, w-1, h-1);
        parent.cp = null;
        System.out.println("Oval3" + parent.fp + "," + parent.cp);

    }
    
}
