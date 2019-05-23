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
public class Pixel  {
    private int x;
    private int y;

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
    public void draw(Graphics g){
        ChuyenToaDo chuyen= new ChuyenToaDo(this.getX(), this.getY());
        chuyen.NguoiDung_to_May();
         for(int i=-2;i<=2;i++){
            g.drawLine(chuyen.getX()-2, chuyen.getY()+i, chuyen.getX()+2, chuyen.getY()+i);
        }
    }
}
