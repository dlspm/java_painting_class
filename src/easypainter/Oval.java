/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypainter;

import java.awt.*;

/**
 *
 * @author junwu
 */
public class Oval extends easyOBJ {
    
    public Oval(Page p, Point sp, int w, int h) {
        super(p, sp, w, h);
    }
    
    public void paint(Graphics g)
    {
      int w,h;
      w = (this.getSize()).width;
      h = (this.getSize()).height;
      g.setColor(Color.black);
      g.drawOval(0, 0, w-1, h-1);
    }
    
}
