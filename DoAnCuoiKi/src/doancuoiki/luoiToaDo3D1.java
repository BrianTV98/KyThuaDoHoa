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
public class luoiToaDo3D1  extends JPanel implements ActionListener{
    private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     Timer tm= new Timer(100, this); // Timer(a,b); a la thoi gian delay;

    HinhHop HH;
     
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
         
         int x = Integer.parseInt(MainFrame.HX.getText());
         int y = Integer.parseInt(MainFrame.HY.getText());
         int z = Integer.parseInt(MainFrame.HZ.getText());
         int d = Integer.parseInt(MainFrame.dai.getText());
         int r = Integer.parseInt(MainFrame.rong.getText());
         int h = Integer.parseInt(MainFrame.cao.getText());
        
         HH=new HinhHop(new Point3D(x, y, z), r, d, h);
         HH.draw(g, Color.green);
         
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
        
         int x = Integer.parseInt(MainFrame.HX.getText());
         int y = Integer.parseInt(MainFrame.HY.getText());
         int z = Integer.parseInt(MainFrame.HZ.getText());
         int d = Integer.parseInt(MainFrame.dai.getText());
         int r = Integer.parseInt(MainFrame.rong.getText());
         int h = Integer.parseInt(MainFrame.cao.getText());
         HH=new HinhHop(new Point3D(x, y, z), r, d, h);
         
         //Dinh A
        Point3D A= HH.P1;
        Pixel pixeA= new ChuyenToaDo(A.tranFormToPixel().getX(), A.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("A", pixeA.getX()+8, pixeA.getY()-8);
        
        //Dinh B
        Point3D B= HH.P2;
        Pixel pixeB= new ChuyenToaDo(B.tranFormToPixel().getX(), B.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("B", pixeB.getX()+8, pixeB.getY()-8);
        
        //Dinh C
        Point3D C= HH.P3;
        Pixel pixeC= new ChuyenToaDo(C.tranFormToPixel().getX(), C.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("C", pixeC.getX()-8, pixeC.getY()+16);
        
        //Dinh D
        Point3D D= HH.P4;
        Pixel pixeD= new ChuyenToaDo(D.tranFormToPixel().getX(), D.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("D", pixeD.getX()-16, pixeD.getY()+16);
        
        //Dinh E
        Point3D E= HH.P5;
        Pixel pixeE= new ChuyenToaDo(E.tranFormToPixel().getX(), E.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("E", pixeE.getX()-14, pixeE.getY()+8);
        
        //Dinh F
        Point3D F= HH.P6;
        Pixel pixeF= new ChuyenToaDo(F.tranFormToPixel().getX(), F.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("F", pixeF.getX()+8, pixeF.getY()-8);
        
        //Dinh G
        Point3D G= HH.P7;
        Pixel pixeG= new ChuyenToaDo(G.tranFormToPixel().getX(), G.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("G", pixeG.getX()-8, pixeG.getY()-8);
        
        //Dinh K
        Point3D K= HH.P8;
        Pixel pixeK= new ChuyenToaDo(K.tranFormToPixel().getX(), K.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawString("K", pixeK.getX()-14, pixeK.getY()-8);
        
        g2d.setPaint(Color.black);
        g2d.drawString("TỌA Độ Đỉnh", 0, 10+5);
        g2d.drawString("A("+HH.P1.getX()+","+HH.P1.getY()+","+HH.P1.getZ()+")", 5, 25+5);
        g2d.drawString("B("+HH.P2.getX()+","+HH.P2.getY()+","+HH.P2.getZ()+")", 5, 40+5);
        g2d.drawString("C("+HH.P3.getX()+","+HH.P3.getY()+","+HH.P3.getZ()+")", 5, 55+5);
        g2d.drawString("D("+HH.P4.getX()+","+HH.P4.getY()+","+HH.P4.getZ()+")", 5, 70+5);
        g2d.drawString("E("+HH.P5.getX()+","+HH.P5.getY()+","+HH.P5.getZ()+")", 5, 85+5);
        g2d.drawString("F("+HH.P6.getX()+","+HH.P6.getY()+","+HH.P6.getZ()+")", 5, 100+5);
        g2d.drawString("G("+HH.P7.getX()+","+HH.P7.getY()+","+HH.P7.getZ()+")", 5, 115+5);
        g2d.drawString("K("+HH.P8.getX()+","+HH.P8.getY()+","+HH.P8.getZ()+")", 5, 130+5);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
