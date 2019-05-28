/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

/**
 *
 * @author Mylov
 */
public class Rect {
    Pixel goc1;
    Pixel goc2;
    Pixel goc3;
    Pixel goc4;
    public Rect(Pixel goc1, Pixel goc3) {
        this.goc1 = goc1;
        this.goc3 = goc3;
        this.goc2= new Pixel(goc1.getX(), goc3.getY());
        this.goc4= new Pixel(goc3.getX(), goc1.getY());
    }

    public Rect(Pixel goc1, Pixel goc2, Pixel goc3, Pixel goc4) {
        this.goc1 = goc1;
        this.goc2 = goc2;
        this.goc3 = goc3;
        this.goc4 = goc4;
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
    public void draw(Graphics g,Color mau){
        
        new Line(goc1,goc2).Bresenham(g,mau);
        new Line(goc1, goc4).Bresenham(g,mau);
        new Line(goc2, goc3).Bresenham(g,mau);
        new Line(goc3, goc4).Bresenham(g,mau);
        goc1.draw(g,Color.red);
        goc2.draw(g,Color.RED);
        goc3.draw(g, Color.RED);
        goc4.draw(g, Color.RED);
    }
    public  Rect TinhTien(int x, int y){
        return new Rect(goc1.TinhTien(x, y), goc2.TinhTien(x, y), goc3.TinhTien(x, y), goc4.TinhTien(x, y));
    }
    public Rect Quay(int Do){
        return new Rect(goc1.Quay(Do), goc2.Quay(Do), goc3.Quay(Do), goc4.Quay(Do));
    }
    public Rect DoiXungOx(){
        return new Rect(goc1.DoiXungOx(), goc2.DoiXungOx(), goc3.DoiXungOx(), goc4.DoiXungOx());
    }
    public Rect DoiXungOy(){
        return new Rect(goc1.DoiXungOy(), goc2.DoiXungOy(), goc3.DoiXungOy(), goc4.DoiXungOy());
    }
    public Rect DoiXungO(){
        return new Rect(goc1.DoiXungO(), goc2.DoiXungO(), goc3.DoiXungO(), goc4.DoiXungO());
    }
    public Rect Scaling(int x, int y){
        return new Rect(
                goc1.Scaling(x, y),goc2.Scaling(x, y),goc3.Scaling(x, y),goc4.Scaling(x, y));
//                goc1.TinhTien(-goc1.getX(), -goc1..Scaling(x, y).TinhTien(goc1.getX(), goc1.getY()),
//                goc2.TinhTien(-goc1.getX(), -goc1.getY()).Scaling(x, y).TinhTien(goc1.getX(), goc1.getY()),
//                goc3.TinhTien(-goc1.getX(), -goc1.getY()).Scaling(x, y).TinhTien(goc1.getX(), goc1.getY()),
//                goc4.TinhTien(-goc1.getX(), -goc1.getY()).Scaling(x, y).TinhTien(goc1.getX(), goc1.getY()));
    }
    public Rect DoiXungQuaDuongThang(Pixel p1, Pixel p2){
        return new Rect(goc1.DoiXungQuaDuongThang(p1, p2),
                goc2.DoiXungQuaDuongThang(p1, p2),
                goc3.DoiXungQuaDuongThang(p1, p2),
                goc4.DoiXungQuaDuongThang(p1, p2));
    }
    public Rect DoXungQuaDiem(Pixel p1){
        return  new Rect(goc1.DoiXungQuaDiem(p1),
                goc2.DoiXungQuaDiem(p1),
                goc3.DoiXungQuaDiem(p1),
                goc4.DoiXungQuaDiem(p1));
    }
    public Rect QuayQuanhDiem(Pixel p1, float Do){
        return new Rect(goc1.QuayQuanhDiem(p1, Do),
                goc2.QuayQuanhDiem(p1, Do),
                goc3.QuayQuanhDiem(p1, Do),
                goc4.QuayQuanhDiem(p1, Do));
    }
}
