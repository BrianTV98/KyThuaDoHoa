/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author ASUS
 */
public class HinhHop {
    Point3D P1;
    Point3D P2;
    Point3D P3;
    Point3D P4;
    Point3D P5;
    Point3D P6;
    Point3D P7;
    Point3D P8;
    int r;
    int d;
    int H;
    
    //Graphics g;

    public HinhHop(Point3D P1,int r, int d, int H) {
        this.d = d;
        this.r = r;
        this.H = H;
        this.P1 = P1;
        this.P2 = new Point3D(this.P1.getX()+d, this.P1.getY(), this.P1.getZ()); 
        this.P4 = new Point3D(this.P1.getX(), this.P1.getY(), this.P1.getZ()+r);
        this.P3 = new Point3D(this.P2.getX(), this.P2.getY(), this.P4.getZ());
        this.P5 = new Point3D(this.P4.getX(), this.P4.getY()+H, this.P4.getZ());
        this.P6 = new Point3D(this.P1.getX(), this.P1.getY()+H, this.P1.getZ());
        this.P7 = new Point3D(this.P2.getX(), this.P2.getY()+H, this.P2.getZ());
        this.P8 = new Point3D(this.P3.getX(), this.P3.getY()+H, this.P3.getZ());
        
    }

//    public HinhHop(Point3D P1, Point3D P2, Point3D P3, Point3D P4, Point3D P5, Point3D P6, Point3D P7, Point3D P8) {
//        this.P1 = P1;
//        this.P2 = P2;
//        this.P3 = P3;
//        this.P4 = P4;
//        this.P5 = P5;
//        this.P6 = P6;
//        this.P7 = P7;
//        this.P8 = P8;
//    }

    public Point3D getP1() {
        return P1;
    }

    public void setP1(Point3D P1) {
        this.P1 = P1;
    }

    public Point3D getP2() {
        return P2;
    }

    public void setP2(Point3D P2) {
        this.P2 = P2;
    }

    public Point3D getP3() {
        return P3;
    }

    public void setP3(Point3D P3) {
        this.P3 = P3;
    }

    public Point3D getP4() {
        return P4;
    }

    public void setP4(Point3D P4) {
        this.P4 = P4;
    }

    public Point3D getP5() {
        return P5;
    }

    public void setP5(Point3D P5) {
        this.P5 = P5;
    }

    public Point3D getP6() {
        return P6;
    }

    public void setP6(Point3D P6) {
        this.P6 = P6;
    }

    public Point3D getP7() {
        return P7;
    }

    public void setP7(Point3D P7) {
        this.P7 = P7;
    }

    public Point3D getP8() {
        return P8;
    }

    public void setP8(Point3D P8) {
        this.P8 = P8;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    
    public int getH() {
        return H;
    }

    public void setH(int H) {
        this.H = H;
    }
    
    public void draw(Graphics g, Color mau){
        //Day duoi
        //System.out.println("chay");
        new Line(P1.tranFormToPixel(), P2.tranFormToPixel()).linebreak(g, mau);
        new Line(P1.tranFormToPixel(), P4.tranFormToPixel()).linebreak(g, mau);
        new Line(P2.tranFormToPixel(), P3.tranFormToPixel()).Bresenham(g, mau);
        new Line(P3.tranFormToPixel(), P4.tranFormToPixel()).Bresenham(g, mau);
        //Than
        new Line(P1.tranFormToPixel(), P6.tranFormToPixel()).linebreak(g, mau);
        new Line(P2.tranFormToPixel(), P7.tranFormToPixel()).Bresenham(g, mau);
        new Line(P3.tranFormToPixel(), P8.tranFormToPixel()).Bresenham(g, mau);
        new Line(P4.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, mau);
        //Day tren
        new Line(P5.tranFormToPixel(), P6.tranFormToPixel()).Bresenham(g, mau);
        new Line(P6.tranFormToPixel(), P7.tranFormToPixel()).Bresenham(g, mau);
        new Line(P7.tranFormToPixel(), P8.tranFormToPixel()).Bresenham(g, mau);
        new Line(P8.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, mau);
    }
    
    public  void  HienThiThongTinHinhChop(){
        MainFrame.hhname.setText("Toa Do Dinh Hinh Chop");
        MainFrame.hhda.setText ("A:      ("+P1.getX()+","+P1.getY()+","+P1.getZ()+")");
        MainFrame.hhdb.setText ("B:      ("+P2.getX()+","+P2.getY()+","+P2.getZ()+")");
        MainFrame.hhdc.setText ("C:      ("+P3.getX()+","+P3.getY()+","+P3.getZ()+")");
        MainFrame.hhdd.setText ("D:      ("+P4.getX()+","+P4.getY()+","+P4.getZ()+")");
        MainFrame.hhde.setText ("E:      ("+P5.getX()+","+P5.getY()+","+P5.getZ()+")");
        MainFrame.hhdf.setText ("F:      ("+P6.getX()+","+P6.getY()+","+P6.getZ()+")");
        MainFrame.hhdg.setText ("G:      ("+P7.getX()+","+P7.getY()+","+P7.getZ()+")");
        MainFrame.hhdk.setText ("H:      ("+P8.getX()+","+P8.getY()+","+P8.getZ()+")");
    }
}
