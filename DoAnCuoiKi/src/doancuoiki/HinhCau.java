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
public class HinhCau {
    Point3D P1;
    int R;

    public HinhCau(Point3D P1, int R) {
        this.P1 = P1;
        this.R = R;
    }

    public Point3D getP1() {
        return P1;
    }

    public void setP1(Point3D P1) {
        this.P1 = P1;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }
    
    public void drawHinhCau(Graphics g, Color mau){
        new Circle(P1.tranFormToPixel(), R).bresenhamCircle(g, mau);
        new Eclip(P1.tranFormToPixel(), R, R/2).draweEllipseMidPoint(g, mau, false);
        new Eclip(P1.tranFormToPixel(), R/3, R).draweEllipseMidPoint(g, mau, false);
    }
    
}
