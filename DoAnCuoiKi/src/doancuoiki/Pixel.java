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
public class Pixel  {
    private int x;
    private int y;

    Pixel(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pixel(int toaDoNguoiDungX, int toaDoNguoiDungY) {
        this.x = toaDoNguoiDungX;
        this.y = toaDoNguoiDungY;
    }
    public void draw(Graphics g,Color mau){
        ChuyenToaDo chuyen= new ChuyenToaDo(this.getX(), this.getY());
        Pixel temPixel= new Pixel(chuyen.NguoiDung_to_May().getX(), chuyen.NguoiDung_to_May().getY());
        g.setColor(mau);
         for(int i=-2;i<=2;i++){
            g.drawLine(temPixel.getX()-2, temPixel.getY()+i, temPixel.getX()+2, temPixel.getY()+i);
        }
    }
    public  Pixel TinhTien(int x1, int y1){
        return new Pixel(this.x+x1, this.y+y1);
    }
    
    public Pixel DoiXungOx(){
        return new Pixel(x, -this.y);
    }
    public Pixel DoiXungOy(){
        return new Pixel(-this.x, y);
    }
    public Pixel DoiXungO(){
        return new Pixel(-this.x, -this.y);
    }
    public Pixel Quay(double Do){
        float radian= (float) Math.toRadians(Do);
        int x1;
        int y1;
            x1=(int) Math.round((this.getX()*Math.cos(radian)-this.getY()*Math.sin(radian)));
            y1= (int)Math.round((this.getX()*Math.sin(radian)+this.getY()*Math.cos(radian)));
        return new Pixel(x1, y1);
    }
    
    public Pixel Scaling(int x, int y){
        return  new Pixel(this.x*x, this.y*y);
    }
    public Pixel DoiXungQuaDuongThang(Pixel p1, Pixel p2){
        float a= (float)(p2.getY()-p1.getY())/(p2.getX()-p1.getX());
        System.out.println(a);
        return new Pixel(x, y).TinhTien(-p1.getX(), -p1.getY()).Quay(-Math.toDegrees(Math.atan(a))).DoiXungOx().Quay(Math.toDegrees(Math.atan(a))).TinhTien(p1.getX(), p1.getY());
    }
    public Pixel DoiXungQuaDiem(Pixel p1){
        return new Pixel(x, y).TinhTien(-p1.getX(), -p1.getY()).DoiXungO().TinhTien(p1.getX(), p1.getY());
    }
    public Pixel QuayQuanhDiem(Pixel p1, float  Do){
        return new Pixel(x, y).TinhTien(-p1.getX(),-p1.getY()).Quay(Do).TinhTien(p1.getX(), p1.getY());
    }
}
