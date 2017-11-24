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
    int deltaSize=8;
    easyOBJ parent;
    Panel Ecp, Wcp, Scp, Ncp, NEcp, SEco, NWcp, SWcp;
    
    
    SelectionOutline(easyOBJ p)
    {
        parent = p;
        Ecp=new Panel();
        Ecp.setBackground(Color.red);
        Ecp.setSize(deltaSize,deltaSize);
        Ecp.setVisible(false);
        parent.parent.add(Ecp);
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
            Ecp.setVisible(false);
        }
    }
    
}
