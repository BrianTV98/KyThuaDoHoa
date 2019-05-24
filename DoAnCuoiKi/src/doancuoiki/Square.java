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
    Pixel goc3;
    Pixel goc4;

    public Square(Pixel goc1, Pixel goc3) {
        this.goc1 = goc1;
        this.goc3 = goc3;
        this.goc2= new Pixel(goc1.getX(), goc3.getY());
        this.goc4= new Pixel(goc3.getX(), goc1.getY());
    }

    public Pixel getGoc3() {
        return goc3;
    }

    public void setGoc3(Pixel goc3) {
        this.goc3 = goc3;
    }

    public Pixel getGoc4() {
        return goc4;
    }

    public void setGoc4(Pixel goc4) {
        this.goc4 = goc4;
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
      
        new Line(goc1,goc2).Bresenham(g);
        new Line(goc1, goc4).Bresenham(g);
        new Line(goc2, goc3).Bresenham(g);
        new Line(goc3, goc4).Bresenham(g);
    }
    public  void TinhTien(int x, int y){
        this.goc1.TinhTien(x, y);
        this.goc2.TinhTien(x, y);
        this.goc3.TinhTien(x, y);
        this.goc4.TinhTien(x, y);
    }
    public void Rotate(int Do){
    }    
}
