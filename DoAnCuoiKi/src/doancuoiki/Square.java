/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Graphics;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 *
 * @author Mylov
 */
public class Square {
    Pixel goc1;
    Pixel goc2;

    public Square(Pixel goc1, Pixel goc2) {
        this.goc1 = goc1;
        this.goc2 = goc2;
    }

    public Pixel getGoc1() {
        return goc1;
    }

    public void setGoc1(Pixel goc1) {
        this.goc1 = goc1;
    }

    public Pixel getGoc2() {
        return goc2;
    }

    public void setGoc2(Pixel goc2) {
        this.goc2 = goc2;
    }
    public void draw(Graphics g){
        Pixel goc12= new Pixel(this.getGoc1().getX(), this.getGoc2().getY());
        Pixel goc21= new Pixel(this.getGoc2().getX(), this.getGoc1().getY());
        new Line(goc1,goc12).Bresenham(g);
        new Line(goc1, goc21).Bresenham(g);
        new Line(goc12, goc2).Bresenham(g);
        new Line(goc21, goc2).Bresenham(g);
    }
    public  void TinhTien(int x, int y){
        this.goc1.TinhTien(x, y);
        this.goc2.TinhTien(x, y);
    }
    
}
