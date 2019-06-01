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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mylov
 */
public class luoiToaDo3D3  extends JPanel implements ActionListener{
    private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     Timer tm= new Timer(100, this); // Timer(a,b); a la thoi gian delay;

     HinhChop HC;
    
     
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
         
         
         int x = Integer.parseInt(MainFrame.CX.getText());
         int y = Integer.parseInt(MainFrame.CY.getText());
         int z = Integer.parseInt(MainFrame.CZ.getText());
         int d = Integer.parseInt(MainFrame.Cdai.getText());
         int r = Integer.parseInt(MainFrame.Crong.getText());
         int h = Integer.parseInt(MainFrame.Ccao.getText());
       HC = new HinhChop(new Point3D(x, y, z), d, r, h);
       HC.drawHinhChop(g, Color.red);
       
//         new HinhHop(new Point3D(x, y, z), r, d, h).draw(g, Color.gray);
         
        //Integer.parseInt(MainFrame.textField.getText());
        
       // Point3D P = new Point3D(10, 0, 0);
       // P.tranFormToPixel().draw(g, Color.green);
       // Point3D PP = new Point3D(50, 0, 50);
        //Point3D Tam = new Point3D(100, 0, 10);
        //PP.tranFormToPixel().draw(g, Color.green);
        //new Eclip(PP.tranFormToPixel(), 20, 10).draweEllipseMidPoint(g, Color.yellow, false);
     // new HinhTru(PP, 25, 40).drawHinhTru(g, Color.green);
      // new HinhCau(Tam, 30).drawHinhCau(g, Color.yellow);
       //new CircleLineBreak(PP.tranFormToPixel(), 25).bresenhamCircleBreak(g, Color.yellow);
       //new RectangleFull(P.tranFormToPixel(), 20, 10).DrawRectFull(g, Color.gray);
      // new CircleFull(PP.tranFormToPixel(), 10).CircleFull(g, Color.gray);
       // HinhHop HH = new HinhHop(P, PP, 50);
       // HH.draw(g, Color.gray);
         
     }
     public void doDraw(Graphics2D g){
       // this.keLine(g);
       this.veTrucToaToa(g);
//       MainFrame.VeHinhHop.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//              MainFrame.jFrame.repaint();
//                demo(g);
//                
//              // MainFrame.jFrame.add(MainFrame.VeHinhHop);
//           }
//       } );
        
        demo(g);
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
        g2d.drawLine(600, 400, 1200, 400); // khung la 1200x800 // ve truc ox
        g2d.drawLine(600, 401, 1200, 401); // do lai truc ox
        g2d.drawLine(601, 2, 601,400); // ve truc oy
        g2d.drawString(">", 1195, 405);
        g2d.drawString("^", 598, 12);
        g2d.drawString("Oy", 580, 20);
        g2d.drawString("O", 590, 412);
        Point3D p1= new Point3D(0, 0, 0);
        Point3D p2= new Point3D(0, 0, 400);
        Pixel pixel1= new ChuyenToaDo(p1.tranFormToPixel().getX(), p1.tranFormToPixel().getY()).NguoiDung_to_May();
        Pixel pixel2= new ChuyenToaDo(p2.tranFormToPixel().getX(), p2.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawLine(pixel1.getX(),pixel1.getY(),pixel2.getX(),pixel2.getY());
        g2d.drawLine(pixel1.getX()+1,pixel1.getY(),pixel2.getX()+1,pixel2.getY());
        g2d.drawString("OZ", 190, 790);
        g2d.setPaint(Color.BLACK);
        
        int x = Integer.parseInt(MainFrame.CX.getText());
         int y = Integer.parseInt(MainFrame.CY.getText());
         int z = Integer.parseInt(MainFrame.CZ.getText());
         int d = Integer.parseInt(MainFrame.Cdai.getText());
         int r = Integer.parseInt(MainFrame.Crong.getText());
         int h = Integer.parseInt(MainFrame.Ccao.getText());
       HC = new HinhChop(new Point3D(x, y, z), d, r, h);
       
       //Dinh A
       Point3D A= HC.P1;
        Pixel pixeA= new ChuyenToaDo(A.tranFormToPixel().getX(), A.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("A", pixeA.getX()+16, pixeA.getY()-8);
        
        //Dinh B
        Point3D B= HC.P2;
        Pixel pixeB= new ChuyenToaDo(B.tranFormToPixel().getX(), B.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("B", pixeB.getX()+8, pixeB.getY()-8);
        
        //Dinh C
        Point3D C= HC.P3;
        Pixel pixeC= new ChuyenToaDo(C.tranFormToPixel().getX(), C.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("C", pixeC.getX()-8, pixeC.getY()+16);
        
        //Dinh D
        Point3D D= HC.P4;
        Pixel pixeD= new ChuyenToaDo(D.tranFormToPixel().getX(), D.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("D", pixeD.getX(), pixeD.getY()+16);
        
        //Dinh E
        Point3D E= HC.P5;
        Pixel pixeE= new ChuyenToaDo(E.tranFormToPixel().getX(), E.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("E", pixeE.getX(), pixeE.getY()-8);
        
        g2d.setPaint(Color.black);
        g2d.drawString("TỌA Độ Đỉnh", 0, 15);
        g2d.drawString("A("+HC.P1.getX()+","+HC.P1.getY()+","+HC.P1.getZ()+")", 5, 25+5);
        g2d.drawString("B("+HC.P2.getX()+","+HC.P2.getY()+","+HC.P2.getZ()+")", 5, 40+5);
        g2d.drawString("C("+HC.P3.getX()+","+HC.P3.getY()+","+HC.P3.getZ()+")", 5, 55+5);
        g2d.drawString("D("+HC.P4.getX()+","+HC.P4.getY()+","+HC.P4.getZ()+")", 5, 70+5);
        g2d.drawString("E("+HC.P5.getX()+","+HC.P5.getY()+","+HC.P5.getZ()+")", 5, 85+5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
