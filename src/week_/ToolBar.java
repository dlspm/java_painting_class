/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author angus
 */
public class ToolBar extends Panel{
    ToolBar(EasyPainter ep){ //工具列
        
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
//        ep.activatePage = new Page();
//        ep.pages.add(ep.activatePage);
//        ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間

        Button previousPageBtn = new Button("上一頁");
        previousPageBtn.setVisible(false);
        Button nextPageBtn = new Button("下一頁");
        nextPageBtn.setVisible(false);
        Button newPageBtn = new Button("nwe Page");
//        newPageBtn.setVisible(false);
        Button penPageBtn = new Button("Pen");
        penPageBtn.setVisible(false);
        Button selectBtn = new Button("Selection");
        selectBtn.setVisible(false);
        
        


        Button startBtn = new Button("Start");
        this.add(startBtn);
        startBtn.setVisible(false);
        startBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
//                previousPageBtn.setVisible(false);
//                nextPageBtn.setVisible(false);
                ep.activatePage = new Page();
                
                ep.activatePage.add(new Label("Wssssssel"));
                ep.pages.add(ep.activatePage);
                
                
                ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間
                startBtn.setVisible(false);
                newPageBtn.setVisible(true);
                
                ep.mainWin.setVisible(true);
                
                
                
                
            }
        });
        
        
        
        this.add(newPageBtn);
        newPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
//                if(ep.numPages < ep.activatePage.pageColors.length){
                if(ep.numPages < 8){
                    if (ep.numPages == 0){
                        previousPageBtn.setVisible(true);
                        nextPageBtn.setVisible(true);
                        penPageBtn.setVisible(true);
                        selectBtn.setVisible(true);
                    }
                    
                    if (ep.activatePage != null )
                           ep.mainWin.remove(ep.activatePage); //當新增過後時就要先 remove

                    ep.activatePage = new Page();
                    ep.pages.add(ep.activatePage);
                    
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);  //在中間
                       //到這裡結束會因為畫面沒有更新導致畫面重疊
                    
                    if(ep.numPages == ep.curPage){
                        ep.numPages++ ;
                        ep.curPage++ ;
                    }else{
                        ep.curPage = ++ep.numPages ;
                    }
                    ep.megBar.updateInfo(ep.curPage, ep.numPages);
                    ep.mainWin.setVisible(true);
                    
                }
            }
        });
        
        
        
        //上一頁
//        Button previousPageBtn = new Button("上一頁");
//        previousPageBtn.setVisible(false);
        this.add(previousPageBtn);
        previousPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage > 1){                    
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage = ep.pages.elementAt(ep.pages.indexOf(ep.activatePage)-1);
                    ep.mainWin.add(ep.activatePage);
                    ep.megBar.updateInfo(--ep.curPage, ep.numPages);
                    System.out.println(ep.curPage + "|" + ep.numPages);
                }
            }
        });
        
        
        //下一頁
//        Button nextPageBtn = new Button("下一頁");
//        nextPageBtn.setVisible(false);
        this.add(nextPageBtn);
        nextPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
            
                if (ep.curPage < ep.numPages ){
                    
                    ep.mainWin.remove(ep.activatePage);
                    ep.activatePage = ep.pages.elementAt(ep.pages.indexOf(ep.activatePage)+1);
                    ep.mainWin.add(ep.activatePage, BorderLayout.CENTER);
                    ep.megBar.updateInfo(++ep.curPage, ep.numPages);
                    System.out.println(ep.curPage + "|" + ep.numPages);
                }
            }
        });
        
//        Button penPageBtn = new Button("Pen");
//        penPageBtn.setVisible(true);
        this.add(penPageBtn);
        penPageBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                
                if(ep.activatePage != null){
                    ep.activatePage.status = Status.Drawingm ;
                }
            }
        });
        
        
        this.add(selectBtn);
        selectBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                if(ep.activatePage != null){
                    ep.activatePage.status = Status.Selection ;
                }
            }
        });
        
        
        
        Button creatOBJBtn = new Button("CreatOBJBtn");
        this.add(creatOBJBtn);
        creatOBJBtn.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                
                if(ep.activatePage != null){
                    ep.activatePage.status = Status.CreatingOBJ ;
                }
            }
        });
        
    
    }
}
