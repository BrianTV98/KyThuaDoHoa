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
    public  Pixel TinhTien(int x1, int y1){
        this.x= this.x+x1;
        this.y= this.y+y1;
        return this;
    }
    
    public void DoiXungOx(){
        this.y=-this.y;
    }
    public void DoiXungOy(){
        this.x=-this.y;
    }
    public void DoiXungO(){
        this.x= -this.x;
        this.y=-this.y;
    }
    public void Quay(double Do){
        float radian= (float) Math.toRadians(Do);
        int x1;
        int y1;
        if((Do%90)==0) {
             x1=(int) (this.getX()*0-this.getY()*1);
             y1= (int)(this.getX()*1+this.getY()*0);
        }
        else{
            x1=(int) (this.getX()*Math.cos(radian)-this.getY()*Math.sin(radian));
            y1= (int)(this.getX()*Math.sin(radian)+this.getY()*Math.cos(radian));
        }
        this.setX(x1);
        this.setY(y1);
    }
    public void Scaling(int x, int y){
        this.setX(this.getX()*x);
        this.setY(this.getY()*y);
    }
}
