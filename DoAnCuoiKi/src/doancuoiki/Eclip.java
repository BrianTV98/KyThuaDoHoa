/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Boolean.TRUE;

/**
 *
 * @author Mylov
 */
public class Eclip {
    private Pixel tam;
    private int a;
    private int b;

    public Eclip(Pixel tam, int a, int b) {
        this.tam = tam;
        this.a = a;
        this.b = b;
    }

    public Pixel getTam() {
        return tam;
    }

    public void setTam(Pixel tam) {
        this.tam = tam;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    void drawEllipse(Graphics g,int x, int y,Color color, boolean half_dotted){
    int count=0;
    new Pixel(tam.getX() - x, tam.getY() + y).draw(g, color);
    new Pixel(tam.getX() + x, tam.getY() + y).draw(g, color);
    //neu ve nua vong ellipse ben trong su dung '.'
    if (half_dotted)
    {
        //neu da du 6 pixel thi new Pixel hien thi
        if(count==5)
        {
            new Pixel(tam.getX() - x, tam.getY() - y).draw(g, color);
            new Pixel(tam.getX() + x, tam.getY() - y).draw(g, color);
            //reset lai count
            count = 0;
        }
    }else //nguoc lai new Pixel binh thuong
    {
        new Pixel(tam.getX() - x, tam.getY() - y).draw(g, color);
        new Pixel(tam.getX() + x, tam.getY() - y).draw(g, color);
    }
    count++;
}
void draweEllipseMidPoint(Graphics g,Color color, boolean half_dotted)
{
        int count = 0;
        int a2 = a*a;
        int b2 = b*b;
        int twoa2 = 2 * a2;
        int twob2 = 2 * b2;
        int p;
        int x = 0;
        int y = b;
        int px = 0;
        int py = twoa2 * y;
        drawEllipse(g,x, y, Color.yellow, half_dotted);
    /* Vung 1 */
        p = (int) Math.round(b2 - (a2*b) + (0.25) * a2);
        while(px < py){
            x++;
            px += twob2;
            if(p < 0){
                p += b2 + px;
            }else{
                y--;
                py -= twoa2;
                p += b2 + px - py;
            }
            drawEllipse(g,x, y, Color.yellow, half_dotted);
        }
    /* Vung 2*/
        p = (int) Math.round(b2 * (x + 0.5)*(x + 0.5) + a2 * (y - 1)*(y - 1) - a2 * b2);
        while(y > 0){
            y--;
            py -= twoa2;
            if(p > 0){
                p += a2 - py;
            }else{
                x++;
                px += twob2;
                p += a2 - py + px;
            }
            drawEllipse(g,x, y, Color.yellow, half_dotted);
        }
    }
    public Eclip DoiXungO(){
        return new Eclip(tam.DoiXungO(), a, b);
    }
    public Eclip DoiXungOx(){
        return new Eclip(tam.DoiXungOx(), a, b);
    }
    public Eclip DoiXungOy(){
        return new Eclip(tam.DoiXungOy(), a, b);
    }
    public Eclip TinhTien(int x, int y){
        return new Eclip(tam.TinhTien(x, y), a, b);
    }
}
