/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;
import java.util.Vector;

/**
 *
 * @author junwu
 */
public class EasyPainter {
    public String swTitle="EP - Easy Painter";
    public String version="0.1";
    public MainWindow mainWin;
    public MessageBar megBar;
    public ToolBar toolBar;
    public int numPages=0;
    public int curPage=0;
    public Page activePage=null;
    public Vector<Page> pages=null;
    
    EasyPainter()
    {
        init();
    }
    
    public void init()
    {
        pages = new Vector<Page>();
                
        mainWin = new MainWindow(this);
        toolBar = new ToolBar(this);
        mainWin.setToolBar(toolBar);
        //mainWin.setVisible(false);
        megBar = new MessageBar(this);
        mainWin.setMessageBar(megBar);
        
        mainWin.setVisible(true);
    }
}
