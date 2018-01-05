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
public class MainWindow extends Frame {
    MainWindow(EasyPainter ep)
    {
        this.setBackground(Color.yellow);
        this.setSize(600, 500);
        this.setLocation(100, 100);

        this.setTitle(ep.swTitle + " version " + ep.version);

        this.setLayout(new BorderLayout());
       // this.setVisible(true);
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    void setMessageBar(MessageBar mb)
    {
        this.add(mb, BorderLayout.SOUTH);
    }
    
    void setToolBar(ToolBar tb)
    {
        this.add(tb,BorderLayout.NORTH);
    }

    void getRootPane(Page aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
