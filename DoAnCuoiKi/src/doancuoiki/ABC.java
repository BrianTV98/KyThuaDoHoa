/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Mylov
 */
public class ABC extends JPanel{
    
     private List <Pixel> pixel= new LinkedList<Pixel>();
     public void addPixel(Pixel p){
         pixel.add(p);
         this.repaint();
     }
     public void paintComponent(Graphics g){
         super.getComponents();
         super.paintComponent(g);
         doDraw((Graphics2D)g);
         for(Pixel p:pixel){
             p.draw(g,Color.gray);
         }
     }
      public void doDraw(Graphics2D g){
        this.keLine(g);
        this.veTrucToaToa(g);
        putpixel(50, 50, g);
        putpixel(50, 5, g);
//        putpixel(x, y, g);
        JPanel jpan= new JPanel(new FlowLayout());
        jpan.setLayout(new FlowLayout(100, 50, 200));
        jpan.setVisible(true);
        
    }
     private  void putpixel(int x, int y, Graphics2D g){
        for(int i=-2;i<=2;i++){
            Graphics2D g2d=(Graphics2D) g;
            g2d.drawLine(x-2, y+i, x+2, y+i);
        }
//        g.drawLine(x, y, x, y);
    }
    private void keLine(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        //line doc
        g2d.setPaint(Color.BLACK);
        int maxWight=1228;
        int maxHight=800;
        int begin=5;
        while(begin<1200){
            g2d.drawLine(begin, 5, begin, 795);
            begin=begin+5;
        }
        //line ngang
        //reset begin;
        begin=5;
        while(begin<800){
            g2d.drawLine(5, begin, 1195, begin);
            begin=begin+5;
        }
    }
    private void veTrucToaToa(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
//        g2d.setPaint(Color.RED);
        g2d.drawString("Ox", 1180, 415); //ki hieu ox
        g2d.drawLine(0, 400, 1200, 400); // khung la 1200x800 // ve truc ox
        g2d.drawLine(0, 401, 1200, 401); // do lai truc ox
        g2d.drawLine(601, 2, 601, 800); // ve truc oy
        g2d.drawString(">", 1195, 405);
        g2d.drawString("^", 598, 12);
        g2d.drawString("Oy", 580, 20);
        g2d.drawString("O", 590, 412);
        g2d.setPaint(Color.BLACK);
    }
//     public void paint(Graphics g){
//         
//         for(Pixel p:pixel){
//             p.draw(g);
//         }
//     }
}
