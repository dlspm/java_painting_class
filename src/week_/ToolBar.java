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
public class ToolBar extends Panel {
    ToolBar(EasyPainter ep)
    {
        this.setBackground(Color.red);
        this.setLayout(new FlowLayout());
        Button newPageBtn = new Button("New Page");
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                
                if(ep.activePage!=null)
                {
                    ep.mainWin.remove(ep.activePage);
                }
                
                ep.activePage = new Page();
                
                ep.pages.add(ep.activePage);
                
                ep.mainWin.add(ep.activePage, BorderLayout.CENTER);
                //ep.mainWin.setVisible(false);
                ep.mainWin.setVisible(true);
                
                ep.numPages++;
                ep.curPage++;
                ep.megBar.updateInfo(ep.curPage, ep.numPages);
                
                
            }
        });
        
        Button prevPageBtn = new Button("Previous Page");
        this.add(prevPageBtn);
        prevPageBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                ep.mainWin.remove(ep.activePage);
                ep.activePage = ep.pages.elementAt(ep.pages.indexOf(ep.activePage)-1);
                ep.mainWin.add(ep.activePage);
                ep.megBar.updateInfo(--ep.curPage, ep.numPages);
            }
        });

        Button penBtn = new Button("Pen");
        this.add(penBtn);
        penBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                System.out.println("pen tool selected");
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.Drawing;
                }
            }
        });

        Button selectBtn = new Button("Selection");
        this.add(selectBtn);
        selectBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.Selection;
                }
            }
        });

        
        Button creatOBJBtn = new Button("Creat Object");
        this.add(creatOBJBtn);
        creatOBJBtn.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(ep.activePage!=null)
                {
                    ep.activePage.status = Status.CreatingOBJ;
                }
            }
        });

        
    }
}
