/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import com.sun.org.apache.bcel.internal.generic.L2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Mylov
 */
public class Line {
    Pixel goc1;
    Pixel goc2;
    
    Graphics g;

    public Line(Pixel goc1, Pixel goc2) {
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

    public void HoaDoiToaDo(Pixel p1,Pixel p2){
        int tmpX=p1.getX();
        int tmpY=p1.getY();
        p1.setX(p2.getX ());
        p2.setY(p2.getY());
        p2.setX(tmpX);
        p2.setY(tmpY);
    }
    public void Bresenham(Graphics g,Color mau){
        Pixel p1;
        Pixel p2;
        if(goc1.getX()>goc2.getX()){
            p1=goc2;
            p2=goc1;
        }
        else{
            p1=goc1;
            p2=goc2;
        }
        Pixel temp;
        int Dx = Math.abs(p2.getX() - p1.getX());
        int Dy = Math.abs(p2.getY() - p1.getY());
        int p = 2*Dy - Dx;
        int c1 = 2*Dy;
        int c2 = 2*(Dy-Dx);
        int x_unit =1, y_unit = 1;
        goc1.draw(g, mau);
        if(p1.getY()<=p2.getY()){
            int tempX = p1.getX();
            int tempY = p1.getY();
            temp=new Pixel(tempX, tempY);
            while(tempX!= p2.getX()){
            if (p<0) p += c1;
            else{
                p += c2;
                    tempY += y_unit;
                }
             tempX += x_unit; 
             temp.setX(tempX);
             temp.setY(tempY);
             temp.draw(g,mau);
            }
            if(p1.getX()==p2.getX()){
            while(tempY!=p2.getY()){
                tempY++;
                new Pixel(tempX, tempY).draw(g,mau);
            }
        }
        }
        else{
            System.out.println(p1.getX()+": "+p1.getY());
            System.out.println(p2.getY()+": "+p2.getY());
            int tempX = p1.DoiXungOx().getX();
            int tempY = p1.DoiXungOx().getY();
            System.out.println(p1.getX()+": "+p1.getY());
            System.out.println(p2.getY()+": "+p2.getY());
            temp=new Pixel(tempX, tempY);
            while(tempX!= p2.getX()){
                if (p<0) p += c1;
                 else{
                    p += c2;
                    tempY += y_unit;
                }
                tempX += x_unit; 
                temp.setX(tempX);
                temp.setY(tempY);
                temp.DoiXungOx().draw(g,mau);
            }
            if(p1.getX()==p2.getX()){
//              
                while(tempY!=p2.DoiXungOx().getY()){
                tempY++;
                new Pixel(tempX, tempY).DoiXungOx().draw(g,mau);
                }
            }
        }
        
    }
    public Line TinhTien(int x1,int y1){
        return new Line(goc1.TinhTien(x1, y1), goc2.TinhTien(x1, y1));
    }
    public Line DoiXungOx(){
        return new Line(goc1.DoiXungOx(), goc2.DoiXungOx());
    }
    public Line DoiXungOy(){
        return  new Line(goc1.DoiXungOy(), goc2.DoiXungOy());
    }
    public Line DoiXungO(){
        return new Line(goc1.DoiXungO(), goc2.DoiXungO());
    }
    public Line Rotate(float x){
        return new Line(goc1.Quay(x), goc2.Quay(x));
    }
    public Line Scaling(int x, int y){
        return new Line(goc1.TinhTien(-goc1.getX(), -goc1.getX()).Scaling(x, y).TinhTien(goc1.getX(), goc1.getY()), goc2.TinhTien(-goc1.getX(), -goc1.getX()).Scaling(x, y).TinhTien(goc1.getX(),goc1.getY() ));
    }
    public Line DoiXungQuaDiem(Pixel p1){
        return new Line(goc1.DoiXungQuaDiem(p1), goc2.DoiXungQuaDiem(p1));
    }
    public Line DoiXungQuaDuongThang(Pixel p1,Pixel p2){
        return  new Line(goc1.DoiXungQuaDuongThang(p1, p2), goc2.DoiXungQuaDuongThang(p1, p2));
    }
    public Line QuayQuanhMotDiem(Pixel p1, float Do){
        return new Line(goc1.QuayQuanhDiem(p1, Do), goc2.QuayQuanhDiem(p1, Do));
    }
    
}
