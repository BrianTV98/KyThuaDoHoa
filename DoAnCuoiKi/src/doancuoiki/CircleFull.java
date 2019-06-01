/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author ASUS
 */
public class CircleFull {
    Pixel P1;
    int R;

    public CircleFull(Pixel P1, int R) {
        this.P1 = P1;
        this.R = R;
    }

    public Pixel getP1() {
        return P1;
    }

    public void setP1(Pixel P1) {
        this.P1 = P1;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }
    
    public void CircleFull(Graphics g, Color mau){
       // Graphics2D g2d = (Graphics2D) g;
       for(int x=0; x<=R; x++){
        new Circle(P1, x).bresenhamCircle(g, mau);
       }
//        for(int x=0; x<=(this.R*5); x++){
//            g2d.drawOval(this.P1.getX()*5, this.P1.getY()*5, x, x);
//        }
    }
    
}
