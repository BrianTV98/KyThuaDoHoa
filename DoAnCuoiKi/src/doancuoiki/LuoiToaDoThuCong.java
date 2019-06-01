/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

/**
 *
 * @author Mylov
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
class LuoiToaDoThuCong extends JPanel implements ActionListener{ // tao ra jpane để vẽ
     private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     int x=70;
     int y=0;
     int count=0;
     int z=0;
     static MayBay maybay;
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
         maybay = new MayBay(new Pixel(30, 30));
         
         maybay.Draw(g);
         if(MainFrame.dem==1){
             maybay.DoiXungOx().Draw(g);
         }
         if(MainFrame.dem==2){
             maybay.DoiXungOy().Draw(g);
         } 
         if(MainFrame.dem==3){
             maybay.DoiXungO().Draw(g);
         }
         if(MainFrame.dem==4){
             maybay.DoiXungQuaDiem(new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText()))).Draw(g);
             new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText())).draw(g, Color.red);
         }
         if(MainFrame.dem==5){
             maybay.DoiXungQuaDuongThang(new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText())),//new Pixel(0, 0)).Draw(g);
                     new Pixel(Integer.parseInt(MainFrame.X2.getText()),Integer.parseInt(MainFrame.Y2.getText()))).Draw(g);
             new Line(new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText())),
                     new Pixel(Integer.parseInt(MainFrame.X2.getText()), Integer.parseInt(MainFrame.Y2.getText()))).Bresenham(g, Color.gray);
         }
         if(MainFrame.dem==6){
             maybay.Quay(Integer.parseInt(MainFrame.txtDo.getText())).Draw(g);
         }
         if(MainFrame.dem==7){
             maybay.TinhTien(Integer.parseInt(MainFrame.X1.getText()), Integer.parseInt(MainFrame.Y1.getText())).Draw(g);
        }
         if(MainFrame.dem==8){
             maybay.Scaling(Integer.parseInt(MainFrame.X1.getText()), Integer.parseInt(MainFrame.Y1.getText())).Draw(g);
        }
          if(MainFrame.dem==9){
              maybay.QuayQuanhDiem(new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText())),
                      Integer.parseInt(MainFrame.txtDo.getText())).Draw(g);
              new Pixel(Integer.parseInt(MainFrame.X1.getText()),Integer.parseInt(MainFrame.Y1.getText())).draw(g, Color.red);
        }
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

