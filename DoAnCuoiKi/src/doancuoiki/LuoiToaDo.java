/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mylov
 */
class LuoiToaDo extends JPanel implements ActionListener{ // tao ra jpane để vẽ
     private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     int x=70;
     int y=0;
     int count=0;
     int z=0;
     MayBay maybay;
     Zombie zombie;
     Timer tm= new Timer(70, this); // Timer(a,b); a la thoi gian delay;
     Pixel p= new Pixel(70, 0);
     public void addPixel(Pixel p){
         pixel.add(p);
         this.repaint();
     }
     public void paintComponent(Graphics g){
         
         doDraw((Graphics2D) g);
         super.getComponents();
         super.paintComponent(g);
         doDraw((Graphics2D) g);
         for(Pixel p:pixel){
             p.draw(g,Color.green);
         }
        tm.start();
     }
     public  void demo(Graphics g){
         
//         new Rect(new Pixel(20,20), new Pixel(50,50 )).draw(g, Color.GREEN);
//         new Rect(new Pixel(20,20), new Pixel(50,50 )).QuayQuanhDiem(new Pixel(20,0 ), 45).draw(g, Color.GREEN);
//         new Line(new Rect(new Pixel(20,20), new Pixel(50, 50)).QuayQuanhDiem(new Pixel(20,0), 30).getGoc1(), new Rect(new Pixel(20,20), new Pixel(50, 50)).QuayQuanhDiem(new Pixel(20,0), 30).getGoc2()).Bresenham(g, Color.gray);
          if(count<50){
              maybay= new MayBay(new Pixel(x, y).TinhTien(0, count));
              zombie= new Zombie(new Pixel(-140, 50));
              zombie.TinhTien(count,0 ).draw(g);
              maybay.Draw(g);
          }
          if( count==50){
              zombie.TinhTien(count,0 ).draw(g);
              tm.setDelay(1000);
              maybay.setPoint(new Pixel(70, 50));
              maybay.TinhTien(-5, 0).Draw(g);
              tm.setDelay(100);
              }
          if(count>50&&count<250){
              if(count<170){
                  zombie.TinhTien(40+ count/4,0 ).draw(g);
              }
              else {
                  zombie.TinhTien( 83, 0).RungDau(g, (count-170)/4);
//                  System.out.println(zombie.TinhTien( 83, 0).tamnao.getX()+": "+zombie.TinhTien( 83, 0).tamnao.getY()+": " +count);
              };
              tm.setDelay(10);
              maybay.Draw(g);
              new Pixel(70, 50).TinhTien(51-count, 0).draw(g, Color.red);
          }
          if(count>250&&count<400){
              tm.setDelay(50);
              if(count<280){
                  zombie.TinhTien( 83, 0).RungDau(g,20+count-250);
              }
              else zombie.TinhTien( 83, 0).RungDau(g,50);
              maybay.TinhTien(250-count,0).Draw(g);
          }
          if(count==400){
              maybay= new MayBay(new Pixel(-80, 50));
              maybay.Draw(g);
          }
          if(count>400&&count<580){
              tm.setDelay(100);   
              new Pixel(-57,0).draw(g, Color.YELLOW);
              zombie.TinhTien( 83, 0).RungDau(g,50);
              maybay.QuayQuanhDiem(new Pixel(-57, 0),count-400).Draw(g);
          }
          if(count>=580){
              tm.setDelay(50);
              zombie.TinhTien( 83, 0).RungDau(g,50);
              maybay.QuayQuanhDiem(new Pixel(-57, 0),180).TinhTien(15,0 ).Scaling(2, 1).TinhTien(count-580, 0).Draw(g);
          }
          if(count>800) count=0;
     }
      public void doDraw(Graphics2D g){
        this.keLine(g);
        this.veTrucToaToa(g);
//        JPanel jpan= new JPanel(new FlowLayout());
//        jpan.setLayout(new FlowLayout(100, 50, 200));
        demo(g);
        
 
//        jpan.setVisible(true);
        
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
        begin=5;
        while(begin<800){
            g2d.drawLine(5, begin, 1195, begin);
            begin=begin+5;
        }
    }
    private void veTrucToaToa(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setPaint(Color.RED);
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

    @Override
    public void actionPerformed(ActionEvent e) {
      count++;       
        
        this.repaint(10);//To change body of generated methods, choose Tools | Templates.
    }
}
