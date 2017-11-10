/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;


enum Status {Drawingm, Selection, CreatingOBJ} // 定義列舉型態
/**
 *
 * @author angus
 */
public class Page extends Panel{
    
    
    // 建立一個顏色的陣列
    public Color pageColors[] = {Color.BLACK, Color.white, Color.CYAN, Color.darkGray, Color.BLUE, Color.pink, Color.GRAY, Color.ORANGE};
   
    public static int id = 0; //定義一個 常數 id
    
    Point lp,cp, fp ; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    public Vector<Line> lines=null;
    public Status status; 
    //每一次都有上一次只有第一次沒有上一次
    
    
    public easyOBJ activeOBJ = null; //作用中的物件（如果需要紀錄上一個下一個）
    
    Page(){
        status = Status.Selection; //(某一個列舉型態)什麼事都不做的狀態
        lines = new Vector<Line>();
        this.setBackground(pageColors[id++]); // 讓每個 Page 新增後的 Background 都依照 pageColors[]
        
        this.setLayout(null);  //因為 page 會自動加上置中對齊
        
        
        // addMouseMotionListener 專門是滑鼠移動的，回去要看文獻去看監聽什麼事件（mouseDragged）
        this.addMouseMotionListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mouseDragged(MouseEvent e){ //上一點跟現在這點做連線
                System.out.println("mouse");
                
                
                if (Page.this.status == Status.Drawingm){
                    cp = e.getPoint() ; //當下位置

                    //先取得一個繪圖的裝置
                    Graphics g = Page.this.getGraphics(); 

                    g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                    Page.this.lines.add( new Line(lp, cp));
                    lp = cp;
                }
                else if(Page.this.status == Status.CreatingOBJ) {
                    
                    
                    //畫出虛框
                    Graphics g = Page.this.getGraphics(); 
                    g.setXORMode(Color.red);
                    
                    if(cp != null){ // 第一次
                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y - fp.y); //畫線
                    }
                    
                    cp = e.getPoint();
                    g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y - fp.y); //畫線
                    
                }
            }
        
            
        }); 
        
        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){
                System.out.println("mousePressed");
                if(Page.this.status == Status.Drawingm){
                    lp = e.getPoint() ; //第一次
                }
                else if(Page.this.status == Status.CreatingOBJ){
                    fp = e.getPoint();
                }
                
                
            }
            public void mouseClick(MouseEvent e){
                System.out.println("mouseClick");
            }
            public void mouseReleased(MouseEvent e){
                
                System.out.println("mouseReleased");
                
                // 消除框
                if(Page.this.status == Status.CreatingOBJ){
                    Graphics g = Page.this.getGraphics(); 
                    g.setXORMode(Color.red);
                    if(cp != null){ // 第一次
                        g.drawRect(fp.x, fp.y, cp.x - fp.x, cp.y - fp.y); //畫線
                    }
                    if(cp != null){ 
                        easyOBJ newOBJ = new easyOBJ(Page.this , fp, cp.x - fp.x, cp.y - fp.y); //為了要拿到 Page 資料
                        Page.this.add(newOBJ);
                        Page.this.activeOBJ = newOBJ;  //
                        Page.this.activeOBJ.selected(); //新增完，就是作用中的物件
                        
                        
                        
                        
                    }
                }
                
                
//                newOBJ.setSize(cp.x - fp.x, cp.y - fp.y);
//                newOBJ.setLocale(fp);
                
                
//                if(Page.this.status == Status.Drawingm){
//                    
//                    Page.this.status = Status.Selection;  // 讓每一下畫完放開之後就不能在話了
//                }
                
            }
        
            
        }); 
        
        
    }
    
    public void paint(Graphics g){  //記錄Line
        for(int i=0;i<Page.this.lines.size();i++){
            Line l = this.lines.elementAt(i);
            g.drawLine(l.sp.x, l.sp.y, l.ep.x, l.ep.y);
            
        }
    }
}
