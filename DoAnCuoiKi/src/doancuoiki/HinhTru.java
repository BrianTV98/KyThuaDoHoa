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
public class HinhTru {
    Point3D P1;
    Point3D P2;
    Point3D P3;
    Point3D P4;
    Point3D P5;
    Point3D P6;
    int H;
    int R;

    public HinhTru(Point3D P1,int R, int H) {
        this.H = H;
        this.R = R;
        this.P1 = P1;
        this.P2 = new Point3D(this.P1.getX()+R, this.P1.getY(), this.P1.getZ());
        this.P3 = new Point3D(this.P1.getX()-R, this.P1.getY(), this.P1.getZ());
        this.P4 = new Point3D(this.P1.getX(), this.P1.getY()+H, this.P1.getZ());
        this.P5 = new Point3D(this.P4.getX()+R, this.P4.getY(), this.P4.getZ());
        this.P6 = new Point3D(this.P4.getX()-R, this.P4.getY(), this.P4.getZ());
        
    }

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

    public int getH() {
        return H;
    }

    public void setH(int H) {
        this.H = H;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }
    
    public void drawHinhTru(Graphics g, Color mau){
//        new CircleLineBreak(P1.tranFormToPixel(), R).bresenhamCircleBreak(g, mau);
//        new Circle(P4.tranFormToPixel(), R).bresenhamCircle(g, mau);
          new DuongTron3D(P1, R).bresenhamCircle(g, mau);
          new DuongTron3D(P4, R).bresenhamCircle(g, mau);
//        new Eclip(P1.tranFormToPixel(), R, R/2).draweEllipseMidPoint(g, mau, false);
//        new Eclip(P4.tranFormToPixel(), R, R/2).draweEllipseMidPoint(g, mau, false);
        new Line(P2.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, Color.yellow);
        new Line(P3.tranFormToPixel(), P6.tranFormToPixel()).linebreak(g, Color.yellow);
    }
    
    
    
}
