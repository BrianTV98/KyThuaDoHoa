/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Mylov
 */
public class MayBay{
    Pixel point;
    
    Rect dau;
    Rect sung;
    Rect minh;
    TamGiac canhTren;
    TamGiac canhDuoi;
    Circle banhXe1;
    Circle banhXe2;
    Line lua1, lua2, lua3, lua4, lua5, lua6;
    //khai bao cach goc;
    Pixel B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q;
   public MayBay(Pixel p) {
        this.point=p;
        B= new Pixel(point.getX()+3, point.getY()+4);
        C= new Pixel(B.getX()+5, point.getY()-3);
        D= new Pixel(C.getX(), B.getY()+3);
        E= new Pixel(D.getX(),D.getY()-12);
        F= new Pixel(D.getX()+20, D.getY());
        G= new Pixel(D.getX()+20, D.getY()-12);
        H= new Pixel(F.getX()+20, F.getY()+20);
        I= new Pixel(G.getX()+20, G.getY()-20);
        J=new Pixel(F.getX()+4, F.getY()-3);
        K= new Pixel(G.getX()+4, G.getY()+3);
        L= new Pixel(J.getX()+4, J.getY()+2);
        M= new Pixel(L.getX(), L.getY()-2);
        N= new Pixel(M.getX(), M.getY()-2);
        O=new Pixel(N.getX(), N.getY()-3);
        P=new Pixel(O.getX(), O.getY()-2);
        Q=new Pixel(P.getX(), P.getY()-2);
        sung =new Rect(point, new Pixel(point.getX()+2, point.getY()+1));
        dau= new Rect(B, C);
        minh=new Rect(D, G);
        canhTren= new TamGiac(D,F,H);
        canhDuoi= new TamGiac(E, G, I);
        banhXe1= new Circle(J, 3);
        banhXe2= new Circle(K, 3);
        lua1= new Line(L, new Pixel(L.getX()+4, L.getY()));
        lua2= new Line(M, new Pixel(M.getX()+4, M.getY()));
        lua3=new Line(N, new Pixel(N.getX()+4, N.getY()));
        lua4=new Line(O, new Pixel(O.getX()+4, O.getY()));
        lua5= new Line(P, new Pixel(P.getX()+4, P.getY()));
        lua6= new Line(Q, new Pixel(Q.getX()+4, Q.getY()));
    }

    public MayBay(Pixel point, Rect dau, Rect sung, Rect minh, TamGiac canhTren, TamGiac canhDuoi, Circle banhXe1, Circle banhXe2, Line lua1, Line lua2, Line lua3, Line lua4, Line lua5, Line lua6) {
        this.point = point;
        this.dau = dau;
        this.sung = sung;
        this.minh = minh;
        this.canhTren = canhTren;
        this.canhDuoi = canhDuoi;
        this.banhXe1 = banhXe1;
        this.banhXe2 = banhXe2;
        this.lua1 = lua1;
        this.lua2 = lua2;
        this.lua3 = lua3;
        this.lua4 = lua4;
        this.lua5 = lua5;
        this.lua6 = lua6;
    }

    public Pixel getPoint() {
        return point;
    }

    public void setPoint(Pixel point) {
        this.point = point;
    }

   

    
    public void Draw(Graphics g){
        sung.draw(g, Color.black);
        dau.draw(g, Color.black);
        minh.draw(g, Color.black);
        canhTren.draw(g, Color.black);
        canhDuoi.draw(g, Color.black);
        banhXe1.bresenhamCircle(g, Color.blue);
        banhXe2.bresenhamCircle(g, Color.blue);
        lua1.Bresenham(g, Color.yellow);
        lua2.Bresenham(g, Color.yellow);
        lua3.Bresenham(g, Color.yellow);
        lua4.Bresenham(g, Color.yellow);
        lua5.Bresenham(g, Color.yellow);
        lua6.Bresenham(g, Color.yellow);
        HienThiThongTin();
        
    }
    public void HienThiThongTin(){
        MainFrame.lbname1.setText("MAY BAY");
        MainFrame.lbdau.setText ("Đầu  (Hình Chữ Nhật):      ("+dau.getGoc1().getX()+","
                +dau.getGoc1().getY()+")   ;   ("+dau.getGoc3().getX()+","+dau.getGoc3().getY()+")");
        MainFrame.lbsung.setText("Súng (Hinh Chữ Nhât):     ("+sung.getGoc1().getX()+","
                +sung.getGoc1().getY()+")   ;   ("+sung.getGoc3().getX()+","+sung.getGoc3().getY()+")");
        MainFrame.lbminh.setText("Thân (Hinh Chữ Nhât):     ("+minh.getGoc1().getX()+","
                +minh.getGoc1().getY()+")   ;   ("+minh.getGoc3().getX()+","+minh.getGoc3().getY()+")");
        MainFrame.lbCanhDuoi.setText("Cánh Dưới (Hinh Tam Giác):     ("+canhDuoi.getP1().getX()+","+canhDuoi.getP1().getY()+")   ;   ("
                +canhDuoi.getP2().getX()+","+canhDuoi.getP2().getY()+")   ;   ("+canhDuoi.getP3().getX()+","+canhDuoi.getP3().getY()+")");
        MainFrame.lbcanhtren.setText("Cánh Trên (Hinh Tam Giác):     ("+canhTren.getP1().getX()+","+canhTren.getP1().getY()+")   ;   ("
                +canhTren.getP2().getX()+","+canhTren.getP2().getY()+")   ;   ("+canhTren.getP3().getX()+","+canhTren.getP3().getY()+")");
        MainFrame.lbBanhXe1.setText("Bánh lái trên (Hinh Tròn):     ("+banhXe1.getTam().getX()+","+banhXe1.getTam().getY()+")   ;   R="
                +banhXe1.getBankinh());
        MainFrame.lbBanhXe2.setText("Bánh lái dưới (Hinh Tròn):     ("+banhXe2.getTam().getX()+","+banhXe2.getTam().getY()+")   ;   R="
                +banhXe2.getBankinh());
        MainFrame.lua1.setText ("Tia lửa 1  (Đường Thẳng):      ("+lua1.getGoc1().getX()+","+lua1.getGoc1().getY()+")   ;   ("
                +lua1.getGoc2().getX()+","+lua1.getGoc2().getY()+")");
        MainFrame.lua2.setText ("Tia lửa 2  (Đường Thẳng):      ("+lua2.getGoc1().getX()+","+lua2.getGoc1().getY()+")   ;   ("
                +lua2.getGoc2().getX()+","+lua2.getGoc2().getY()+")");
        MainFrame.lua3.setText ("Tia lửa 3  (Đường Thẳng):      ("+lua3.getGoc1().getX()+","+lua3.getGoc1().getY()+")   ;   ("
                +lua3.getGoc2().getX()+","+lua3.getGoc2().getY()+")");
        MainFrame.lua4.setText ("Tia lửa 4  (Đường Thẳng):      ("+lua4.getGoc1().getX()+","+lua4.getGoc1().getY()+")   ;   ("
                +lua4.getGoc2().getX()+","+lua4.getGoc2().getY()+")");
        MainFrame.lua5.setText ("Tia lửa 5  (Đường Thẳng):      ("+lua5.getGoc1().getX()+","+lua5.getGoc1().getY()+")   ;   ("
                +lua5.getGoc2().getX()+","+lua5.getGoc2().getY()+")");
        MainFrame.lua6.setText ("Tia lửa 6  (Đường Thẳng):      ("+lua6.getGoc1().getX()+","+lua6.getGoc1().getY()+")   ;   ("
                +lua6.getGoc2().getX()+","+lua6.getGoc2().getY()+")");
                
    }
    public MayBay TinhTien(int x,int y){
       return new  MayBay(point.TinhTien(x, y),
               dau.TinhTien(x, y),
               sung.TinhTien(x, y),
               minh.TinhTien(x, y),
               canhTren.TinhTien(x, y),
               canhDuoi.TinhTien(x, y),
               banhXe1.TinhTien(x, y),
               banhXe2.TinhTien(x, y),
               lua1.TinhTien(x, y),
               lua2.TinhTien(x, y),
               lua3.TinhTien(x, y),
               lua4.TinhTien(x, y),
               lua5.TinhTien(x, y),
               lua6.TinhTien(x, y));
    }
   public MayBay Quay(int Do){
       return new MayBay(point.Quay(Do),
               dau.Quay(Do),
               sung.Quay(Do),
               minh.Quay(Do),
               canhTren.Quay(Do),
               canhDuoi.Quay(Do),
               banhXe1.Quay(Do),
               banhXe2.Quay(Do),
               lua1.Rotate(Do),
               lua2.Rotate(Do),
               lua3.Rotate(Do),
               lua4.Rotate(Do),
               lua5.Rotate(Do), 
               lua6.Rotate(Do));
   }
   public MayBay DoiXungOx(){
       return new MayBay(point.DoiXungOx(),
               dau.DoiXungOx(),
               sung.DoiXungOx(),
               minh.DoiXungOx(), 
               canhTren.DoiXungQuaOx(),
               canhDuoi.DoiXungQuaOx(), 
               banhXe1.DoiXungQuaOx(), 
               banhXe2.DoiXungQuaOx(), 
               lua1.DoiXungOx(), 
               lua2.DoiXungOx(), 
               lua3.DoiXungOx(),
               lua4.DoiXungOx(), 
               lua5.DoiXungOx(),
               lua6.DoiXungOx());
   }
   public  MayBay Scaling(int x, int y){
       return new MayBay(point.Scaling(x, y),
               dau.Scaling(x, y),
               sung.Scaling(x, y),
               minh.Scaling(x, y),
               canhTren.Scaling(x, y),
               canhDuoi.Scaling(x, y),
               banhXe1.Scaling(x, y),
               banhXe2.Scaling(x, y),
               lua1.Scaling(x, y),
               lua2.Scaling(x, y),
               lua3.Scaling(x, y),
               lua4.Scaling(x, y),
               lua5.Scaling(x, y),
               lua6.Scaling(x, y));
   }
   public MayBay DoiXungOy(){
       return new MayBay(point.DoiXungOy(),
               dau.DoiXungOy(),
               sung.DoiXungOy(), 
               minh.DoiXungOy(), 
               canhTren.DoiXungQuayOy(),
               canhDuoi.DoiXungQuayOy(),
               banhXe1.DoiXungQuaOy(),
               banhXe2.DoiXungQuaOy(), 
               lua1.DoiXungOy(),
               lua2.DoiXungOy(), 
               lua3.DoiXungOy(),
               lua4.DoiXungOy(), 
               lua5.DoiXungOy(), 
               lua6.DoiXungOy());
   }
   public MayBay DoiXungO(){
       return new MayBay(point.DoiXungO(),
               dau.DoiXungO(),
               sung.DoiXungO(),
               minh.DoiXungO(), 
               canhTren.DoiXungO(),
               canhDuoi.DoiXungO(), 
               banhXe1.DoiXungO(), 
               banhXe2.DoiXungO(), 
               lua1.DoiXungO(), 
               lua2.DoiXungO(),
               lua3.DoiXungO(), 
               lua4.DoiXungO(), 
               lua5.DoiXungO(), 
               lua6.DoiXungO());
   }
   public MayBay DoiXungQuaDiem(Pixel p){
       return new MayBay(point.DoiXungQuaDiem(p),
               dau.DoXungQuaDiem(p),
               sung.DoXungQuaDiem(p),
               minh.DoXungQuaDiem(p),
               canhTren.DoXungQuaDiem(p),
               canhDuoi.DoXungQuaDiem(p),
               banhXe1.DoiXungQuaDiem(p),
               banhXe2.DoiXungQuaDiem(p), 
               lua1.DoiXungQuaDiem(p),
               lua2.DoiXungQuaDiem(p),
               lua3.DoiXungQuaDiem(p), 
               lua4.DoiXungQuaDiem(p), 
               lua5.DoiXungQuaDiem(p),
               lua6.DoiXungQuaDiem(p));
   }
   public MayBay DoiXungQuaDuongThang(Pixel p1, Pixel p2){
       if(p1.getX()==p2.getY()&&p1.getY()==p2.getY()){
          return this;
       }
        
       return new MayBay(point.DoiXungQuaDuongThang(p1, p2),
               dau.DoiXungQuaDuongThang(p1, p2),
               sung.DoiXungQuaDuongThang(p1, p2),
               minh.DoiXungQuaDuongThang(p1, p2),
               canhTren.DoiXungQuaDuongThang(p1, p2),
               canhDuoi.DoiXungQuaDuongThang(p1, p2),
               banhXe1.DoiXungQuaDuongThang(p1, p2),
               banhXe2.DoiXungQuaDuongThang(p1, p2),
               lua1.DoiXungQuaDuongThang(p1, p2),
               lua2.DoiXungQuaDuongThang(p1, p2),
               lua3.DoiXungQuaDuongThang(p1, p2),
               lua4.DoiXungQuaDuongThang(p1, p2),
               lua5.DoiXungQuaDuongThang(p1, p2),
               lua6.DoiXungQuaDuongThang(p1, p2));
       
   }       
       
   public MayBay QuayQuanhDiem(Pixel p1, int Do){
       return new MayBay(point.QuayQuanhDiem(p1, Do),
               dau.QuayQuanhDiem(p1, Do),
               sung.QuayQuanhDiem(p1, Do),
               minh.QuayQuanhDiem(p1, Do),
               canhTren.QuayQuanhDiem(p1, Do),
               canhDuoi.QuayQuanhDiem(p1, Do),
               banhXe1.QuayQuanhDiem(p1, Do),
               banhXe2.QuayQuanhDiem(p1, Do),
               lua1.QuayQuanhMotDiem(p1, Do),
               lua2.QuayQuanhMotDiem(p1, Do),
               lua3.QuayQuanhMotDiem(p1, Do),
               lua4.QuayQuanhMotDiem(p1, Do),
               lua5.QuayQuanhMotDiem(p1, Do), 
               lua6.QuayQuanhMotDiem(p1, Do));
   }
   
   
}
