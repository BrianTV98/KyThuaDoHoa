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
    public void Drawline(Graphics g){
        goc1.draw(g);
        for(int i=goc1.getX();i<goc2.getX();i=i+5){
             new Pixel(i, goc1.getY()).draw(g);
        }
        goc2.draw(g);
    }
    
}
