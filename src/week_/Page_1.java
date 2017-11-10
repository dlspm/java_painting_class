/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week_;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author angus
 */
public class Page_1 extends Panel{
    /*
    // 建立一個顏色的陣列
    public Color pageColors[] = {Color.BLACK, Color.white, Color.CYAN, Color.darkGray, Color.BLUE, Color.pink, Color.GRAY, Color.ORANGE};
   
    public static int id = 1; //定義一個 常數 id
    
    Point lp,cp ; //記錄滑鼠位置，要小心如果沒有在 new 之後再使用，就很容易會出錯
    
    
    //每一次都有上一次只有第一次沒有上一次
    
    Page(){

        this.setBackground(pageColors[id++]); // 讓每個 Page 新增後的 Background 都依照 pageColors[]

        // addMouseMotionListener 專門是滑鼠移動的，回去要看文獻去看監聽什麼事件（mouseDragged）
        this.addMouseMotionListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mouseDragged(MouseEvent e){ //上一點跟現在這點做連線
                System.out.println("mouse");
                cp = e.getPoint() ; //當下位置

                //先取得一個繪圖的裝置
                Graphics g = Page.this.getGraphics(); 

                g.drawLine(lp.x, lp.y, cp.x, cp.y); //畫線
                lp = cp;


            }


        }); 

        this.addMouseListener(new MouseAdapter(){ //針對各式各樣的滑鼠動作
            public void mousePressed(MouseEvent e){
                System.out.println("pressed");
                lp = e.getPoint() ; //第一次


            }
            public void mouseClick(MouseEvent e){
                System.out.println("click");
            }
            public void mouseReleased(MouseEvent e){
                System.out.println("released");
            }


        }); 


    }
*/
}
