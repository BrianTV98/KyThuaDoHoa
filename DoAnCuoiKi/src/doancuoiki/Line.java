/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import com.sun.org.apache.bcel.internal.generic.L2D;
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
    public void Bresenham(Graphics g){
        if(this.goc1.getX()>this.goc2.getX()){
            Pixel gocTemp= goc1;
            goc1=goc2;
            goc2=gocTemp;
        }
        Pixel temp;
        int Dx = Math.abs(goc2.getX() - goc1.getX());
        int Dy = Math.abs(goc2.getY() - goc1.getY());
        int p = 2*Dy - Dx;
        int c1 = 2*Dy;
        int c2 = 2*(Dy-Dx);
        int tempX = goc1.getX();
        int tempY = goc1.getY();
        int x_unit =1, y_unit = 1;
        temp=new Pixel(tempX, tempY);
        temp.draw(g);
        while(tempX!= goc2.getX()){
            if (p<0) p += c1;
            else{
                p += c2;
                if(goc1.getY()<=goc2.getY()){
                    tempY += y_unit;
                }
                else{
                    tempY -= y_unit;
                }
            }
             tempX += x_unit; 
             temp=new Pixel(tempX, tempY);
             temp.draw(g);
        }
        //cum 3
//        goc1.draw(g);
//        goc2.draw(g);
        //...
        if(goc1.getX()==goc2.getX()){
            
            tempX=goc1.getX();
            tempY=goc1.getY();
//            new Pixel(1, tempY).draw(g);
            while(tempY!=goc2.getY()){
                tempY++;
                new Pixel(tempX, tempY).draw(g);
            }
        }
        //cum 4
//        goc1.draw(g);
//        goc2.draw(g);
    }
    public Line TinhTien(int x1,int y1){
        return new Line(goc1.TinhTien(x1, y1), goc2.TinhTien(x1, y1));
    }
    public Line DoiXungOx(){
//        this.goc1.DoiXungOx();
//        this.goc2.DoiXungOx();
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
    
}
