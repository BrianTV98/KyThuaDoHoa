/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

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
                tempY += y_unit;
            }
            tempX += x_unit;
             temp=new Pixel(tempX, tempY);
             temp.draw(g);
         }
    }
    
}
