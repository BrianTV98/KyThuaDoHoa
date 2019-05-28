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
 * @author Mylov
 */
public class TamGiac {
    Pixel p1;
    Pixel p2;
    Pixel p3;

    public TamGiac(Pixel p1, Pixel p2, Pixel p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public Pixel getP1() {
        return p1;
    }

    public void setP1(Pixel p1) {
        this.p1 = p1;
    }

    public Pixel getP2() {
        return p2;
    }

    public void setP2(Pixel p2) {
        this.p2 = p2;
    }

    public Pixel getP3() {
        return p3;
    }

    public void setP3(Pixel p3) {
        this.p3 = p3;
    }
    public void draw(Graphics g,Color color){
        new Line(p1, p2).Bresenham(g, color);
        new Line(p2, p3).Bresenham(g, color);
        new Line(p1, p3).Bresenham(g, color);
    }
    public TamGiac TinhTien(int x, int y){
        return new TamGiac(p1.TinhTien(x, y), p2.TinhTien(x, y), p3.TinhTien(x, y));
    }
    public TamGiac Quay(float Do){
        return new TamGiac(p1.Quay(Do), p2.Quay(Do), p3.Quay(Do));
    }
    public TamGiac DoiXungQuaOx(){
        return new TamGiac(p1.DoiXungOx(), p2.DoiXungOx(), p3.DoiXungOx());
    }
    public TamGiac DoiXungQuayOy(){
        return new TamGiac(p1.DoiXungOy(), p2.DoiXungOy(), p3.DoiXungOy());
    }
    public TamGiac DoiXungO(){
        return new TamGiac(p1.DoiXungO(), p2.DoiXungO(), p3.DoiXungO());
    }
    public TamGiac Scaling(int x, int y){
        return new TamGiac(
                p1.Scaling(x, y),p2.Scaling(x, y),p3.Scaling(x, y));
//                p1.TinhTien(-p1.getX(), -p1.getY()).Scaling(x, y).TinhTien(p1.getX(), p1.getY()),
//                p2.TinhTien(-p1.getX(), -p1.getY()).Scaling(x, y).TinhTien(p1.getX(), p1.getY()),
//               p3.TinhTien(-p1.getX(), -p1.getY()).Scaling(x, y).TinhTien(p1.getX(), p1.getY()));
                
    }
    public TamGiac DoiXungQuaDuongThang(Pixel p11, Pixel p21){
        return new TamGiac(p1.DoiXungQuaDuongThang(p11, p21),
                p2.DoiXungQuaDuongThang(p11, p21),
                p3.DoiXungQuaDuongThang(p11, p21));
                
    }
    public TamGiac DoXungQuaDiem(Pixel p){
        return  new TamGiac(p1.DoiXungQuaDiem(p),
                p2.DoiXungQuaDiem(p),
                p3.DoiXungQuaDiem(p));
          
    }
    public TamGiac QuayQuanhDiem(Pixel p, float Do){
        return new TamGiac(p1.QuayQuanhDiem(p, Do),
                p2.QuayQuanhDiem(p, Do),
                p3.QuayQuanhDiem(p, Do));
              
    }
}
