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
public class CircleLineBreak {
    private Pixel tam;
    private int bankinh;

    public Pixel getTam() {
        return tam;
    }

    public void setTam(Pixel tam) {
        this.tam = tam;
    }
    public int getBankinh() {
        return bankinh;
    }
    
    public void setBankinh(int bankinh) {
        this.bankinh = bankinh;
    }

    public CircleLineBreak(Pixel tam, int bankinh) {
        this.tam = tam;
        this.bankinh = bankinh;
    }
    public void drawCircle( int x, int y,Graphics g,Color mau)
{       if(x%2!=0){
      //  new Pixel(tam.getX() + x, tam.getY() + y).draw(g,mau);
      //  new Pixel(tam.getX() - x, tam.getY() + y).draw(g,mau);
        new Pixel(tam.getX() + x, tam.getY() - y).draw(g,mau);
        new Pixel(tam.getX() - x, tam.getY() - y).draw(g,mau);
      //  new Pixel(tam.getX() + y, tam.getY() + x).draw(g,mau);
      //  new Pixel(tam.getX() - y, tam.getY() + x).draw(g,mau);
        new Pixel(tam.getX() + y, tam.getY() - x).draw(g,mau);
        new Pixel(tam.getX() - y, tam.getY() - x).draw(g,mau);
}
else{
        new Pixel(tam.getX() + x, tam.getY() + y).draw(g,mau);
        new Pixel(tam.getX() - x, tam.getY() + y).draw(g,mau);
        new Pixel(tam.getX() + x, tam.getY() - y).draw(g,mau);
        new Pixel(tam.getX() - x, tam.getY() - y).draw(g,mau);
        new Pixel(tam.getX() + y, tam.getY() + x).draw(g,mau);
        new Pixel(tam.getX() - y, tam.getY() + x).draw(g,mau);
        new Pixel(tam.getX() + y, tam.getY() - x).draw(g,mau);
        new Pixel(tam.getX() - y, tam.getY() - x).draw(g,mau);
}
}
    
    public void bresenhamCircleBreak( Graphics g,Color color)
    {
        //new Pixel(tam.getX(), tam.getY()).draw(g,color);
        int x = 0;
        int y = bankinh;
        int p =  (3 - 2 * bankinh);
        drawCircle( x, y,g,color);
        while (y >= x)
        {
            x++;
            if (p > 0)
            {
                y--;
                p = p + 4 * (x - y) + 10;
            }
            else
                p = p + 4 * x + 6;
                drawCircle( x, y,g,color);
            }
    }
    public Circle Quay(int Do){
        return new Circle(tam.Quay(Do), bankinh);
    }
    public Circle TinhTien(int x,int y){
        return  new Circle(tam.TinhTien(x, y), bankinh);
    }
    public Circle DoiXungO(){
        return  new Circle(tam.DoiXungO(), bankinh);
    }
    public Circle DoiXungQuaOx(){
        return new Circle(tam.DoiXungOx(), bankinh);
    }
    public Circle DoiXungQuaOy(){
        return new Circle(tam.DoiXungOy(), bankinh);
    }
    public Circle Scaling(int x, int y){
        return new Circle(tam.Scaling(x, y), bankinh*x);
    }
    public Circle DoiXungQuaDuongThang(Pixel p1,Pixel p2){
        return new Circle(tam.DoiXungQuaDuongThang(p1, p2), bankinh);
    }
    public Circle DoiXungQuaDiem(Pixel p1){
        return new Circle(tam.DoiXungQuaDiem(p1), bankinh);
    }
    public Circle QuayQuanhDiem(Pixel p1, float Do){
        return new Circle(tam.QuayQuanhDiem(p1, Do), bankinh);
    }
    
   
}
