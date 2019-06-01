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
public class HinhChop {
    Point3D P1;
    Point3D P2;
    Point3D P3;
    Point3D P4;
    Point3D P5;
    int d;
    int r;
    int h;

    public HinhChop(Point3D P1, int d, int r, int h) {
        this.P1 = P1;
        this.d = d;
        this.r = r;
        this.h = h;
        this.P2 = new Point3D(this.P1.getX()+d, this.P1.getY(), this.P1.getZ());
        this.P3 = new Point3D(this.P1.getX(), this.P1.getY(), this.P1.getZ()+r);
        this.P4 = new Point3D(this.P2.getX(), this.P1.getY(), this.P3.getZ());
        this.P5 = new Point3D(this.P2.getX()/2, this.P1.getY()+h, this.P3.getZ()/2);
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

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    public void drawHinhChop(Graphics g, Color mau){
        new Line(P1.tranFormToPixel(), P2.tranFormToPixel()).linebreak(g, mau);
        new Line(P1.tranFormToPixel(), P3.tranFormToPixel()).linebreak(g, mau);
        new Line(P2.tranFormToPixel(), P4.tranFormToPixel()).Bresenham(g, mau);
        new Line(P3.tranFormToPixel(), P4.tranFormToPixel()).Bresenham(g, mau);
        //Than
        new Line(P1.tranFormToPixel(), P5.tranFormToPixel()).linebreak(g, mau);
        new Line(P2.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, mau);
        new Line(P3.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, mau);
        new Line(P4.tranFormToPixel(), P5.tranFormToPixel()).Bresenham(g, mau);
    }
}
