/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  //ImageIcon

/**
 *
 * @author angus
 */
public class MainWindow extends JFrame{  //用extends 去繼承 Frame
    //呈現視窗裡面的一些內容(功能表)
    
    MainWindow(EasyPainter ep){
            
            this.setLocation(400, 30);
            this.setSize(600, 500);
            this.setBackground(Color.white);
            this.setTitle(ep.swTitle + " version " + ep.version);
            this.setLayout(new BorderLayout()); //可有可無
//            Label label = new Label("JLabel");
//            this.getContentPane().add(BorderLayout.CENTER , label);
            
            
            //關閉的語法
            this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    System.exit(0);
                }

            });
                  
            this.setVisible(true);
           
    }
    
    //新增工具列
    void setToolBar(ToolBar tb){        
        this.add(tb, BorderLayout.SOUTH);        
    }
    
    //訊息通知列
    void setMessageBar(MessageBar mb){
        this.add(mb, BorderLayout.NORTH);
    }
         
}