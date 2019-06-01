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
public class RectangleFull {
    Pixel P1;
    int dai;
    int rong;

    public RectangleFull(Pixel P1, int dai, int rong) {
        this.P1 = P1;
        this.dai = dai;
        this.rong = rong;
    }

    public Pixel getP1() {
        return P1;
    }

    public void setP1(Pixel P1) {
        this.P1 = P1;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }
    
    public void DrawRectFull(Graphics g, Color mau){
        for(int x=0; x<=this.getRong(); x++){
            new Line(new Pixel(this.P1.getX(), this.P1.getY()+x), new Pixel(this.P1.getX()+this.dai, this.P1.getY()+x)).Bresenham(g, mau);
        }
    }
    
}
